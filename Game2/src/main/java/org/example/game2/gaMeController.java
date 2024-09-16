package org.example.game2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Random;

public class gaMeController {




    @FXML
    private ImageView computer_turn;



    @FXML
    private Label result_label;



    @FXML
    private ImageView user_turn;

    private void ShowAlert(boolean con){
        if (con){
            result_label.setText("Win!!");

        }else {
            result_label.setText("Lose");
        }


    }

    private String Result_play;

    @FXML
    void play_action(ActionEvent event) {
        if (Result_play != null) {
            computer_turn_fun(Result_play);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Game");
            alert.setHeaderText(null);
            alert.setContentText("Select symbol");
            alert.showAndWait();
        }


    }
    private void computer_turn_fun(String user_simbol_value){
        String rock = "fist.png";
        String paper ="hand-paper.png" ;
        String scissors = "scissors.png";
        String Computer = null;
        Random rndom = new Random();
        int value_of_simbol = rndom.nextInt(3)+1;
        if(value_of_simbol==1){
            Image rock_ = new Image(getClass().getResource(rock).toExternalForm()) ;
            Computer="rock";
            computer_turn.setImage(rock_);

        } else if (value_of_simbol==2) {
            Image paper_ = new Image(getClass().getResource(paper).toExternalForm()) ;
            Computer="paper";
            computer_turn.setImage(paper_);
        } else {
            Image scissors_ = new Image(getClass().getResource(scissors).toExternalForm()) ;
            Computer= "scissors";
            computer_turn.setImage(scissors_);
        }
        if (Computer.equals(user_simbol_value)){
           result_label.setText("Draw");
        } else {
           if (Computer.equals("rock") && user_simbol_value.equals("paper")){
               ShowAlert(true);
           } else if (Computer.equals("paper") && user_simbol_value.equals("rock")) {
               ShowAlert(false);
           } else if (Computer.equals("scissors") && user_simbol_value.equals("paper")) {
               ShowAlert(false);
           } else if (Computer.equals("rock") && user_simbol_value.equals("scissors")){
               ShowAlert(false);
           } else if (Computer.equals("scissors") && user_simbol_value.equals("rock")) {
               ShowAlert(true);
           } else if (Computer.equals("paper") && user_simbol_value.equals("scissors")) {
               ShowAlert(true);
           }
        }


    }
    @FXML
    void paper_action(ActionEvent event) {
        try {
            Image img = new Image(getClass().getResource("hand-paper.png").toExternalForm());
            user_turn.setImage(img);
            Result_play = "paper";
             }catch (Exception e){
                e.printStackTrace();
            }
        computer_turn.setImage(null);

    }

    @FXML
    void rock_action(ActionEvent event) {
        try {
            Image img = new Image(getClass().getResource("fist.png").toExternalForm());
            user_turn.setImage(img);

            Result_play = "rock";
        }catch (Exception e){
            e.printStackTrace();
        }
        computer_turn.setImage(null);

    }

    @FXML
    void scissors_action(ActionEvent event) {
        try {
            Image img = new Image(getClass().getResource("scissors.png").toExternalForm());
            user_turn.setImage(img);
            Result_play = "scissors";
        }catch (Exception e){
            e.printStackTrace();
        }
        computer_turn.setImage(null);
    }


}
