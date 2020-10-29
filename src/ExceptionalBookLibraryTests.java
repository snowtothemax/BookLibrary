import java.text.ParseException;

/**
 * A class that tests methods in ExceptionLibrary
 * 
 * @author front
 *
 */
public class ExceptionalBookLibraryTests {

  private static ExceptionalLibrary library = new ExceptionalLibrary("Poop", "Barb", "1234");

  /**
   * tests the parseCardBarCode() method
   * 
   * @return boolean true if works correctly, false otherwise
   */
  public static boolean testLibraryParseCardBarCode() {
    boolean works = false;
    String test = "Head";
    try { // tests the parseCardBarCode() method
      library.parseCardBarCode(test, 1);
    } catch (ParseException errorOffset)// if caught, returns true
    {
      works = true;
      System.out.println(errorOffset.getMessage());
    }
    return works;
  }

  /**
   * tests the parseRunLibrarianCheckoutBookCommand() method
   * 
   * @return boolean true if works as expected, false otherwise
   */
  public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
    boolean works = false;
    try { // tests parseRunLibrarianCheckoutBookCommand() method
      String[] commands = new String[3];
      commands[1] = "butt";
      commands[2] = "dead";
      library.parseRunLibrarianCheckoutBookCommand(commands);
    } catch (ParseException e)// if caught, returns true
    {
      works = true;
      System.out.println(e.getMessage());
    }

    return works;
  }

  /**
   * Checks to see if the correct exceptions were thrown in the code and the correct message is
   * delivered
   * 
   * @return boolean false if the exception is not thrown correctly, true otherwise
   */
  public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
    boolean works = false;
    try {// try block to catch any exceptions
      String[] commands = new String[2];
      String[] commandsTest = new String[3];
      commands[1] = "1";
      commandsTest[1] = "1";
      Subscriber sub = new Subscriber("Art", 1234, "Madison", "8479517423");// casts
                                                                            // InstantiationException
      Book book = new Book("Deal", "Mark");
      sub.checkoutBook(book);
      library.parseRunSubscriberReturnBookCommand(commandsTest, sub);// casts ParseException
      library.removeBook(1);// removes the book from the library for further testing
    } catch (ParseException e) {
      works = true;
      System.out.println(e.getMessage());
    } catch (InstantiationException e) {
      System.out.println(e.getMessage());
    }
    return works;
  }

  /**
   * Tests the parseRunLibrarianLoadBooksCommand()
   * 
   * @return boolean true if it the books are loaded from the file as intended, else false if an
   *         exception is thrown
   */
  public static boolean testLibraryParseRunLibrarianLoadBooksCommand() {
    boolean works = true;
    try {
      ExceptionalLibrary library2 = new ExceptionalLibrary("Poop", "Barb", "1234");// new library
                                                                                   // that is clear
                                                                                   // with
                                                                                   // everything for
                                                                                   // accurate
                                                                                   // testing
      String[] commands = new String[2];
      commands[0] = "";
      commands[1] = "testBooks.txt";
      library2.parseRunLibrarianLoadBooksCommand(commands);
      return works;
    } catch (ParseException e) {// sets to false if an exception is thrown
      works = false;
      System.out.println(e.getMessage());
    }
    return works;
  }

  /**
   * Tests the parseRunLibrarianSaveBooksCommand() method
   * 
   * @return boolean true if no exceptions are thrown, false otherwise
   */
  public static boolean testLibraryParseRunLibrarianSaveBooksCommand() {
    boolean works = true;
    try {
      ExceptionalLibrary library2 = new ExceptionalLibrary("Poop", "Barb", "1234");// new library
                                                                                   // that is clear
                                                                                   // with
                                                                                   // everything for
                                                                                   // accurate
                                                                                   // testing
      String[] commands = new String[2];
      commands[0] = "";
      commands[1] = "newBooks.txt";
      library2.addBook("Art", "Randy");
      library2.parseRunLibrarianSaveBooksCommand(commands);
      library2.parseRunLibrarianLoadBooksCommand(commands);
      return works;
    } catch (ParseException e) {// sets to false if an exception is thrown
      works = false;
      System.out.println(e.getMessage());
    }
    return works;
  }

  /**
   * Main method that tests the methods of ExceptionalLibrary
   * 
   * @param args
   */
  public static void main(String[] args) {// runs all the tester methods
    System.out.println("testLibraryParseCardBarCode(): " + testLibraryParseCardBarCode());
    System.out.println("testLibraryParseRunLibrarianCheckoutBookCommand(): "
        + testLibraryParseRunLibrarianCheckoutBookCommand());
    System.out.println("testLibraryParseRunSubscriberReturnBookCommand(): "
        + testLibraryParseRunSubscriberReturnBookCommand());
    System.out.println("testLibraryParseRunLibrarianLoadBooksCommand(): "
        + testLibraryParseRunLibrarianLoadBooksCommand());
    System.out.println("testLibraryParseRunLibrarianSaveBooksCommand(): "
        + testLibraryParseRunLibrarianSaveBooksCommand());
  }
}
