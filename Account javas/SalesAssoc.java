
/**
 * Write a description of class SalesAssoc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesAssoc extends LoginAccount
{
       public SalesAssoc(String name, String pass, String first, String last, String email)
       {
           super(name, pass, first, last, email);
       }
       
       public String accountOptions()
       {
           return "test";
        }
}
