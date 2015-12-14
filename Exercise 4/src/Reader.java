
public class Reader {
	String name;
	Book[] books;
	int i = -1;

	public Reader(String name) {
		this.name = name;
		books = new Book[2];
	}

	public void getBooks() {
		System.out.println(name + " have books:");
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				System.out.println(books[i].getName());
			}
		}
	}

	public void setBook(Book book) {
		i++;
		if (i < books.length) {
			books[i] = book;
			System.out.println("Book-'" + book.getName() + "' was added to reader " + getName());
		} else {
			System.out.println("To much books you have");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
