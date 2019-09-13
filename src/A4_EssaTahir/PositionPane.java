
package A4_EssaTahir;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PositionPane
  extends StackPane
{
  PositionPane(String titleString, Node content)
  {
    Label title = new Label(" " + titleString + " ");
    title.getStyleClass().add("bordered-titled-title");
    StackPane.setAlignment(title, Pos.TOP_CENTER);
    
    StackPane contentPane = new StackPane();
    content.getStyleClass().add("bordered-titled-content");
    contentPane.getChildren().add(content);
    
    getStyleClass().add("bordered-titled-border");
    getChildren().addAll(new Node[] { title, contentPane });
    getStylesheets().add("styles.css");
  }
}
