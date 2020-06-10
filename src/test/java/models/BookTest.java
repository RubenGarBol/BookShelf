
package models;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class BookTest   {

		private Book b;
		private Book book;
		private Book EmptyBook;

		@Before
		public void setUp() {
			b = new Book("LIBRO", "AUTOR", "SINOPSIS", 100, "LINK");
			book = new Book(b);
			EmptyBook = new Book();
		}

		@Test
		public void testGetBookName() {
			assertEquals("LIBRO", b.getBookName());
			assertEquals("LIBRO", book.getBookName());
			assertEquals("", EmptyBook.getBookName());
		}

		@Test
		public void testSetBookName() {
			b.setBookName("TITULO");
			assertEquals("TITULO", b.getBookName());
		}

		@Test
		public void testGetAuthor() {
			assertEquals("AUTOR", b.getAuthorName());
			assertEquals("AUTOR", book.getAuthorName());
			assertEquals("", EmptyBook.getAuthorName());
		}

		@Test
		public void testSetAuthor() {
			b.setAuthorName("ESCRITOR");
			assertEquals("ESCRITOR", b.getAuthorName());
		}

		@Test
		public void testGetSynopsis() {
			assertEquals("SINOPSIS", b.getSynopsis());
			assertEquals("SINOPSIS", book.getSynopsis());
			assertEquals("", EmptyBook.getSynopsis());
		}

		@Test
		public void testSetSynopsis() {
			b.setSynopsis("DESCRIPCION");
			assertEquals("DESCRIPCION", b.getSynopsis());
		}

		@Test
		public void testGetPages() {
			assertEquals(100, b.getPages());
			assertEquals(100, book.getPages());
			assertEquals(0, EmptyBook.getPages());
		}

		@Test
		public void testSetPages() {
			b.setPages(50);
			assertEquals(50, b.getPages());
		}

		@Test
		public void testGetCover() {
			assertEquals("LINK", b.getCover());
			assertEquals("LINK", book.getCover());
			assertEquals("", EmptyBook.getCover());
		}

		@Test
		public void testSetCover() {
			b.setCover("PORTADA");
			assertEquals("PORTADA", b.getCover());
		}

	}
