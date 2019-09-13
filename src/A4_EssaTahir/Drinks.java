/** Name:  Essa Tahir
 * Assignment:  Assignment2
 * Program: PROG24178
 *
 * Making Pizza order program
 */
package A4_EssaTahir;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 *
 * @author Essa OG
 */
/*

*/
public class Drinks extends VBox {
    
    /*
    * for storing drinks prices
    */
    private double cokePrice ;
    private double juicePrice ;
    private double milkPrice; 
    
    /*
    * radiobtton to select which drink
    */
    protected RadioButton rbtCoke;
    protected RadioButton rbtJuice;
    protected RadioButton rbtMilk;
    
    /*
    * ToggleGroup to select which drink
    */
    private ToggleGroup drinks1;
    
    /*
    * Label for the text field
    */
    private Label lblDrinks;
    /*
    * text field for input
    */
    
    protected TextField txaDrinks;
    
    /*
    * constructor for calling drinks
    */
    public Drinks(){
        super(10);
        this.cokePrice = 1.25;
        this.juicePrice = 1.95;
	this.milkPrice = 2.25;
        
        this.rbtCoke = new RadioButton("Coke");
        this.rbtJuice = new RadioButton("Juice");
        this.rbtMilk = new RadioButton("Milk");
        
        this.drinks1 = new ToggleGroup();
        this.rbtCoke.setToggleGroup(this.drinks1);
        this.rbtJuice.setToggleGroup(this.drinks1);
        this.rbtMilk.setToggleGroup(this.drinks1);
        
        this.lblDrinks = new Label("Number of Drinks");
        this.txaDrinks = new TextField();
        setPadding(new Insets(18,10,10,10));
        getChildren().addAll(new Node[]{this.rbtCoke,this.rbtJuice,this.rbtMilk,this.lblDrinks,this.txaDrinks});
        
    }
    /*
    *method for getting rate of drinks
    */
    public double getRate(){
        if(this.rbtCoke.isSelected()){
            return 1.25;
        }
        else if(this.rbtJuice.isSelected()){
            return 1.95;
        } 
        return 2.25;
    }
    /*
    *method for the drink name
    */
    
    public String getName(){
        if(this.rbtCoke.isSelected()){
            return "COKE";
        }
        else if(this.rbtJuice.isSelected()){
            return "JUICE";
        } 
        return "MILK";
    }
    /*
    *method for Number of drinks
    */
    
    public int noOfDrinks(){
//        CheckNum();
        int number = Integer.parseInt(this.txaDrinks.getText());
        return number;
    }
/*
    method to calculate cost
    */
   
    public double calculateCost(){
        double cost;
        if(this.rbtCoke.isSelected()){
            cost = 1.25 * Integer.parseInt(this.txaDrinks.getText());
        }
        else if(this.rbtJuice.isSelected()){
            cost = 1.95 * Integer.parseInt(this.txaDrinks.getText());
        }
        else {
            cost = 2.25 * Integer.parseInt(this.txaDrinks.getText());
        }
        return cost;
    }
    /*
    * method for chking number is integer
    */
    public Boolean CheckNum(){
        int check = noOfDrinks();
        try{
            check = Integer.parseInt(this.txaDrinks.getText());
      }catch(NumberFormatException e) {
    System.out.println("Input is not a valid integer");
        
    }
        return false;
     
    }
    
    /*
    * method printing the output on pizzeria
    */
    
    
    public String toString(){
        
        
        
        return String.format("%5s%18s\n%13s\n",   "Drinks:", calculateCost(), "  " + 
      noOfDrinks() + " " + getName() + " @ " + getRate() );
    }
    
    
    
    
    
}
