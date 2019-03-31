

package timologio;


import java.util.*;
public class Timologio {
 private String kodikos;
    private String perigrafh;
    private int posothta;
    private double timhanaproion;
     
    public Timologio (String number, String description, int quantity, double price) {
        kodikos = number;
        perigrafh = description;
        posothta = quantity;
        timhanaproion = price;
    }
     
    public void dwsekodiko (String number) {
        kodikos = number;
    }
     
    public String parekwdiko () {
        return kodikos;
    }
     
    public void dwseperigrafh (String description) {
        perigrafh = description;
    }
     
    public String parepeigrafh () {
        return perigrafh;
    }
     
    public void dwseposothta (int quantity) {
        posothta = quantity;
    }
     
    public int pareposothta () {
        return posothta;
    }
     
    public void dwsetimhanaproion (double price) {
        timhanaproion = price;
    }
     
    public double paretimhanaproion () {
        return timhanaproion;
    }
     
    public double paretimh () {
        double upologismos;
        upologismos = posothta * timhanaproion;
        return upologismos;
    }
     
 
  
    public static void main (String [] args) {
 
 Timologio invoice = new Timologio (" ", " ", 0, 0.0);
 
 Scanner input = new Scanner (System.in);
         
        String item;
        String description;
        int quantity;
        double price;
         
        System.out.print ("dwse arithmo: ");
        item = input.nextLine();
        invoice.dwsekodiko(item);
         
        System.out.print ("dwse perigrafh tou proiontos: ");
        description = input.nextLine();
        invoice.dwseperigrafh(description);
         
        System.out.print ("dwse thn posothta tou proiontos: ");
        quantity = input.nextInt();
 if (quantity > 0)
        invoice.dwseposothta(quantity);
         
        System.out.println ("dwse thn timh giakathe proion: ");
        price = input.nextDouble();
 if (price > 0)
        invoice.dwsetimhanaproion (price);
         
      System.out.printf ("To synolo einai = $%.2f\n",
             invoice.paretimh());
 
    }
} 


    
        
        
        
    
    

