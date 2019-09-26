
/**
 * BikeParts stores information about a bicycle part.
 *
 * @ZZywusko
 * @9/4/2019
 */
public class BikePartsZZywuskoSORTMETHODSinside
{
    // instance variables
    private String name;
    private int partNumber;
    private double listPrice;
    private double salesPrice;
    private boolean onSale;

    /**
     * Constructor for objects of class Bike
     */
    public BikeParts( String n)
    {
        // initialise instance variables
        this.name=n;
        this.partNumber=0;
        this.listPrice=0.00;
        this.salesPrice=0.00; 
    }

    /**
     * Set Name of part
     *
     * @param  String name of part
     * @return None
     */
    public void setName(String n)
    {
        this.name= n;
    }
    
     /**
     * Set Number of part
     *
     * @param  int num of part
     * @return None
     */
    public void setNumber(int n)
    {
        this.partNumber= n;
    }
        
    /**
     * Set Price of part
     *
     * @param  Price of part
     * @return None
     */
    public void setPrice(double n)
    {
        this.listPrice= n;
    }
            
    /**
     * Set Sales price of part
     *
     * @param  Sales price of part
     * @return None
     */
    public void setSalesPrice(double n)
    {
        this.salesPrice= n;
    }
    
    /**
     * Declares whether part is on sale
     *
     * @param  Boolean value
     * @return None
     */
    public void setSale(boolean n)
    {
        this.onSale= n;
    }
    
    /**
     * Get Name of part
     *
     * @param  None
     * @return name of part
     */
    public String getName()
    {
        return this.name;
    }
    
     /**
     * get Number of part
     *
     * @param  None
     * @return Part Number
     */
    public int getNumber()
    {
        return this.partNumber;
    }
        
    /**
     * get non-sale Price of part
     *
     * @param  None
     * @return Price
     */
    public double getPrice()
    {
       return this.listPrice;
    }
            
    /**
     * Set Sales price of part
     *
     * @param  None
     * @return Sales Price of part
     */
    public double getSalesPrice()
    {
        return this.salesPrice;
    }
    
    /**
     * Declares whether part is on sale
     *
     * @param  None
     * @return whether or not part is on sale
     */
    public boolean getSale()
    {
        return this.onSale;
    }
    
    
    public String getInfo()
    {
      return this.name +" "+ this.partNumber+" "+ this.listPrice+" "+this.salesPrice+" "+this.onSale;

}
}


