package item;

public abstract class Item {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + "]";
	}

	@Override
	public abstract Item clone() ;

	public abstract void getSymbol();
	
	
}
