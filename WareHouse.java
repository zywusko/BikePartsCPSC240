package com.company;

import java.util.*;

/**
 *
 * @author Alex Barbuzza
 *
 */

public class WareHouse {
    protected String invFileName;
    protected String inventory;

    /**
     * @param
     * @return
     * @return
     */
    public void getInventory(){ //needs to use the ReadWrite; method needs to be redone

    }
    public String readInventory(String invFileName){ //needs to use the ReadWrite; method needs to be redone
        return inventory;
    }
    public void RemoveFromWareHouse(ArrayList<BikePart> currentInventory, ArrayList<String> wareHouseInventory){//needs to use the ReadWrite; method needs to be redone

        for(int i = 0; i < wareHouseInventory.size(); ++i){
            if(currentInventory.get(i).equals(wareHouseInventory.get(i))){
                int j = Integer.parseInt(wareHouseInventory.get(i));
                String newNum = Integer.toString(j);
                wareHouseInventory.set(i, newNum);
            }
        }
    }
    public void AddtoWareHouse(ArrayList<BikePart> currentInventory, ArrayList<String> wareHouseInventory){//needs to use the ReadWrite; method needs to be redone

        for(int i = 0; i < wareHouseInventory.size(); ++i){
            if(currentInventory.get(i).equals(wareHouseInventory.get(i))){
                int j = Integer.parseInt(wareHouseInventory.get(i));
                String newNum = Integer.toString(j);
                wareHouseInventory.set(i, newNum);
            }
        }
    }
}