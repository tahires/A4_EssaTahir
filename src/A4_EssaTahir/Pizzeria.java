/** Name:  Essa Tahir
 * Assignment:  Assignment2
 * Program: PROG24178
 *
 * Making Pizza order program
 */
package A4_EssaTahir;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Essa OG
 */
public class Pizzeria extends Application {

    /*
    *This is the variable for the tax rate
     */
    private double taxrate;
    /*
    *This is the variable for the textarea
     */
    private TextArea txaDisplay;
    /*
    *This is the variable for Pizza class
     */
    private Pizza pizzas;
    /*
    *This is the variable for toppings class
     */
    private Toppings toppings;
    /*
    *This is the variable for drinks class
     */
    private Drinks drinks;
    /*
    *This is the variable for btton ok and cancel
     */
    private Button btnOK;
    private Button btnCancel;
    /*
    *This is the variable for menubar and file menu
     */
    private MenuBar menuBar;
    private Menu fileMenu;
    private MenuItem exitItem;
    /*
    *This is the variable for label 
     */
    private Label lblText;

    /*
    *The stage for the gui
     */
    @Override
    public void start(Stage primaryStage) {
        /*
    *using borderpane and vbox as the layout
         */
        BorderPane pane = new BorderPane();
        VBox topPane = new VBox(5);
        /*
    *This is to call the variable in the method
        and naming them
         */
        this.menuBar = new MenuBar();

        (this.fileMenu = new Menu("_File")).setMnemonicParsing(true);
        this.fileMenu.getStyleClass().add("menu-label");
        this.exitItem = new MenuItem("E_xit");
        /*
    *adding the shortcut for the exiting gui
         */
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.T,
                KeyCombination.SHORTCUT_DOWN));
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);
        exitItem.setOnAction(e -> getButtonClicked(e));

        HBox panes = new HBox(5);

        this.pizzas = new Pizza();
        this.toppings = new Toppings(this.pizzas);
        this.drinks = new Drinks();

        /*
    *This to call stackpane from another class
                and adding them to the root
         */
        PositionPane pnlPizza = new PositionPane("Pizza", (Node) this.pizzas);
        PositionPane pnlTopings = new PositionPane("Toppings", (Node) this.toppings);
        PositionPane pnlDrinks = new PositionPane("Drinks", (Node) this.drinks);
        panes.getChildren().addAll((Node[]) (Object[]) new Node[]{pnlPizza, pnlTopings, pnlDrinks});
        panes.setAlignment(Pos.CENTER);
        panes.setMaxHeight(200.0);
        BorderPane.setMargin((Node) panes, new Insets(15.0, 5.0, 5.0, 5.0));
        topPane.getChildren().addAll((Node[]) (Object[]) new Node[]{this.menuBar, panes});
        /*
    *This is to call the variable in the method
        and naming them
         */
        (this.txaDisplay = new TextArea()).setPrefHeight(250.0);
        this.txaDisplay.setEditable(false);
         PositionPane pnlDisplay = new PositionPane("Ordered Items", (Node) this.txaDisplay);
         HBox buttonPane = new HBox(25.0);
        (this.btnOK = new Button("_OK")).setPrefWidth(80.0);
        this.btnOK.setAlignment(Pos.CENTER);
        this.btnOK.setOnAction(e -> this.getButtonClicked(e));
        (this.btnCancel = new Button("_Cancel")).setAlignment(Pos.CENTER);
        /*
    *setting the margin, width and naming for the button
         */
        this.btnCancel.setPrefWidth(80.0);
        this.btnOK.setMnemonicParsing(true);
        this.btnCancel.setMnemonicParsing(true);
        this.btnCancel.setOnAction(e -> this.getButtonClicked(e));
        buttonPane.getChildren().addAll((Node[]) (Object[]) new Node[]{this.btnOK, this.btnCancel});
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        pane.setTop((Node) topPane);
        pane.setCenter((Node) pnlDisplay);
        pane.setBottom((Node) buttonPane);

        /*
    *To show the stage
         */
        Scene scene = new Scene((Parent) pane);

        primaryStage.setTitle("My Pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
    *Method to display the receipt
     */
    public void display() {
        DecimalFormat dollar = new DecimalFormat("0.00");
        this.txaDisplay.setText(String.format("%12s\n", "Receipt"));
        if (this.pizzas.costPizza() != 0.0) {
            this.txaDisplay.appendText(this.pizzas.toString());
        }
        if (this.toppings.getToppingCost() != 0.0) {
            this.txaDisplay.appendText(this.toppings.toString());
        }
        if (this.drinks.getRate() != 0.0) {
            this.txaDisplay.appendText(this.drinks.toString());
        }
        this.txaDisplay.appendText(String.format("%22s\n", "========================="));
        final double subtotal = this.pizzas.costPizza() + this.toppings.getToppingCost() + this.drinks.getRate();
        final double tax = subtotal * 0.13;
        final double total = subtotal + tax;
        if (total != 0.0) {
            this.txaDisplay.appendText(String.format("%5s%16s\n", "Subtotal:", dollar.format(subtotal)));
            this.txaDisplay.appendText(String.format("%5s%16s\n", "HST:     ", dollar.format(tax)));
            this.txaDisplay.appendText(String.format("%5s%16s\n", "Total:   ", dollar.format(total)));
        } else {
            this.txaDisplay.setText("Please select a pizza size and/or a drink");
        }
    }

    /*
    *action event for the button to show receipt or cancel it
     */

    public void getButtonClicked(ActionEvent e) {
        if (e.getSource() == this.exitItem) {
            System.exit(0);
        }
        if (e.getSource() == this.btnCancel) {
            this.clearPage();
            return;
        }
        if (e.getSource() == this.btnOK) {

            try {
                int numOfPizzas;
                if (this.pizzas.rbtSmall.isSelected() || this.pizzas.rbtMedium.isSelected() || this.pizzas.rbtLarge.isSelected()) {
                    numOfPizzas = this.pizzas.noOfPizza();
                } else {
                    numOfPizzas = 0;
                }
                int numOfDrinks;
                if (this.drinks.rbtCoke.isSelected() || this.drinks.rbtJuice.isSelected() || this.drinks.rbtMilk.isSelected()) {
                    numOfDrinks = this.drinks.noOfDrinks();
                } else {
                    numOfDrinks = 0;
                }
                if (numOfPizzas < 0 || numOfDrinks < 0) {
                    this.txaDisplay.setText("Invalid number");
                    return;
                }

            } catch (NumberFormatException ex) {
                this.txaDisplay.setText("Invalid entry; must be an Integer value");
                return;
            }

        }
        this.display();
        return;

    }

    /*
    *method to reset the gui
     */
    private void clearPage() {

        this.pizzas.txtPizza.clear();

        this.pizzas.rbtSmall.setSelected(false);

        this.pizzas.rbtMedium.setSelected(false);
        this.pizzas.rbtLarge.setSelected(false);
        this.toppings.chkCheese.setSelected(false);
        this.toppings.chkMushroom.setSelected(false);
        this.toppings.chkOlives.setSelected(false);
        this.toppings.chkPepperoni.setSelected(false);
        this.drinks.rbtCoke.setSelected(false);
        this.drinks.rbtJuice.setSelected(false);
        this.drinks.rbtMilk.setSelected(false);
        this.drinks.txaDrinks.clear();
        this.txaDisplay.clear();
    }

}
