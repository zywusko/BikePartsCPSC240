import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * SalesVan inherits from WareHouse and creates a van object that will
 * store inventory from the WareHouse.
 *
 * @author ZZywusko
 * @version Project 2
 */
public class SalesVan extends WareHouse
{

    /**
     * Constructor for objects of class SalesVan. Uses the super constructor from the WareHouse class
     */
    public SalesVan(String n, ArrayList<BikePart> inventory)
    {
        super(n, inventory);
    }

    /**
     * constructor needing 
     */
    public SalesVan(String n)
    {
        this.name = n;
        this.inventory = new ArrayList<BikePart>(10);
    }
}
