/** Name:  Essa Tahir
 * Assignment:  Assignment2
 * Program: PROG24178
 *
 * Making Pizza order program
 */
package A4_EssaTahir;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
/**
 *
 * @author Essa OG
 */
public class Toppings extends VBox {
    /*
    * for storing drinks prices
    */
    
    private double cheese = 1; 
    private double pepperoni = 1.75;
    private double mushroom = 1.25;
    private double olives = 1.50;
    
    /*
    * checkboxs to select which topping
    */
    protected CheckBox chkCheese, chkPepperoni, chkMushroom, chkOlives;
    
    /*
    *calling the pizza class
    */
    private Pizza size;
    
    /*
    * constructor for calling toppings
    */
    
    public Toppings(Pizza size){
        super(10);
        this.chkCheese = new CheckBox("Cheese");
        this.chkMushroom = new CheckBox("Mushroom");
        this.chkPepperoni = new CheckBox("Pepperoni");
        this.chkOlives = new CheckBox("Olives");
        
        this.size = size;
        setPadding(new Insets(18, 10, 10, 10));
        getChildren().addAll(new Node[] { this.chkCheese, this.chkPepperoni, this.chkMushroom, this.chkOlives });
        
      
    }
    /*
    * method for the topping cost
    */
    
    public double getToppingCost(){
        double cost = 0;
        int noOfPizza = 0;
        
        if((this.size.rbtSmall.isSelected()) || (this.size.rbtMedium.isSelected()) || (this.size.rbtLarge.isSelected())){
            noOfPizza = Integer.parseInt(this.size.txtPizza.getText());
            
        }else {
            cost = 0;
        } 
        if(this.chkCheese.isSelected()){
            cost += this.cheese*noOfPizza;
        }
        if(this.chkPepperoni.isSelected()){
            cost += this.pepperoni*noOfPizza;
        }
        if(this.chkOlives.isSelected()){
            cost += this.olives*noOfPizza;
        }
        if(this.chkMushroom.isSelected()){
            cost += this.olives*noOfPizza;
        }
        return cost;
    }
    /*
    * method printing the output of toppings
    */
    
    public String toString(){
        String toppings = "";
    String pizzaNum = this.size.txtPizza.getText();
    if (this.chkCheese.isSelected()) {
      toppings = toppings + "\n  " + pizzaNum + " Cheese @ " + this.cheese;
    }
    if (this.chkPepperoni.isSelected()) {
      toppings = toppings + "\n  " + pizzaNum + " Pepperoni @ " + this.pepperoni;
    }
    if (this.chkOlives.isSelected()) {
      toppings = toppings + "\n  " + pizzaNum + " Olives @ " + this.olives;
    }
    if (this.chkMushroom.isSelected()) {
      toppings = toppings + "\n  " + pizzaNum + " Mushrooms @ " + this.mushroom;
    }
    if ((!this.chkCheese.isSelected()) && (!this.chkPepperoni.isSelected()) && 
      (!this.chkOlives.isSelected()) && (!this.chkMushroom.isSelected())) {
      throw new IllegalArgumentException();
    }
    return String.format("%5s%16s%7s\n",   "Toppings:", (getToppingCost()), toppings );
    }
    
    
}
