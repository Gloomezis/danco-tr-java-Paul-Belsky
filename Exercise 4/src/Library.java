
public class Library {
	Book[] books;
	Reader[] readers;

	public Library(int nbooks, int nreaders) {
		books = new Book[nbooks];
		readers = new Reader[nreaders];

	}

	public void addBook(Book book, int position) {
		books[position] = book;
	}

	public void addReader(Reader reader, int position) {
		readers[position] = reader;
	}

	public void addBookToReader(Book book, Reader reader) {
		reader.setBook(book);
		book.setOwner(reader.getName());
		book.isTaken=true;

	}

	public void seeBooksOfReader(Reader reader) {
		reader.getBooks();
	}

	public void findConcreteBookInReaders(String bookName) {

		for (int i = 0; i < books.length; i++) {
			if (books[i] != null && books[i].getName() == bookName)
				System.out.println("Book - '" + bookName + "' have " + books[i].getOwner());
		}

	}

	public void showAllBooksWithLocations() {
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				System.out.println(i + " " + books[i].getName() + "-" + books[i].getOwner());
			}
		}

	}

	public void showAllReaders() {
		for (int i = 0; i < readers.length; i++) {
			if (readers[i] != null) {
				System.out.println(i + " " + readers[i].getName());

			}
		}
	}
}
