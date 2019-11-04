import java.util.ArrayList;
/**
 * This class contains methods related to sorting.
 *
 * @author ZZywusco and Abdel Hamid Shehata 
 * 
 */
public class Sort
{

    private String name;

    /**
     * Paramaterized constructor for Sort objects
     * @param name String, the name of the object
     */
    public Sort(String name)
    {
        this.name = name;
    }

    /**
     * Sorts an ArrayList of BikePart objects by name
     *
     * @param inventoryList the list of BikePart objects to be sorted
     * @return an ArrayList of BikePart objects that has been sorted alphabetically by name
     */
    public ArrayList<BikePart> nameSort(ArrayList<BikePart> inventoryList)
    {
        int n = inventoryList.size();

        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                String first = inventoryList.get(j).getName();
                String second = inventoryList.get(j + 1).getName();
                first = first.substring(0,1).toUpperCase();
                second = second.substring(0,1).toUpperCase();
                char firstChar = first.charAt(0);
                char secondChar = second.charAt(0);

                if (firstChar > secondChar)
                {
                    BikePart temp = new BikePart();
                    temp = inventoryList.get(j);
                    inventoryList.set(j, inventoryList.get(j + 1));
                    inventoryList.set(j + 1, temp);
                }
            }
        }
        return inventoryList;

    }

    /**
     * Sorts an ArrayList of objects of type BikePart by their partnumber
     * @param inventoryList an ArrayList<BikePart> to be sorted
     * @return an ArrayList<BikePart> that has been sorted by number
     */
    public ArrayList<BikePart> numSort(ArrayList<BikePart> inventoryList)
    {
        int n = inventoryList.size();
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                int firstNum = inventoryList.get(j).getNumber();
                int secondNum = inventoryList.get(j + 1).getNumber();

                if (firstNum > secondNum)
                {
                    BikePart temp = new BikePart();
                    temp = inventoryList.get(j);
                    inventoryList.set(j, inventoryList.get(j + 1));
                    inventoryList.set(j+1, temp);
                }
            }
        }
        return inventoryList;
    }

        
}
