package com.company;
import java.util.*;

/**
 * Write a description of class OfficeMan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OfficeMan extends LoginAccount {

    ReaderWriter readWrite = new ReaderWriter("readWrite");
    ReaderWriter rw = new ReaderWriter();
    BikePart bp = new BikePart();
    SalesAssoc sa = new SalesAssoc();
    public double SAsalary;
    public int startDate;
    public int endDate;

    public OfficeMan(String type, String name, String pass, String first, String last, String email) {
        super(type, name, pass, first, last, email);
    }

    public String accountOptions() {
        System.out.println("this is a test");
        return "test";
    }

    public void ExaminePart() {
        ArrayList<BikePart> currentInventory = new ArrayList<BikePart>(10);
        ReaderWriter readWrite = new ReaderWriter("readWrite");
        currentInventory.addAll(readWrite.readFromFile("WarehouseDB.txt"));
        System.out.println("What is the part name?");
        Scanner scnr = new Scanner(System.in);
        String partName = scnr.next();
        int found = 0;
        System.out.println("What is the part number?");
        String partNum = scnr.next();
        for (int z = 0; z < currentInventory.size(); z++) {
            if (currentInventory.get(z).getName().equals(partName) && currentInventory.get(z).getName().equals(partNum)) {
                found++;


                if (currentInventory.get(z).getOnSale() == true) {
                    System.out.println(currentInventory.get(z).partInfoSale());
                    z += currentInventory.size();
                } else if (currentInventory.get(z).getOnSale() == false) {
                    System.out.println(currentInventory.get(z).partInfoNoSale());
                    z += currentInventory.size();
                }
            }
        }
    }
    public void OrderPart() {
        ArrayList<BikePart> currentInventory = new ArrayList<BikePart>(10);
        currentInventory.addAll(readWrite.readFromFile("WarehouseDB.txt"));
        Menu m = new Menu();
        int minimum = 2;
        Scanner scnr = new Scanner(System.in);
        System.out.println("What part quantity (by name) would you like to check?");
        String answer = scnr.next();
        int found = 0;
        for (int z = 0; z < currentInventory.size(); z++)
        {
            if (currentInventory.get(z).getName().equals(answer))
            {
                found ++;
                }
            if((bp.getQuantity() <= minimum + 1)){
                System.out.println("Item is below or near minimum. Ordering additional parts.");
                String response = scnr.next();
                if(response == "yes"){
                    for(int i = bp.getQuantity(); i < minimum + 2; ++i){
                        bp.quantityUp();
                    }
                }
        }
            }
    }
    public double SalesCommision(String name, int startDate, int endDate) {
        double payment = 0.0;
        for(int i = startDate; i < endDate; ++i){
            if(i == sa.selldate){
                payment = sa.getSales(i) + sa.getSales(i-1);
            }
            SAsalary = payment * 0.15;
        }
        return SAsalary;
    }
}