package kro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import org.semanticweb.owlapi.model.OWLException;

import java.util.ResourceBundle;

public class SubmitControllerUsers {
    String[] queries = {
            "SELECT distinct ?e WHERE {?x  :boughtPizza  ?e . ?x a :",

    };

    @FXML
    Button submit;
    @FXML
    ChoiceBox choice;
    @FXML
    TextArea response;

    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Rich", "Student","Researcher","Worker","Strange","Athlete");
        choice.setItems(list);
    }

    @FXML
    void submit(){
        response.setText("");
        String filter =choice.getValue().toString() +" }";
        try{
            for (int i = 0; i <queries.length ; i=i+2) {
                    Answerer.getAnswer(queries[i]+filter,response);
            }
        } catch (OWLException e) {
            e.printStackTrace();
        }
    }

}
