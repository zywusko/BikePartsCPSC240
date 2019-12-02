package com.company;
/**
 * Write a description of class SalesAssoc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesAssoc extends LoginAccount
{
    OfficeMan om = new OfficeMan();
    public double totalSales;
    public String name;
    public String pass;
    public String first;
    public String last;
    public String email;
    public double payment;

    public SalesAssoc() {
    }

    public SalesAssoc(String name, String pass, String first, String last, String email)
    {
        super(name, pass, first, last, email);
    }

    public String accountOptions()
    {
        return "test";
    }
    public void getTotalSales(){
        for(int i = om.startDate; i <= om.endDate; ++i){
            //totalSales = totalSales + BikePart.Cost;
        }
    }
    public void getPayment(){

        payment = om.SAsalary + payment;
    }
}