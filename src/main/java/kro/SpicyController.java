package kro;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

import java.util.ArrayList;


public class SpicyController {
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
                        DBManager.getSuggestionSpicy(ingredient.getText()));
            }
        });
    }


    @FXML void add(){
        ArrayList<String> topping = DBManager.getSpicyTopping();
        Button b = new Button(ingredient.getText());
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button a = ((Button) mouseEvent.getSource());
                for (int i = 0; i < topping.size(); i++) {
                    if(topping.get(i).equals(a.getText())){
                        topping.remove(i);
                    }
                }
                selectedIngredients.getChildren().remove(a);
            }
        });

        topping.add(ingredient.getText());
        selectedIngredients.getChildren().add(b);
    }

}
