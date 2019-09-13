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
public class Pizza extends VBox {
    
    /*
    * for storing drinks prices
    */
    
    private double sPizza = 5.25;
    private double mPizza = 7.5;
    private double lPizza = 9.95;
    
     /*
    * radiobtton to select which pizza size
    */
    
    protected RadioButton rbtSmall, rbtMedium, rbtLarge;
    
     /*
    * toggleGroup to select which pizza size
    */
    
    private  ToggleGroup pizza1;
    /*
    * Label for the text field
    */
    
    private Label lblPizza;
    /*
    * text field for input
    */
    protected TextField txtPizza;
    /*
    * constructor for calling pizza
    */
    public Pizza(){
        super(10);
        this.rbtSmall = new RadioButton("Small");
        this.rbtMedium = new RadioButton("Medium");
        this.rbtLarge = new RadioButton("Large");
        
        this.pizza1 = new ToggleGroup();
        this.rbtSmall.setToggleGroup(this.pizza1);
        this.rbtMedium.setToggleGroup(this.pizza1);
        this.rbtLarge.setToggleGroup(this.pizza1);
        
        this.lblPizza = new Label("Number of Pizzas: ");
        this.txtPizza = new TextField();
        
        setPadding(new Insets(18.0D, 10.0D, 10.0D, 10.0D));
        getChildren().addAll(new Node[] { this.rbtSmall, this.rbtMedium, this.rbtLarge, this.lblPizza, this.txtPizza });
        
    }
    /*
    * method for the cost of the pizza
    */
    
    public double costPizza(){
        double cost;
        if(this.rbtSmall.isSelected()){
            cost = this.sPizza * noOfPizza();
        }
        else if(this.rbtMedium.isSelected()){
            cost = this.mPizza* noOfPizza();
        }
        else if(this.rbtLarge.isSelected()){
            cost = this.lPizza*noOfPizza();
        }
        else{
            cost = 0.0;
        }
        return cost;
    }
    /*
    * method for checking number is integer
    */
    public Boolean CheckNum(){
        int check = noOfPizza();
       try{
            check = Integer.parseInt(this.txtPizza.getText());
       }catch(NumberFormatException e) {
    System.out.println("Input is not a valid integer");
       
   }
       return false;
   
   }
    /*
    * method for number of pizzas
    */

    public int noOfPizza() {
//        CheckNum();
        int number = Integer.parseInt(this.txtPizza.getText());
        return number;
    }
    /*
    * method for the size of pizza
    */
    
    public String PizzaSize(){
        if(this.rbtSmall.isSelected()){
            return " Small @ 5.25";
        }
        if(this.rbtMedium.isSelected()){
            return " Medium @ 7.5";
        }
        if(this.rbtLarge.isSelected()){
            return " Large @ 9.95";
        }
        return "no size selected";
    }
     /*
    * method for the output of pizza class
    */
    public String toString(){
       return String.format("%7s%18s\n%10s\n",   "Pizza: ", (costPizza()), "  " + 
      noOfPizza() + PizzaSize() ); 
    } 
    
}
