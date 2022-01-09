package characters;

public abstract class AbstractFabriqueMonster {
	public abstract Monster getGobelin();
	public abstract Monster getDragon();
	public abstract Monster getFantome();
	public abstract Monster getMonster(String monster);
	public abstract Monster getRandomMonster(int difficulte);
}
