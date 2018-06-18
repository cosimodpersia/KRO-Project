package kro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.semanticweb.owlapi.model.OWLException;

public class SubmitControllerCraft {
    String[] queries = {
            "SELECT ?t WHERE {?t a :CheeseyPizza ","a cheesey pizza",
            "SELECT ?t WHERE {?t a :VegetablePizza ","a pizza with vegetables",
            "SELECT ?t WHERE {?t a :FruityPizza","a pizza with fruit",
            "SELECT ?t WHERE {?t a :HealthyPizza","a healthy pizza",
            "SELECT ?t WHERE {?t a :ThinAndCrispyPizza","a thin and crispy pizza",
            "SELECT ?t WHERE {?t a :SpicyPizza","a spicy pizza",
            "SELECT ?t WHERE {?t a :SeaPizza","a pizza with seafood",
            "SELECT ?t WHERE {?t a :NutPizza","a pizza with nuts",
            "SELECT ?t WHERE {?t a :NormalPizza","a normal pizza",
            "SELECT ?t WHERE {?t a :MeatyPizza","a pizza with meat",
            "SELECT ?t WHERE {?t a :JuicyPizza","a pizza with sauces",
            "SELECT ?t WHERE {?t a :InterestingPizza","an interesting pizza",
            "SELECT ?t WHERE {?t a :FragrantPizza","a fragrant pizza",
            "SELECT ?t WHERE {?t a :DeepPanBasePizza","a pizza with deep pan base",
            "SELECT ?t WHERE {?t a :ItalianPizza","a real italian pizza",
            "SELECT ?t WHERE {?t a :UnusualPizza","an unusual pizza",
            "SELECT ?t WHERE {?t a :CarnivorePizza","a pizza for carnivores",
            "SELECT ?t WHERE {?t a :ProteinPizza","a pizza with proteins",
            "SELECT ?t WHERE {?t a :OilyPizza","a pizza with a lot of oil",
            "SELECT ?t WHERE {?t a :FatPizza","a pizza with fat",
            "SELECT ?t WHERE {?t a :ExpensivePizza","an expensive pizza",
            "SELECT ?t WHERE {?t a :ForRichPizza"," usually bought by people with high social-economial status",
            "SELECT ?t WHERE {?t a :ForDriverPizza","ideal for drivers, it does not make you sleepy",
            "SELECT ?t WHERE {?t a :ForResearcherPizza"," usually bought by researchers",
            "SELECT ?t WHERE {?t a :ForWorkerPizza"," usually bought by workers",
            "SELECT ?t WHERE {?t a :ForStrangeGuyPizza"," usually bought by people with unusual taste",
            "SELECT ?t WHERE {?t a :ForItalianPizza"," usually bought by Italians",
            "SELECT ?t WHERE {?t a :ForStudentPizza"," usually bought by students",
            "SELECT ?t WHERE {?t a :ForAthletePizza"," usually bought by athletes"
    };
    String[] carnivore ={ "SELECT ?t WHERE {?t a :CarnivorePizza","a pizza for carnivores"};
    String[] nature = {
            "SELECT ?t WHERE {?t a :CheeseyPizza ","a cheesey pizza",
            "SELECT ?t WHERE {?t a :VeganPizza","a pizza for vegans",
            "SELECT ?t WHERE {?t a :VegetarianPizza","a vegetarian pizza"
    };
    @FXML
    Button submit;
    @FXML
    TextArea response;
    @FXML
    void submit(){
        //String filter = " FILTER regex(?t,\"pizza\")}";
        String filter ="}";
        DBManager.prepareDB();
        try{
            StringBuilder sb = new StringBuilder();
            boolean meat = Answerer.getBooleanAnswer(carnivore[0]+filter);
            for (int i = 0; i <queries.length ; i=i+2) {

                    boolean e = Answerer.getBooleanAnswer(queries[i]+filter);
                    if(e){
                        sb.append(" this pizza is ");
                        sb.append(queries[i+1]+"\n");
                    }
                    sb.append(" this pizza is ");
                    if(!e){
                        sb.append("not ");
                    }
                    sb.append(queries[i+1]+"\n");

            }
            if(!meat){

                if(Answerer.getBooleanAnswer(nature[2]+filter) &
                        !(Answerer.getBooleanAnswer(nature[0]+filter))){
                    sb.append(" this pizza is ");
                    sb.append(nature[3]+"\n");
                }else if(Answerer.getBooleanAnswer(nature[4]+filter)){
                    sb.append(" this pizza is ");
                    sb.append(nature[5]+"\n");
                }
            }
                response.setText(sb.toString());
        } catch (OWLException e) {
            e.printStackTrace();
        }
        DBManager.clearDB();
    }

}
