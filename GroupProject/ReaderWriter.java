import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
/**
 * Contains methods related to reading from and writing to text files.
 *
 * @author Abdel Hamid Shehata
 */
public class ReaderWriter
{

    private String name;

    /**
     * default constructor for objects of class ReaderWriter. sets the only field, name, to a placeholder.
     */
    public ReaderWriter()
    {

        this.name = "Placeholder";

    }

    /**
     * paramaterized constructor for ReaderWriter objects
     * @param name a String, the name of the object.
     */
    public ReaderWriter(String name)
    {
        this.name = name;

    }

    /**
     * ReadFromFile - this method reads the current inventory of a warehouse from the database text file so that the program has it in memory
     *
     * @param  file  the name of the file being read
     * @return    an ArrayList containing a list of parts
     */
    public ArrayList<BikePart> readFromFile(String file)
    {

        ArrayList<BikePart> bikePartsList = new ArrayList<BikePart>(0);  
        int numLines = 0;
        try{
            //this first try/catch block checks how many lines are in the text file. the number of lines is used in the later for loop
            FileInputStream scanningLines = new FileInputStream(file);
            Scanner scanLineNumbers = new Scanner(scanningLines);

            while (scanLineNumbers.hasNextLine()){
                numLines ++;
                String line = scanLineNumbers.nextLine();
            }
            scanLineNumbers.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not Found");
            e.printStackTrace();
        }
        try{
            FileInputStream partsInput = new FileInputStream(file);
            Scanner partsReader = new Scanner(partsInput);        
            //here the previously found number of lines is used to limit the for loop. This loop converts each line of the text file to a BikePart object,
            //then adds that object to the ArrayList which the method will return. 
            for (int i = 0; i < numLines; i++){
                String currentPart = partsReader.nextLine();
                String partsArray[] = currentPart.split(",");

                BikePart placeholder = new BikePart();
                placeholder.setName(partsArray[0]);
                placeholder.setNumber(Integer.parseInt(partsArray[1]));
                placeholder.setPrice(Double.parseDouble(partsArray[2]));
                placeholder.setSalesPrice(Double.parseDouble(partsArray[3]));
                placeholder.setOnSale(Boolean.parseBoolean(partsArray[4]));
                placeholder.setQuantity(Integer.parseInt(partsArray[5]));

                bikePartsList.add(placeholder);   

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found");
            e.printStackTrace();
        }    
        return bikePartsList;
    }

    /**
     * transferToFrom method used to determine the source and destination warehouses of a file transfer. 
     * 
     * @param file the inventory transfer file being read from
     * @return an array of Strings, the names of the warehouses being transferred between. Menu class will compare the Strings to the names of the warehouses.
     */

    public String[] sourceDest(String file)
    {
        String[] partsArray = new String[2];

        try{
            FileInputStream partsInput = new FileInputStream(file);
            Scanner partsReader = new Scanner(partsInput);              

            String currentPart = partsReader.nextLine();
            partsArray = currentPart.split(",");

        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found");
            e.printStackTrace();
        }
        return partsArray;
    }

    /**
     * method used to obtain an inventory list from a transfer file. 
     * @param file a String, the name of the text file being read from
     * @return an ArrayList<BikePart> which will be added or removed from warehouse inventories, as appropriate.
     */
    public ArrayList<BikePart> inventoryTransfer(String file)
    {
        ArrayList<BikePart> transferList = new ArrayList<BikePart>(10);
        int numLines = 0;

        try{

            FileInputStream scanningLines = new FileInputStream(file);
            Scanner scanLineNumbers = new Scanner(scanningLines);
            //this is the same number of lines trick as earlier
            while (scanLineNumbers.hasNextLine()){
                numLines ++;
                String line = scanLineNumbers.nextLine();
            }
            scanLineNumbers.close();

        }       
        catch(FileNotFoundException e){
            System.out.println("Error: File not found");
            e.printStackTrace();
        }            

        try{
            FileInputStream partsInput = new FileInputStream(file);
            Scanner partsReader = new Scanner(partsInput);
            for (int i = 0; i < numLines; i++)
            {
                String currentPart = partsReader.nextLine();
                String partsArray[] = currentPart.split(",");   
                if (i == 0)
                {
                    //the first line of these files provides the source and destination, which this method prints for the user to see.
                    System.out.println("Transferring from " + partsArray[0] + " to " + partsArray[1]);
                }
                else
                {

                    BikePart placeholder = new BikePart(partsArray[0], Integer.parseInt(partsArray[1]));
                    transferList.add(placeholder);
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found");
            e.printStackTrace();
        }

        return transferList;
    }

    
    /** 
     * writeToFile method used to write the contents of an inventory ArrayList to a text file.
     * @param file a String, the name of the text file to be written to.
     * @inventory an ArrayList of BikeParts, the inventory being written to the file.
     */        
    public void writeToFile(String file, ArrayList<BikePart> inventory)
    {

        try{
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < inventory.size(); i++)
            {
                writer.write(inventory.get(i).partInfo() + "\r\n");

            }
            writer.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found");   
        }
    }
}
