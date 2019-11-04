import java.time.LocalDateTime;  
import java.io.*;
import java.util.*;

public class Menu {

    public static void main(String[] args){
        String filename;
        Scanner scnr = new Scanner(System.in);
        ReaderWriter readWrite = new ReaderWriter("readWrite");
        ArrayList<BikePart> mainInventory = new ArrayList<BikePart>(10);
        mainInventory.addAll(readWrite.readFromFile("mainWareHouse.txt"));
        Sort sorter = new Sort("Sorter");

        WareHouse mainWareHouse = new WareHouse("mainWareHouse", mainInventory );


        ArrayList<WareHouse> wareHouseList = new ArrayList<WareHouse>(10);
        wareHouseList.add(mainWareHouse);
        //lists all options for the user to enter
        System.out.println("Please select your option from the following menu:"); 
        System.out.println("Read: Read a delivery file to the main warehouse inventory");
        System.out.println("Enter: Enter a part");
        System.out.println("Sell: Sell a part");
        System.out.println("Display: Display a part");
        System.out.println("SortName: Sort parts by name");
        System.out.println("SortNumber: Sort parts by part number");
        System.out.println("Create: Create a new Sales Van");
        System.out.println("Transfer: Transfer inventory between locations");
        System.out.println("Quit:");
        System.out.println("Enter your choice:");

        String answer = scnr.next();

        //this while loop is the backbone of the menu. whenever an operation is completed, it returns to the loop for a new command
        int i = 0;      
        while (i == 0) {

            if (answer.equalsIgnoreCase("Read")) {
                //reads a delivery file to the main warehouse

                ArrayList<BikePart> incomingInventory = new ArrayList<BikePart>(10);
                System.out.println("What is the name of the inventory delivery file?");
                filename = scnr.next();

                incomingInventory = readWrite.readFromFile(filename);

                mainWareHouse.addToInventory(incomingInventory);

                for (int a = 0; a < mainWareHouse.getInventory().size(); a++)
                {
                    System.out.println(mainWareHouse.getInventory().get(a).partInfo());
                }

                System.out.println("Input next command.");
                answer = scnr.next();                            
            }

            else if (answer.equalsIgnoreCase("Enter")) {

                //add a new bike part individually to the main warehouse

                BikePart placeholder = new BikePart();
                System.out.println("What is the part name?");
                placeholder.setName(scnr.next());
                System.out.println("What is the part number?");
                placeholder.setNumber(scnr.nextInt());
                System.out.println("What is the list price?");
                placeholder.setPrice(scnr.nextDouble());
                System.out.println("What is the sales price?");
                placeholder.setSalesPrice(scnr.nextDouble());
                System.out.println("Is the part on sale?  True or false?");
                placeholder.setOnSale(scnr.nextBoolean());
                System.out.println("What is the quantity of this part in stock?");
                placeholder.setQuantity(scnr.nextInt());

                mainWareHouse.getInventory().add(placeholder);

                System.out.println("New part added to inventory");
                System.out.println("Input next command");
                answer = scnr.next();
            }

            else if (answer.equalsIgnoreCase("Sell")) {
                //sell an individual part - from any warehouse (or van)
                System.out.println("What location are you selling from?");
                String saleLocation = scnr.next();

                System.out.println("What is the part number?");
                int partNum = scnr.nextInt();
                int found = 0;
                for (int x = 0; x < wareHouseList.size(); x++)
                {
                    if (wareHouseList.get(x).getName().equals(saleLocation))
                    {
                        found++;
                        wareHouseList.get(x).sellPart(partNum);
                    }
                }
                if (found == 0)
                {
                    System.out.println("Error: Warehouse not found");
                }

                System.out.println("Input next command");
                answer = scnr.next();

            }

            else if (answer.equalsIgnoreCase("Display"))
            //displays an individual part from any warehouse or van

            {
                int found = 0;                  
                System.out.println("What is the part name?");
                String partName = scnr.next();

                System.out.println("Where is the part located?");
                String location = scnr.next();
                for (int q = 0; q < wareHouseList.size(); q++)
                {

                    if (location.equals(wareHouseList.get(q).getName()))
                    {

                        for (int z = 0; z < wareHouseList.get(q).getInventory().size(); z++)
                        {
                            if (wareHouseList.get(q).getInventory().get(z).getName().equals(partName))
                            {
                                found ++;

                                if (wareHouseList.get(q).getInventory().get(z).getOnSale() == true)
                                {
                                    System.out.println(wareHouseList.get(q).getInventory().get(z).partInfoSale());
                                    z += wareHouseList.get(q).getInventory().size();
                                }
                                else if (wareHouseList.get(q).getInventory().get(z).getOnSale() == false)
                                {
                                    System.out.println(wareHouseList.get(q).getInventory().get(z).partInfoNoSale());
                                    z += wareHouseList.get(q).getInventory().size();
                                }
                            }

                        }

                    }

                }
                if (found == 0)
                {
                    System.out.println("Part not found");
                }                              
                System.out.println("Input next command");
                answer = scnr.next();                
            }

            else if (answer.equalsIgnoreCase("SortName")) 

            //sorts inventories, either individual warehouses or all parts in all inventories.
            {
                System.out.println("Sort which location? Enter 'all' to sort all warehouses.");
                String sortLocation = scnr.next();
                if (sortLocation.equals("all"))
                {
                    ArrayList<BikePart> sortingAll = new ArrayList<BikePart>(10);
                    for (int a = 0; a < wareHouseList.size(); a++)
                    {
                        for (int c = 0; c < wareHouseList.get(a).getInventory().size(); c++)
                            sortingAll.add(wareHouseList.get(a).getInventory().get(c));
                    }

                    sortingAll = sorter.nameSort(sortingAll);
                    for (int b = 0; b < sortingAll.size(); b++)
                    {
                        System.out.println(sortingAll.get(b).partInfo());                        
                    }
                    System.out.println("Input next command");
                    answer = scnr.next();                              
                }
                else //if the user wants to sort an individual warehouse's inventory, the program comes here
                {
                    for (int a = 0; a < wareHouseList.size(); a++)
                    {
                        if (wareHouseList.get(a).getName().equals(sortLocation))
                        {
                            wareHouseList.get(a).setInventory((sorter.nameSort(wareHouseList.get(a).getInventory())));
                            for (int b = 0; b < wareHouseList.get(a).getInventory().size(); b++)
                            {
                                System.out.println(wareHouseList.get(a).getInventory().get(b).partInfo());
                            }
                        }        
                    }
                    System.out.println("Input next command");
                    answer = scnr.next();                              
                }
            }

            else if (answer.equalsIgnoreCase("SortNumber")) 
            //same as above, except sorting by number rather than name
            {
                System.out.println("Sort which location? Enter 'all' to sort all warehouses.");
                String sortLocation = scnr.next();
                if (sortLocation.equals("all"))
                {
                    ArrayList<BikePart> sortingAll = new ArrayList<BikePart>(10);
                    for (int a = 0; a < wareHouseList.size(); a++)
                    {
                        for (int c = 0; c < wareHouseList.get(a).getInventory().size(); c++)
                            sortingAll.add(wareHouseList.get(a).getInventory().get(c));
                    }

                    sortingAll = sorter.numSort(sortingAll);
                    for (int b = 0; b < sortingAll.size(); b++)
                    {
                        System.out.println(sortingAll.get(b).partInfo());                      
                    }
                    System.out.println("Input next command");
                    answer = scnr.next();                      
                }
                else 
                {
                    for (int a = 0; a < wareHouseList.size(); a++)
                    {
                        if (wareHouseList.get(a).getName().equals(sortLocation))
                        {
                            wareHouseList.get(a).setInventory((sorter.numSort(wareHouseList.get(a).getInventory())));
                            for (int b = 0; b < wareHouseList.get(a).getInventory().size(); b++)
                            {
                                System.out.println(wareHouseList.get(a).getInventory().get(b).partInfo());
                            }
                        }         
                    }
                    System.out.println("Input next command");
                    answer = scnr.next();                    
                }              
            }

            else if (answer.equalsIgnoreCase("Create"))
            //creates a new SalesVan object with an inventory transfer from the main warehouse
            {
                System.out.println("Enter the name of the new van's inventory transfer file");
                String transFile = scnr.next();

                String[] sourceDest = readWrite.sourceDest(transFile);
                ArrayList<BikePart> inventoryTransfer = readWrite.inventoryTransfer(transFile);

                SalesVan salesVan = new SalesVan(sourceDest[1]);
                wareHouseList.add(salesVan);

                //this checks if a part from the transfer file is in the source warehouse. If it is, subtracts the quantity being transferred from the quantity 
                //present.
                for (int a = 0; a < wareHouseList.size(); a++)
                {
                    if(wareHouseList.get(a).getName().equals(sourceDest[0]))
                    {
                        wareHouseList.get(a).transferFrom(inventoryTransfer);
                        wareHouseList.get(a).stillAround();
                        salesVan.transferTo(inventoryTransfer);
                        salesVan.stillAround();

                    }
                }
                for (int a = 0; a < salesVan.getInventory().size(); a++)
                {
                    System.out.println(salesVan.getInventory().get(a).partInfoShort());
                }
                System.out.println("Input next command");
                answer = scnr.next();                      
            }

            else if (answer.equalsIgnoreCase("Transfer"))
            //transfers between warehouses/vans
            {
                System.out.println("Enter name of inventory transfer file");
                String transFile = scnr.next();

                String[] sourceDest = readWrite.sourceDest(transFile);
                ArrayList<BikePart> inventoryTransfer = readWrite.inventoryTransfer(transFile);

                for(int a = 0; a < wareHouseList.size(); a++)
                {
                    //check for matching source, then remove inventory
                    if (wareHouseList.get(a).getName().equals(sourceDest[0]))
                    {
                        wareHouseList.get(a).transferFrom(inventoryTransfer);
                        wareHouseList.get(a).stillAround();
                    }
                }

                for(int a = 0; a < wareHouseList.size(); a++)
                {
                    //check for matching destination, then add inventory
                    if (wareHouseList.get(a).getName().equals(sourceDest[1]))
                    {
                        wareHouseList.get(a).transferTo(inventoryTransfer);
                        wareHouseList.get(a).stillAround();

                        for (int b = 0; a < wareHouseList.get(a).getInventory().size(); b++)
                        {
                            System.out.println(wareHouseList.get(a).getInventory().get(b).partInfoShort());
                        }    
                    }
                }

                System.out.println("Input next command");
                answer = scnr.next();  
            }


            else if (answer.equalsIgnoreCase("Quit"))
            //ends the program - writes the inventory of each warehouse to a text file
            {
                i = 1;
                for (int z = 0; z < wareHouseList.size(); z++)
                {
                    readWrite.writeToFile(wareHouseList.get(z).getName() + ".txt", wareHouseList.get(z).getInventory());
                }
                System.exit(0);
            }
            else{
                System.out.println("Invalid selection");
                answer = scnr.next();
            }
        }
        scnr.close();
    }
}