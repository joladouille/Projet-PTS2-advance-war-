package pts.war;

import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.TeamID;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class JeuxAffControlleur implements Initializable {


    @FXML
    public Label blueIncome;
    @FXML
    public Label bluePO;
    @FXML
    public Label redIncome;
    @FXML
    public Label redPO;
    @FXML
    public Label teamPlayNow;
    @FXML
    public Button butRouge;
    @FXML
    public Button butBleux;
    @FXML
    public Label nbToursAff;
    private Game game;
    @FXML
    public AnchorPane pane;
    
    GridPane affMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Création de la carte
        game = new Game("Carte1", new Team(MaineMenuControlleur.redTeamName.getValue(),TeamID.RED),new Team(MaineMenuControlleur.blueTeamName.getValue(),TeamID.BLUE));
        affMap = game.getMAPS().getTableauxAff();
        pane.getChildren().add(0,affMap);
        affMap.setLayoutX(0);
        affMap.setLayoutY(0);

        //Bind des variable a l'interface
        nbToursAff.textProperty().bind(game.getNbTurnPropeties().asString());
        //Bleu
        bluePO.textProperty().bind(game.gettBlue().getArgentAffProperty().asString());
        blueIncome.textProperty().bind(game.gettBlue().getIncomAffProperty().asString());
        //Rouge
        redPO.textProperty().bind(game.gettRed().getArgentAffProperty().asString());
        redIncome.textProperty().bind(game.gettRed().getIncomAffProperty().asString());

        //Gestion Background
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/ressource/image/cleanSea.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));

        //Gestion noms des button
        butBleux.setText("Fin du tour de "+MaineMenuControlleur.blueTeamName.getValue());
        butRouge.setText("Fin du tour de "+MaineMenuControlleur.redTeamName.getValue());

        turnAffGest();
    }

    @FXML
    public void endTurn(ActionEvent actionEvent) {
        game.endTurn();
        turnAffGest();
        if(game.getVictoryTeam() != null)
        {
            victory(game.getVictoryTeam());
        }
    }

    private void turnAffGest()
    {
        if(Game.tTurn.getTeamID() == TeamID.BLUE)
        {
            teamPlayNow.setText("Bleux");
            teamPlayNow.setTextFill(Color.BLUE);
            butRouge.setVisible(false);
            butBleux.setVisible(true);
        }else
        {
            teamPlayNow.setText("Rouge");
            teamPlayNow.setTextFill(Color.RED);
            butRouge.setVisible(true);
            butBleux.setVisible(false);
        }
    }

    private void victory(Team vTeam)
    {
        Label victoryLabel = new Label("L'equipe "+vTeam.getName()+" a gagner");
        victoryLabel.setTextFill(Color.WHITE);
        victoryLabel.setLayoutX(pane.getWidth()/2);
        victoryLabel.setLayoutY(pane.getHeight()/2);
        pane.getChildren().add(victoryLabel);
        butRouge.setVisible(false);
        butBleux.setVisible(false);
        if(vTeam.getTeamID() == TeamID.BLUE)
        {
            redIncome.setVisible(false);
            redPO.setVisible(false);
            teamPlayNow.setText("Victoire des Bleux");
            teamPlayNow.setTextFill(Color.BLUE);
        }else
        {
            bluePO.setVisible(false);
            blueIncome.setVisible(false);
            teamPlayNow.setText("Victoire des Rouge");
            teamPlayNow.setTextFill(Color.RED);
        }
    }
    
    @FXML
    public void resetMapPosition(ActionEvent e)
    {
        affMap.setLayoutX(0);
        affMap.setLayoutY(0);
    }
}
