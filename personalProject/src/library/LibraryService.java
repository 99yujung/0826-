package library;

import java.util.ArrayList;

public class LibraryService {
	private static LibraryService servie = new LibraryService();
	public LibraryDAO dao = LibraryDAO.getInstance();

/*	private LibraryService(){ }
	public static LibraryService getInstance() {
		return service;
	}
*/
	public void libraryInsert(LibraryVO library) {
		dao.insert(library);
	}

	// dao.search(ISBN)
	public LibraryVO librarySearch(String ISBN) {
		LibraryVO library = dao.librarySearch(ISBN);
		return library;

	}

	public void libraryDelete(String ISBN) {
		dao.libraryDelete(ISBN);
	}

	public void libraryUpdate(LibraryVO library) {
		dao.update(library);
	}

	public ArrayList<LibraryVO> libraryList() {
		ArrayList<LibraryVO> list = dao.libraryList();
		return list;
	}

}
