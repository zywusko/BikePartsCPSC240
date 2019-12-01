
/**
 * Write a description of class WHMan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WHMan extends LoginAccount
{
       public WHMan(String name, String pass, String first, String last, String email)
       {
           super(name, pass, first, last, email);
       }
       
       public String accountOptions()
       {
           return "test";
        }
}
