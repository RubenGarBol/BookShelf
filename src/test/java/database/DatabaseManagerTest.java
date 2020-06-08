package database;

import models.Book;

import org.junit.Test;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Logger;
import static org.junit.Assert.*;

public class DatabaseManagerTest {

    @Test
    public void testInitBD() {
        final Connection result = DatabaseManager.initBD();

    }

    @Test
    public void testCerrarBD() {
        final Connection con = null;
        final Statement st = null;

        final boolean result = DatabaseManager.cerrarBD(con, st);

        assertEquals(true,result);
    }


    @Test
    public void testSetLogger() {
        final Logger logger = Logger.getLogger("name");

        DatabaseManager.setLogger(logger);
    }

    @Test
    public void testGetLastError() {
        final Exception result = DatabaseManager.getLastError();
    }

    @Test
    public void testSetLastError() {
        final Exception lastError = new Exception("message");

        DatabaseManager.setLastError(lastError);
    }
    
    @Test
    public void testAddDeleteBook() {
    	DatabaseManager.initBD();
    	Book book =  new Book();
    	DatabaseManager.addNewBook(book);
    	DatabaseManager.deleteBook(book.getBookName(), book.getAuthorName());
    	
    }
}
