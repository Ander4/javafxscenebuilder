package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HasieraKud implements Kudeatzaile {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private Button bozkatuBotoia;

  @FXML
  private ImageView imageLogo;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {


      mainApp.herrialdeakErakutsi();

  }

  private void logoaEzarri(){

    this.imageLogo.setImage(new Image("eurobisioa.png"));

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    this.logoaEzarri();

  }

}