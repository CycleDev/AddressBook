package nao.cycledev.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nao.cycledev.addressbook.utils.SpringFxmlLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher extends Application {

    private static final Logger log = LogManager.getLogger(Launcher.class);
    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        log.info("Starting application");

        this.primaryStage = stage;
        this.primaryStage.setTitle("Address Book");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        log.debug("Loading view from: {}", "/fxml/home.fxml");
        SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader();
        rootLayout = (BorderPane)springFxmlLoader.load("/fxml/home.fxml");

        Scene scene = new Scene(rootLayout, 600, 500);
        //scene.getStylesheets().add("/styles/styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void showPersonOverview() {
        log.debug("Loading view from: {}", "/fxml/person.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/person.fxml"));

        SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader();
        AnchorPane personOverview = (AnchorPane)springFxmlLoader.load("/fxml/person.fxml");
        rootLayout.setCenter(personOverview);
    }
}
