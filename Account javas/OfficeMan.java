
/**
 * Write a description of class OfficeMan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OfficeMan extends LoginAccount
{
       public OfficeMan(String name, String pass, String first, String last, String email)
       {
           super(name, pass, first, last, email);
       }
       
       public String accountOptions()
       {
           System.out.println("this is a test");
           return "test";
        } 
}
