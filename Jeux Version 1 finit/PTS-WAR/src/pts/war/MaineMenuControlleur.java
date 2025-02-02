package pts.war;

import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import ressource.BibliotequeImage;

public class MaineMenuControlleur implements Initializable {


    public static StringProperty redTeamName,blueTeamName;
    @FXML
    public TextField textBoxRed;
    @FXML
    public TextField textBoxBlue;
    @FXML
    public Button startButton;
    @FXML
    public Label redNameAff;
    @FXML
    public Label blueNameAff;
    
    public static String dbLocation = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialisation des propetie
        redTeamName = new SimpleStringProperty("red");
        blueTeamName = new SimpleStringProperty("blue");
        //Bind des propertie
        textBoxRed.textProperty().bindBidirectional(redTeamName);
        textBoxBlue.textProperty().bindBidirectional(blueTeamName);
        redNameAff.textProperty().bind(redTeamName);
        blueNameAff.textProperty().bind(blueTeamName);
    }

    @FXML
    public void lancerJeux(ActionEvent actionEvent) throws IOException {
        //Lanczer le jeux
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("jeuxAff.fxml"));
            Scene game = new Scene(root);
            Stage gameStage = new Stage();
            gameStage.setScene(game);
            gameStage.show();
            startButton.setVisible(false);
        }catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Base de donnée");
            alert.setContentText("La base de donnée na pas pus être charger, merci de la selectioner avec le bouton correspondant");
            alert.show();
        }

    }

    @FXML
    public void exitGame(ActionEvent actionEvent)
    {
        System.exit(0);
    }
    
    @FXML
    public void loadDatabase(ActionEvent actionEvent)
    {
        FileChooser dialog = new FileChooser();
        //dialog.setSelectedExtensionFilter(new ExtensionFilter("database files (*.db)"));
       File file = dialog.showOpenDialog(startButton.getScene().getWindow());
       dbLocation = file.getAbsolutePath();
    }
}
