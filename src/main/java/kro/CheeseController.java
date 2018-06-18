package kro;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;


public class CheeseController {
    @FXML
    TextField ingredient;
    @FXML
    VBox selectedIngredients;
    @FXML
    Button add;
    public void initialize(){
        ingredient.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                TextFields.bindAutoCompletion(ingredient,
                        DBManager.getSuggestionCheese(ingredient.getText()));
            }
        });
    }


    @FXML void add(){
        Button b = new Button(ingredient.getText());
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button a = ((Button) mouseEvent.getSource());
                for (int i = 0; i < DBManager.getCheeseTopping().size(); i++) {
                    if(DBManager.getCheeseTopping().get(i).equals(a.getText())){
                        DBManager.getCheeseTopping().remove(i);
                    }
                }
                selectedIngredients.getChildren().remove(a);
            }
        });

        DBManager.getCheeseTopping().add(ingredient.getText());
        selectedIngredients.getChildren().add(b);
    }


}
