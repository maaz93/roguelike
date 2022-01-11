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

import base.Game;
import characters.AbstractFabriqueMonster;
import characters.FabriqueMonster;
import characters.Hero;
import characters.Monster;
import exceptions.NoHeroInRoomException;
import item.AbstractFabriqueItem;
import item.FabriqueItem;
import item.Item;

import java.io.IOException; // builder.parse()

public class DonjonBuilderXML {

	private Room currentRoom;
	
	
	public Room getCurrentRoom() {
		return currentRoom;
	}



	private Element getDonjonElement(String xmlFile) {
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
	
	public Donjon build(String xmlFile) {
		Element donjonElement = getDonjonElement(xmlFile);
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
		parseItems(roomElem, plateau);
		Room room = new Room(plateau,monsters);
		if (parseHero(roomElem, plateau) == true) {
			room = new Room(plateau,monsters);
			currentRoom = room;
		}	
		
		return room;
	}


	private List<Monster> parseMonsters(Element roomElem, Plateau<Case> plateau) {
		AbstractFabriqueMonster Fm = new FabriqueMonster();
		List<Monster> monsters = new ArrayList<Monster>();
		
		NodeList nodeList = roomElem.getElementsByTagName("characters").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element characterElem = (Element) node;
				if(!characterElem.getElementsByTagName("type").item(0).getTextContent().equals("hero")) {
					Monster m = Fm.getMonster(characterElem.getElementsByTagName("type").item(0).getTextContent());
					int x_monster = Integer.parseInt(characterElem.getElementsByTagName("x").item(0).getTextContent());
					int y_monster = Integer.parseInt(characterElem.getElementsByTagName("y").item(0).getTextContent());
					monsters.add(m);
					plateau.get(y_monster).get(x_monster).addAcharacter(m);
				}
			}
		}
		return monsters;
	}
	
	public boolean parseHero(Element roomElem, Plateau<Case> plateau) {
		NodeList nodeList = roomElem.getElementsByTagName("characters").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element characterElem = (Element) node;
				if(characterElem.getElementsByTagName("type").item(0).getTextContent().equals("hero")) {
					int x = Integer.parseInt(characterElem.getElementsByTagName("x").item(0).getTextContent());
					int y = Integer.parseInt(characterElem.getElementsByTagName("y").item(0).getTextContent());
					int hp = Integer.parseInt(characterElem.getElementsByTagName("hp").item(0).getTextContent());
					int def = Integer.parseInt(characterElem.getElementsByTagName("def").item(0).getTextContent());
					int force = Integer.parseInt(characterElem.getElementsByTagName("force").item(0).getTextContent());
					Hero.getInstance().setDefense(def);
					Hero.getInstance().setForce(force);
					Hero.getInstance().setMaxHP(hp);
					Hero.getInstance().setHp(hp);
					plateau.get(y).get(x).addAcharacter(Hero.getInstance());
					return true ;
				}
			}
		}
		return false;
	}
	private void parseCaseEscalier(Element caseEscalierElem, Plateau<Case> plateau) {
		int x_escalier = Integer.parseInt(caseEscalierElem.getElementsByTagName("x").item(0).getTextContent());
		int y_escalier = Integer.parseInt(caseEscalierElem.getElementsByTagName("y").item(0).getTextContent());
		plateau.remplaceCase(new CaseEscalier(x_escalier,y_escalier), x_escalier, y_escalier);
	}
	
	private void parseItems(Element roomElem, Plateau<Case> plateau) {
		AbstractFabriqueItem Fi = new FabriqueItem();
		
		NodeList nodeList = roomElem.getElementsByTagName("items").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element itemElem = (Element) node;
				Item it = Fi.getItem(itemElem.getElementsByTagName("type").item(0).getTextContent());
				int x_item = Integer.parseInt(itemElem.getElementsByTagName("x").item(0).getTextContent());
				int y_item = Integer.parseInt(itemElem.getElementsByTagName("y").item(0).getTextContent());
				plateau.get(y_item).get(x_item).addAnItem(it);
			}
		}
	}
}
