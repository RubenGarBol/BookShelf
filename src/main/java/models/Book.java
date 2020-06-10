package models;

/**
 * @author Rubén García
 * 
 * Clase que contiene la información de los libros
 */

public class Book {
	

	private String BookName;
	private String AuthorName;
	private String Synopsis;
	private int Pages;	
	private String Cover;
	
	
	/**
	 * Constructor vacio	
	 */  
	public Book() {
		super();		
		BookName = "";
		AuthorName = "";
		Synopsis = "";
		Pages = 0;
		Cover = "";
	}
	
	/**Constructor por parametros
	 * 
	 * @param bookName Nombre del libro
	 * @param authorName Nombre del autor
	 * @param synopsis Sinopsis del libro
	 * @param pages Numero de paginas del libro
	 * @param cover Link a la imagen de la portada del libro
	 */
	  
	public Book(String bookName, String authorName, String synopsis, int pages, String cover) {
		super();
		BookName = bookName;
		AuthorName = authorName;
		Synopsis = synopsis;
		Pages = pages;
		Cover = cover;
	}
	/**
	 * Constructor por objeto
	 *
	 * @param book Libro que se quiere añadir
	 */  
	public Book(Book book) {
		super();
		this.BookName = book.BookName;
		this.AuthorName = book.AuthorName;
		this.Synopsis = book.Synopsis;
		this.Pages = book.Pages;
		this.Cover = book.Cover;
	}

	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public String getSynopsis() {
		return Synopsis;
	}
	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}
	public int getPages() {
		return Pages;
	}
	public void setPages(int pages) {
		Pages = pages;
	}
	public String getCover() {
		return Cover;
	}
	public void setCover(String cover) {
		Cover = cover;
	}
}
