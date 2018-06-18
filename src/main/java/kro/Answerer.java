package kro;

import it.unibz.inf.ontop.injection.OntopSQLOWLAPIConfiguration;
import it.unibz.inf.ontop.owlapi.OntopOWLFactory;
import it.unibz.inf.ontop.owlapi.OntopOWLReasoner;
import it.unibz.inf.ontop.owlapi.connection.OntopOWLConnection;
import it.unibz.inf.ontop.owlapi.connection.OntopOWLStatement;
import it.unibz.inf.ontop.owlapi.resultset.OWLBinding;
import it.unibz.inf.ontop.owlapi.resultset.OWLBindingSet;
import it.unibz.inf.ontop.owlapi.resultset.TupleOWLResultSet;
import javafx.scene.control.TextArea;
import org.semanticweb.owlapi.io.ToStringRenderer;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLObject;

import java.io.IOException;
import java.util.List;

public class Answerer {


    private static  String owlFile = "src/main/resources/pizza.owl";
    private static  String obdaFile = "src/main/resources/pizza_p.obda";
    private static  String propertyFile = "src/main/resources/database.properties";
    private static  String prefix = "<http://www.w3.org/KRO_project/cosimo/pizza#>";
    private static OntopOWLReasoner reasoner;

    public static void init() throws OWLException, IOException {
        owlFile = FruitController.class.getResource("/pizza.owl").toString();
        obdaFile = FruitController.class.getResource("/pizza_p.obda").toString();
        propertyFile = FruitController.class.getResource("/database.properties").toString();
        OntopOWLFactory factory = OntopOWLFactory.defaultFactory();

        OntopSQLOWLAPIConfiguration config = (OntopSQLOWLAPIConfiguration) OntopSQLOWLAPIConfiguration.defaultBuilder()
                .nativeOntopMappingFile(obdaFile)
                .ontologyFile(owlFile)
                .propertyFile(propertyFile)
                .build();

        reasoner = factory.createReasoner(config);
    }

    public void setPrefix(String p){
        prefix = "<"+p+">";
    }

    public static void main(String[] args) throws Exception {
        Answerer a = new Answerer();
        OntopOWLFactory factory = OntopOWLFactory.defaultFactory();

        OntopSQLOWLAPIConfiguration config = (OntopSQLOWLAPIConfiguration) OntopSQLOWLAPIConfiguration.defaultBuilder()
                .nativeOntopMappingFile(obdaFile)
                .ontologyFile(owlFile)
                .propertyFile(propertyFile)
                .build();

        reasoner = factory.createReasoner(config);
        //a.getAnswer("SELECT * WHERE {?x a :Premium_User}", response);
    }

    public static void getAnswer(String query, TextArea response) throws OWLException {

           String sparqlQuery = "PREFIX : " + prefix + "\n"+ query ;

            System.out.println();
            System.out.println("The input SPARQL query:");
            System.out.println("=======================");
            System.out.println(sparqlQuery);
            System.out.println();

            try (OntopOWLConnection conn = reasoner.getConnection();
                 OntopOWLStatement st = conn.createStatement();
                 TupleOWLResultSet rs = st.executeSelectQuery(sparqlQuery)
            ) {
                System.out.println("------------------------------------------------------------------------------------------");

                while (rs.hasNext()) {
                    final OWLBindingSet bindingSet = rs.next();
                    for (OWLBinding binding : bindingSet) {
                        OWLObject value = binding.getValue();
                        response.appendText(ToStringRenderer.getInstance().getRendering(value) + ", ");
                        System.out.print(ToStringRenderer.getInstance().getRendering(value) + ", ");
                    }
                    response.appendText("\n");
                    System.out.print("\n");
                }

            }
    }

    public static boolean getBooleanAnswer(String query) throws OWLException {
        String sparqlQuery = "PREFIX : " + prefix + "\n"+ query ;
        System.out.println(sparqlQuery);
        OntopOWLConnection conn = reasoner.getConnection();
        OntopOWLStatement st = conn.createStatement();
        TupleOWLResultSet rs = st.executeSelectQuery(sparqlQuery);
        boolean res = rs.hasNext();
        conn.close();
        return res;
    }

    public static String createQuery(List cheeseTopping) {
        StringBuilder s = new StringBuilder();
        s.append("SELECT * WHERE {?s a :Premium_User}");
        return s.toString();
    }
}
