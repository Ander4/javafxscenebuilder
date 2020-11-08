package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HasieraKud implements Kudeatzaile {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private Button bozkatuBotoia;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  @FXML
  public void onClick(ActionEvent actionEvent) {


      mainApp.herrialdeakErakutsi();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}