package com.company;
import java.io.*;
import java.util.*;

public class Menu {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please select your option from the following menu:");
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
			if (answer == "Read") {

				i = 1;

			}
			if (answer == "Enter") {

				i = 1;

			}
			if (answer == "Sell") {

				i = 1;

			}
			if (answer == "Display") {

				i = 1;

			}
			if (answer == "SortName") {

				i = 1;

			}
			if (answer == "SortNumber") {

				i = 1;

			}
			if (answer == "Quit") {

				i = 1;

			}
			else {
				System.out.println("Invalid selection.  Input is case sensitive.");
				answer = scnr.next();
				i = 0;
			}
		}
	}
}