import java.util.Scanner;
/**
 * This is the main class that takes user input and then will display the items
 * under $20. 
 * @Zachary Zywusko
 * @9/22/2019
 */
public class Tester
{ 

    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Please provide number of parts:");
            int partNum=input.nextInt();
            BikeParts[] bikePartsArray= new BikeParts[partNum];

            //For loop that divides up String input into Array

            for (int i = 0; i<partNum; i++)
            {
                bikePartsArray[i] = new BikeParts(" ");
                System.out.println("Enter next part information:");

                String parsePart= input.next();
                String [] partsArray= parsePart.split(",");
                // diving up the input by parsing
                bikePartsArray[i].setName(partsArray[0]);
                bikePartsArray[i].setNumber(Integer.parseInt(partsArray[1]));
                bikePartsArray[i].setPrice(Double.parseDouble(partsArray[2]));
                bikePartsArray[i].setSalesPrice(Double.parseDouble(partsArray[3]));
                bikePartsArray[i].setSale(Boolean.parseBoolean(partsArray[4]));

            }
            // for loop containing nested if to determine <$20 and on sale
            for (int i = 0; i<bikePartsArray.length; i++){
                if ((bikePartsArray[i].getPrice()<20.00)|| ((bikePartsArray[i].getSale() == true)&&
                    (bikePartsArray[i].getSalesPrice() <20.00))){
                    String name = bikePartsArray[i].getName();
                    int num = bikePartsArray[i].getNumber();
                    double price = bikePartsArray[i].getPrice();
                    double salesPrice = bikePartsArray[i].getSalesPrice();
                    boolean onSale = bikePartsArray[i].getSale();
                    System.out.println(name+ "," + num+","+ price+","+ salesPrice+","+onSale);
                }
            }
/**This is a test for the partSort and numSort methods
 * 
 */

            BikeParts[] partSortArray= new BikeParts[partNum];
            partSort(bikePartsArray);
            

            for (int z=0; z<bikePartsArray.length; z++){
                System.out.println(bikePartsArray[z].getInfo());
            }
        }

        catch(Exception o){
            //@throws basic exception if input is out of range
            System.out.println("You have entered something incorrectly, please restart.");

        }
/** Two methods defined below sort by part name alphabetically and by part 
 * number, lowest to highest.
 */

    }
    public static void partSort(BikeParts[] arr)
    {
        int n = arr.length; 
        for (int i = 0; i < n-1; i++){ 
            for (int j = 0; j < n-i-1; j++){
                String first = arr[j].getName();
                String second= arr[j+1].getName();
                first = first.substring(0,1).toUpperCase();
                second = second.substring(0,1).toUpperCase();
                char firstChar = first.charAt(0);
                char secondChar = second.charAt(0);
                
                
                if (firstChar > secondChar) 
                { 
                    // swap arr[j+1] and arr[i] 
                    BikeParts temp = new BikeParts("PlaceHolder"); 
                    temp = arr[j];
                    arr[j]=(arr[j+1]); 
                    arr[j+1]=(temp); 
                } 

            }
        }
    }

    public static void numSort(BikeParts[] arr)
    {
        int n = arr.length; 
        for (int i = 0; i < n-1; i++){ 
            for (int j = 0; j < n-i-1; j++){
                int firstNum = arr[j].getNumber();
                int secondNum= arr[j+1].getNumber();

                if (firstNum > secondNum) 
                { 
                    // swap arr[j+1] and arr[i] 
                    BikeParts temp = new BikeParts("PlaceHolder"); 
                    temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 

            }
        }
    }
}

