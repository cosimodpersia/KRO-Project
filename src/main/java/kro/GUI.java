package kro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class GUI extends Application{
    private static String PROPERTIES_FILE = "config.properties";
    private static Properties properties = new Properties();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //PROPERTIES_FILE = kro.FruitController.class.getResource("/config.properties").toString();
        InputStream propertiesInputStream = getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE);
        properties.load(propertiesInputStream);
        Answerer.init();
        DBManager.init(properties);
        primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 500, Color.WHITE);

        TabPane tabPane = new TabPane();

        FXMLLoader loader = new FXMLLoader();

        String baseDir = getClass().getResource("/fxml").toString();
        String[] tabsName = {"submitUsers","craft","cheese","fruit","herbSpice","meat","nut",
                "sauce","seaFood","spicy","vegetable","deep_pan_base","thin_crispy_base",};
        BorderPane borderPane = new BorderPane();
        for (int i = 0; i < tabsName.length; i++) {
            Tab tab = new Tab();
            tab.setText(tabsName[i]);
            FXMLLoader fxmlLoader = new FXMLLoader(new URL(baseDir + "/"+tabsName[i]+".fxml"));
            BorderPane tabI = fxmlLoader.load();
            //tabI.setAlignment(tabI.CENTER);
            tab.setContent(tabI);
            tabPane.getTabs().add(tab);
        }
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox getUser(){
        HBox user = new HBox();
        return user;
    }
}
