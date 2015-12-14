
public class Book {
	String name;
	boolean isTaken;
	String owner = "Library";

	public String getOwner() {

		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Book(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
