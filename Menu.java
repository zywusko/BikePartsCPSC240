package com.company;
import java.io.*;
import java.util.*;

public class Menu {

	public static void main(String[] args){
		String filename = null;
	    Scanner filescnr = new Scanner(new File(filename));
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please select your option from the following menu:"); //lists all options for the user to enter
		System.out.println("Read: Read a delivery file");
		System.out.println("Enter: Enter a part");
		System.out.println("Sell: Sell a part");
		System.out.println("Display: Display a part");
		System.out.println("SortName: Sort parts by name");
		System.out.println("SortNumber: Sort parts by part number");
		System.out.println("Quit:");
		System.out.println("Enter your choice:");
		String answer = scnr.next();
		int i = 0;
		
		while (i == 0) {
			if (answer.equalsIgnoreCase("Read")) {
				i = 1;
				System.out.println("What is the name of the inventory delivery file?");
				filename = scnr.next();
				try{
					filescnr.hasNext();
				}
				catch(Exception e){
					System.out.println("File does not exist.");
				}
			}
			else if (answer.equalsIgnoreCase("Enter")) {
				i = 1;
				System.out.println("What is the part name?");
				String partName = scnr.next();
				System.out.println("What is the part number?");
				long partNum = scnr.nextLong();
				System.out.println("What is the list price?");
				double listPrice = scnr.nextDouble();
				System.out.println("What is the sales price?");
				double salesPrice = scnr.nextDouble();
				System.out.println("Is the part on sale?  True or false?");
				boolean onSale = scnr.nextBoolean();
				System.out.println("What is the quantity of this part in stock?");
				int partQuantity = scnr.nextInt();
				
			}
			else if (answer.equalsIgnoreCase("Sell")) {
				i = 1;
				System.out.println("What is the part number?");
				long partNum = scnr.nextLong();
				
			}
			else if (answer.equalsIgnoreCase("Display")) {
				i = 1;
				System.out.println("What is the part name?");
				String partName = scnr.next();
			}
			else if (answer.equalsIgnoreCase("SortName")) {
				i = 1;
				
			}
			else if (answer.equalsIgnoreCase("SortNumber")) {
				i = 1;
				
			}
			else if (answer.equalsIgnoreCase("Quit")) {
				i = 1;
				
			}
			else{
				System.out.println("Invalid selection");
				answer = scnr.next();
			}
		}
		scnr.close();
	}
}