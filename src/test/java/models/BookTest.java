package models;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import javax.swing.Icon;

import org.junit.Before;
import org.junit.Test;


public class BookTest {

	private Book Book;
	private Book ParamBook;
	private Book EmptyBook;
	
	private String BookName;
	private String AuthorName;
	private String Synopsis;
	private String Cover;
	private int Pages;
	
	@Before
	public void setUp() {
		BookName = "La catedral del mar";
		AuthorName = "Ildefonso Falcones";
		Synopsis = "Siglo XIV, Barcelona. Bajo la Corona de Aragon, la Ciudad Condal se encuentra en su momento de mayor prosperidad y los habitantes del humilde barrio de pescadores de la Ribera deciden construir, con el dinero de unos y los esfuerzos de otros, el mayor templo mariano jamas conocido: Santa Maria del Mar.";
		Pages = 3;
		Cover = "https://cdn.pastemagazine.com/www/system/images/photo_albums/best-book-covers-fall-2019/large/bbcdune.jpg?1384968217";
		
		Book = new Book(BookName, AuthorName, Synopsis, Pages, Cover);
		ParamBook = new Book(Book);
		EmptyBook = new Book();
	}



	@Test
	public void testGetBookName() {
		assertEquals(BookName, Book.getBookName());
		assertEquals(BookName, ParamBook.getBookName());
		assertEquals("", EmptyBook.getBookName());
	}

	@Test
	public void testGetAuthorName() {
		assertEquals(AuthorName, Book.getAuthorName());
		assertEquals(AuthorName, ParamBook.getAuthorName());
		assertEquals("", EmptyBook.getAuthorName());
	}

	@Test
	public void testGetSynopsis() {
		assertEquals(Synopsis, Book.getSynopsis());
		assertEquals(Synopsis, ParamBook.getSynopsis());
		assertEquals("", EmptyBook.getSynopsis());
	}

	@Test
	public void testGetPages() {
		assertEquals(Pages, Book.getPages());
		assertEquals(Pages, ParamBook.getPages());
		assertEquals(0, EmptyBook.getPages());
	}
	
	@Test
	public void testGetCover() {
		assertEquals(Cover, Book.getCover());
		assertEquals(Cover, ParamBook.getCover());
		assertEquals("", EmptyBook.getCover());
	}


	@Test
	public void testSetBookName() {
		Book.setBookName("El juego de Ripper");
		assertEquals("El juego de Ripper", Book.getBookName());
	}

	@Test
	public void testSetAuthorName() {
		Book.setAuthorName("Isabel Allende");
		assertEquals("Isabel Allende", Book.getAuthorName());
	}

	@Test
	public void testSetSynopsis() {
		Book.setSynopsis("El juego de Ripper. Es una novela policial de la escritora chilena Isabel Allende");
		assertEquals("El juego de Ripper. Es una novela policial de la escritora chilena Isabel Allende", Book.getSynopsis());
	}

	@Test
	public void testSetPages() {
		Book.setPages(250);
		assertEquals(250, Book.getPages());
	}

	
}
