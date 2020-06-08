
package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest   {

  @Test
  public void test00()  throws Throwable  {
      Book book0 = new Book();
      Book book1 = new Book(book0);
      assertEquals(0, book1.getPages());
  }

  @Test
  public void test01()  throws Throwable  {
      Book book0 = new Book();
      book0.setSynopsis((String) null);
      book0.getSynopsis();
      assertEquals(0, book0.getPages());
  }

  @Test
  public void test02()  throws Throwable  {
      Book book0 = new Book("E$yO?&", (String) null, "", (-2357), (String) null);
      String string0 = book0.getSynopsis();
      assertEquals((-2357), book0.getPages());
      assertEquals("E$yO?&", book0.getBookName());
      assertEquals("", string0);
      assertNotNull(string0);
  }

  @Test
  public void test03()  throws Throwable  {
      Book book0 = new Book();
      int int0 = book0.getPages();
      assertEquals(0, int0);
  }

  @Test
  public void test04()  throws Throwable  {
      Book book0 = new Book("P3Rf>", "", (String) null, 1, "9");
      int int0 = book0.getPages();
      assertEquals("P3Rf>", book0.getBookName());
      assertEquals("", book0.getAuthorName());
      assertEquals("9", book0.getCover());
      assertEquals(1, int0);
  }

  @Test
  public void test05()  throws Throwable  {
      Book book0 = new Book("!@?Y", "", "!@?Y", (-1), "!@?Y");
      assertEquals("!@?Y", book0.getBookName());
      
      book0.setBookName((String) null);
      book0.getBookName();
      assertEquals("!@?Y", book0.getSynopsis());
      assertEquals((-1), book0.getPages());
      assertEquals("!@?Y", book0.getCover());
      assertEquals("", book0.getAuthorName());
  }

  @Test
  public void test06()  throws Throwable  {
      Book book0 = new Book("u@Ht*O+R6+fC", (String) null, "models.Book", 376, "u@Ht*O+R6+fC");
      String string0 = book0.getAuthorName();
      assertEquals("u@Ht*O+R6+fC", book0.getBookName());
      assertNull(string0);
      assertEquals("models.Book", book0.getSynopsis());
      assertEquals("u@Ht*O+R6+fC", book0.getCover());
      assertEquals(376, book0.getPages());
  }

  @Test
  public void test07()  throws Throwable  {
      Book book0 = new Book("", "[P|yg_/@Sh", "", 2697, "[P|yg_/@Sh");
      String string0 = book0.getAuthorName();
      assertEquals("[P|yg_/@Sh", book0.getCover());
      assertEquals(2697, book0.getPages());
      assertEquals("", book0.getBookName());
      assertEquals("", book0.getSynopsis());
      assertEquals("[P|yg_/@Sh", string0);
  }

  @Test
  public void test08()  throws Throwable  {
      Book book0 = new Book("", "", ".HqhII", (-1), ".HqhII");
      String string0 = book0.getSynopsis();
      assertEquals((-1), book0.getPages());
      assertEquals(".HqhII", book0.getCover());
      assertEquals("", book0.getBookName());
      assertEquals(".HqhII", string0);
      assertEquals("", book0.getAuthorName());
  }

  @Test
  public void test09()  throws Throwable  {
      Book book0 = new Book("", "", ".HqhII", (-1), ".HqhII");
      assertEquals("", book0.getAuthorName());
      
      book0.setAuthorName("");
      assertEquals(".HqhII", book0.getCover());
      assertEquals(".HqhII", book0.getSynopsis());
      assertEquals((-1), book0.getPages());
      assertEquals("", book0.getBookName());
  }

  @Test
  public void test10()  throws Throwable  {
      Book book0 = new Book("", "", ".HqhII", (-1), ".HqhII");
      String string0 = book0.getCover();
      assertEquals((-1), book0.getPages());
      assertEquals("", book0.getBookName());
      assertEquals(".HqhII", string0);
      assertEquals(".HqhII", book0.getSynopsis());
      assertEquals("", book0.getAuthorName());
  }

  @Test
  public void test11()  throws Throwable  {
      Book book0 = new Book("", "", ".HqhII", (-1), ".HqhII");
      assertEquals(".HqhII", book0.getCover());
      
      book0.setCover("");
      book0.getCover();
      assertEquals("", book0.getAuthorName());
  }

  @Test
  public void test12()  throws Throwable  {
      Book book0 = new Book();
      book0.setCover((String) null);
      book0.getCover();
      assertEquals(0, book0.getPages());
  }

  @Test
  public void test13()  throws Throwable  {
      Book book0 = new Book("models.Book", "models.Book", "models.Book", (-1), "models.Book");
      book0.setBookName("");
      book0.getBookName();
      assertEquals((-1), book0.getPages());
  }

  @Test
  public void test14()  throws Throwable  {
      Book book0 = new Book();            
  }

  @Test
  public void test15()  throws Throwable  {
      Book book0 = new Book("models.Book", "models.Book", "models.Book", (-1), "models.Book");
      book0.setPages((-1));
      assertEquals((-1), book0.getPages());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Book book0 = new Book("models.Book", "models.Book", "models.Book", (-1), "models.Book");
      book0.getBookName();
      assertEquals((-1), book0.getPages());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Book book0 = new Book("models.Book", "models.Book", "models.Book", (-1), "models.Book");
      int int0 = book0.getPages();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Book book0 = new Book("", "", ".HqhII", (-1), ".HqhII");
      String string0 = book0.getAuthorName();
      assertEquals("", book0.getBookName());
      assertEquals(".HqhII", book0.getCover());
      assertEquals(".HqhII", book0.getSynopsis());
      assertEquals("", string0);
      assertEquals((-1), book0.getPages());
  }
}
