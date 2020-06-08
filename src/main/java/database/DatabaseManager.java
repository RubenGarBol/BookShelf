package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


import models.Book;


public class DatabaseManager {

		private static Exception lastError = null;  // Información de último error SQL ocurrido
		private static final String HOST = "ec2-54-247-118-139.eu-west-1.compute.amazonaws.com/d4od6io6djo5n2";
		private static final String USERNAME= "fdfxbayznyqkol";
		private static final String PASSWORD ="00835ba68610e674b09df54a8b05b9982bef675946c38b13dfe24e463212bf9c" ;
		private static Connection conn;
		private static Logger logger;
		
		/**metodo para iniciar conexion con BD
		 * @return conexion de la base de datos
		 */
		public static Connection initBD() {
			  try {
				Class.forName("org.postgresql.Driver");
			    conn = DriverManager.getConnection("jdbc:postgresql://"+ HOST +"?sslmode=require",USERNAME,PASSWORD);				
			   return conn;
			  } catch (ClassNotFoundException | SQLException  e) {
				lastError = e;
				e.printStackTrace();
				return null;
			  }	
		}

				
		/** Cierra la base de datos abierta
		 * @param con	Conexión abierta de la BD
		 * @param st	Sentencia abierta de la BD
		 */
		public static boolean cerrarBD( final Connection con, final Statement st ) {
			
				try {
					if (st!=null) st.close();
					if (con!=null) con.close();
					return true;
				} catch (SQLException e) {
					lastError = e;				
					e.printStackTrace();
					return false;
				}		
		}
		
		/**
		 * Método que permite recuperar todos los libros de la base de datos
		 * 
		 * @author Rubén García Bolaños
		 * 
		 * @return books ArrayList con todas los libros que hay en la base de datos
		 */

		public static ArrayList<Book> getBooks(){
			String sql = "select * from " + "Book";
			PreparedStatement stmt;

			ArrayList<Book> books = new ArrayList<Book>();

			try {
				stmt = conn.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()){

					Book b = new Book();
					b.setBookName(rs.getString("BookName"));
					b.setAuthorName(rs.getString("AuthorName"));
					b.setSynopsis(rs.getString("Synopsis"));
					b.setPages(rs.getInt("Pages"));
					b.setCover(rs.getString("Cover"));
					books.add(b);
				}

				log(Level.INFO, "Obteniendo los libros", null);
			} catch (SQLException e) {
				log(Level.SEVERE, "Error al obtener los libros", e);
				e.printStackTrace();
			}
			return books;
		}


		/**
		 * Método que permite añadir un libro a la base de datos
		 * 
		 * @author Rubén García Bolaños
		 * 
		 * @param b Libro que se quiere añadir a la base de datos
		 */

		public static void addNewBook(Book b){
			//( " + "bookname" + " , " + "authorname" + " , " + "synopsis"+ " , " + "pages"+ " , " + "cover" + " )
			String sql  = "insert into book values (?,?,?,?,?)";

			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, b.getBookName());
				stmt.setString(2, b.getAuthorName());
				stmt.setString(3, b.getSynopsis());
				stmt.setInt(4, b.getPages());
				stmt.setString(5, b.getCover());

				stmt.executeUpdate();

				log(Level.INFO, "El libro " + b.getBookName() + " ha sido añadido", null);
			} catch (SQLException e) {
				log( Level.SEVERE, "Error al insertar el libro " + sql, e );
				setLastError(e);
				e.printStackTrace();
			}
		}

		/**
		 * Método que permite eliminar un libro a la base de datos
		 * 
		 * @author Rubén García Bolaños
		 * 
		 * @param book Nombre del libro a borrar
		 * @param author Nombre del autor a borrar
		 */

		public static void deleteBook(String book, String author) {
			//bookname =  " + book + " and
			 String SQL = "DELETE FROM book WHERE bookname = ?";
     
			 PreparedStatement stmtBorrar;
				try {
					stmtBorrar = conn.prepareStatement(SQL);

					stmtBorrar.setString(1, book);

					stmtBorrar.executeUpdate();

				
				log(Level.INFO, "El libro " + book + " de "+ author +" ha sido borrado correctamente", null);
			} catch (SQLException e) {
				log(Level.SEVERE, "No ha sido posible borrar el libro " + book + " de "+ author, e);
				e.printStackTrace();
			}
		}
		
		
		// Método público para asignar un logger externo
		public static void setLogger( Logger logger ) {
			DatabaseManager.logger = logger;
		}
		// Método local para loggear (si no se asigna un logger externo, se asigna uno local)
		private static void log( Level level, String msg, Throwable excepcion ) {
			if (logger==null) {  // Logger por defecto local:
				logger = Logger.getLogger( DatabaseManager.class.getName() );  // Nombre del logger - el de la clase
				logger.setLevel( Level.ALL );  // Loguea todos los niveles
				try {
					// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
					logger.addHandler( new FileHandler("logger.xml", true ) );  // Y saca el log a fichero xml
				} catch (Exception e) {
					logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
				}
			}
			if (excepcion==null) {
				logger.log(level, msg);
			}
			else {
				logger.log(level, msg, excepcion);
			}
		}

		public static Exception getLastError() {
			return lastError;
		}

		public static void setLastError(Exception lastError) {
			DatabaseManager.lastError = lastError;
		}

		
	}

