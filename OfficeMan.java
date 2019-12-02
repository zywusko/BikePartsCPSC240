package com.company;
import java.util.*;

/**
 * Write a description of class OfficeMan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OfficeMan extends LoginAccount {
    public double SAsalary;
    public int startDate;
    public int endDate;

    public OfficeMan(){

    }

    public OfficeMan(String name, String pass, String first, String last, String email) {
        super(name, pass, first, last, email);
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

    }
    public void SalesCommision(String name, int startDate, int endDate) {
        SalesAssoc sa = new SalesAssoc();
        SAsalary = sa.totalSales * 0.15;
        sa.name = name;

    }
}