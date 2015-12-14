
public class Main {

	public static void main(String[] args) {

		Library lib = new Library(3, 3);
		Book a = new Book("War and Peace");
		Book b = new Book("V like vindetta");
		Book c = new Book("Dark Elf return");
		lib.addBook(a, 0);
		lib.addBook(b, 1);
		lib.addBook(c, 2);
		Reader r1 = new Reader("Paul");
		Reader r2 = new Reader("Micka");
		Reader r3 = new Reader("Jenny");
		lib.addReader(r1, 0);
		lib.addReader(r2, 1);
		lib.addReader(r3, 2);
		lib.showAllReaders();
		lib.addBookToReader(a, r1);
		lib.showAllBooksWithLocations();
		lib.addBookToReader(b, r1);
		lib.addBookToReader(c, r1);
		lib.seeBooksOfReader(r1);
		lib.seeBooksOfReader(r2);
		lib.findConcreteBookInReaders("V like vindetta");
	}

}
