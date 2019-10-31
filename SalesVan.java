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
    // instance variables - replace the example below with your own
    private String vanName;
    private ArrayList<String> finalVan= new ArrayList<String>();
    private ArrayList<String> transferVan = new ArrayList<String>();
    /**
     * Constructor for objects of class SalesVan
     */
    public SalesVan(String n)
    {
        vanName = n;

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList<String> updateVan(ArrayList<String> warehouseArray, ArrayList<String> vanArray)
    {

        for(int i = 0; i<vanArray.size(); i++){
            String vanCompare = vanArray.get(i);
            String str[] = vanCompare.split(",");
            String vanItemName= str[0];
            int VANinvNum= Integer.valueOf(str[1]);

            for (int y = 0; y<warehouseArray.size(); i++){
                String warehouseCompare = warehouseArray.get(y);
                String strWH[] = warehouseCompare.split(",");
                String whItemName= str[0];
                //int wareInv = warehouseCompare.getQuantity();
                int WHinvNum= Integer.valueOf(str[1]);

                if (vanItemName == whItemName && VANinvNum<WHinvNum){
                    warehouseArray.remove(warehouseCompare);
                    int updatedValue= VANinvNum - WHinvNum;
                    finalVan.add(vanItemName+","+ updatedValue);
                }else if(vanItemName == whItemName && VANinvNum>WHinvNum)
                {
                    warehouseArray.remove(warehouseCompare);
                    int updatedValue= WHinvNum;
                    finalVan.add(vanItemName+","+ updatedValue);

                }

            }
        }
        return finalVan;
    }

    public ArrayList<String> transferVan(ArrayList<String> toVan, ArrayList<String> awayVan){
        for(int i = 0; i<toVan.size(); i++){
            String vanCompare = toVan.get(i);
            String str[] = vanCompare.split(",");
            String vanItemName= str[0];
            int VANinvNum= Integer.valueOf(str[1]);

            for(int y = 0; y<awayVan.size(); y++){
                String newVanCompare = awayVan.get(i);
                String newStr[] = newVanCompare.split(",");
                String newVanItemName= str[0];
                int newVANinvNum= Integer.valueOf(str[1]);

                if (vanItemName == newVanItemName){
                    awayVan.remove(y);
                    transferVan.remove(y);
                    transferVan.add(vanItemName +","+ (VANinvNum+newVANinvNum));
                }
            }
        }
        while (awayVan.size()>(-1)){
            for(int i = 0; i<awayVan.size(); i++){
                transferVan.add(awayVan.get(i));
            }
        }
        return transferVan;
    }
}

