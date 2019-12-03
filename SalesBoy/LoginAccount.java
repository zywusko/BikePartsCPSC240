
/**
 * Write a description of class LoginAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoginAccount implements Comparable<LoginAccount>
{
    private String userName;
    private String pass;
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    
    
    public LoginAccount(String type, String name, String pass, String first, String last, String email){
        this.userName = name;
        this.pass = pass;
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.type = type;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public String getUser()
    {
        return this.userName;
    }
    
    public void setUser(String user)
    {
        this.userName = user;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    
    public void setPass(String pass)
    {
        this.pass = pass;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }    
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public boolean login(String user, String pass)
    {
        if(user.equals(this.userName) && pass.equals(this.pass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        String accountDetails = (this.type + "," + this.userName + "," + this.pass  + ","  + this.firstName  + ","  + this.lastName  + ","  + this.email);
        return accountDetails;
    }
    
    public int compareTo(LoginAccount account)
    {
        return this.userName.compareTo(account.getUser());
    }
        
}
