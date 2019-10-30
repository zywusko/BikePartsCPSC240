package com.company;
/**
 * 
 * @author Alex Barbuzza
 *
 */

public class WareHouse {
	protected String invFileName;
	protected String inventory;

	/**
	 * @param args
	 * @return 
	 * @return 
	 */
	public void getInventory(){ //needs to use the ReadWrite; method needs to be redone
		
	}
	public String readInventory(String invFileName){ //needs to use the ReadWrite; method needs to be redone
		return inventory;
	}
	public void TransferToWarehouse(String inventory){//needs to use the ReadWrite; method needs to be redone
		/**
		 * n=1,2,3
		 * warehouse1,warehouse2,warehouse3.txt to differentiate between them?
		 * write to warehousen.txt
		 */
	}
	public void TransferToSalesVan(String inventory){//needs to use the ReadWrite; method needs to be redone
		/**
		 * n=1,2,3
		 * SalesVan1, 2, 3.txt to differentiate between them?
		 * write to SalesVann.txt
		 */
	}

}