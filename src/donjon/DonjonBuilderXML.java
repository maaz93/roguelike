package donjon;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// factory.newDocumentBuilder() can throw a ParserConfigurationException
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; // builder.parse()

import characters.FabriqueMonster;
import characters.Monster;

import java.io.IOException; // builder.parse()

public class DonjonBuilderXML {

	
	private Element getMainElement(String xmlFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xmlFile);
			return document.getDocumentElement();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.err.println("Error parsing XML: " + e.getMessage());
		}
		return null;
	}
	
	
	public Donjon build(Element mainElement) {
		Element donjonElement = (Element) mainElement.getElementsByTagName("donjon").item(0).getChildNodes();
		List<Room> rooms = parseRooms(donjonElement);
		
		return new Donjon(rooms);
	}

	private List<Room> parseRooms(Element donjonElement) {
		List<Room> rooms = new ArrayList<Room>();
		NodeList nodeList = donjonElement.getElementsByTagName("rooms").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element roomElem = (Element) node;
				rooms.add(parseRoom(roomElem));
			}
		}
		return rooms;
	}



	private Room parseRoom(Element roomElem) {
		int longueur = Integer.parseInt(roomElem.getElementsByTagName("longueur").item(0).getTextContent());
		int hauteur = Integer.parseInt(roomElem.getElementsByTagName("hauteur").item(0).getTextContent());
		Plateau<Case> plateau = new Plateau<>(longueur, hauteur);
		parseCaseEscalier((Element) roomElem.getElementsByTagName("caseEscalier").item(0).getChildNodes(),plateau);

		List<Monster> monsters = parseMonsters(roomElem,plateau);
		
		return new Room(plateau,monsters);
	}


	private List<Monster> parseMonsters(Element roomElem, Plateau<Case> plateau) {
		FabriqueMonster Fm = new FabriqueMonster();
		List<Monster> monsters = new ArrayList<Monster>();
		
		NodeList nodeList = roomElem.getElementsByTagName("characters").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element monsterElem = (Element) node;
				Monster m = Fm.getMonster(monsterElem.getElementsByTagName("type").item(0).getTextContent());
				int x_monster = Integer.parseInt(monsterElem.getElementsByTagName("x").item(0).getTextContent());
				int y_monster = Integer.parseInt(monsterElem.getElementsByTagName("y").item(0).getTextContent());
				monsters.add(m);
				plateau.get(y_monster).get(x_monster).addAcharacter(m);
			}
		}
		return monsters;
	}
	
	private void parseCaseEscalier(Element caseEscalierElem, Plateau<Case> plateau) {
		int x_escalier = Integer.parseInt(caseEscalierElem.getElementsByTagName("x").item(0).getTextContent());
		int y_escalier = Integer.parseInt(caseEscalierElem.getElementsByTagName("y").item(0).getTextContent());
		plateau.remplaceCase(new CaseEscalier(x_escalier,y_escalier), x_escalier, y_escalier);
	}
}
