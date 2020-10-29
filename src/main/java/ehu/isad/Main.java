package ehu.isad;

import ehu.isad.controller.ui.ErroreaKud;
import ehu.isad.controller.ui.HasieraKud;
import ehu.isad.controller.ui.HerrialdeakKud;
import ehu.isad.model.Herrialde;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI;
  private Parent herrialdeakUI;
  private Parent erroreaUI;

  private Stage stage;

  private HasieraKud hasieraKud;
  private HerrialdeakKud herrialdeakKud;
  private ErroreaKud erroreakKud;

  private Herrialde herrialdea;
  private Scene sceneHasiera;
  private Scene sceneHerri;
  private Scene sceneErrore;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("EUROVISION");
    stage.setScene(sceneHasiera);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/HasieraUI.fxml"));
    hasieraUI = (Parent) loaderKautotu.load();
    sceneHasiera = new Scene(hasieraUI,600,450);
    hasieraKud = loaderKautotu.getController();
    hasieraKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/HerrialdeakUI.fxml"));
    herrialdeakUI = (Parent) loaderMain.load();
    sceneHerri = new Scene(herrialdeakUI,600,450);
    herrialdeakKud = loaderMain.getController();
    herrialdeakKud.setMainApp(this);

    FXMLLoader loaderErrore = new FXMLLoader(getClass().getResource("/ErroreaUI.fxml"));
    erroreaUI = (Parent) loaderErrore.load();
    sceneErrore = new Scene(erroreaUI,600,450);
    erroreakKud = loaderErrore.getController();
    erroreakKud.setMainApp(this);
  }

  public void setHerrialde(Herrialde herri){

    this.herrialdea=herri;

  }

  public static void main(String[] args) {
    launch(args);
  }

  public void hasieraErakutsi() {
    stage.setScene(sceneHasiera);
    stage.show();
  }

  public void herrialdeakErakutsi() {
    stage.setScene(sceneHerri);
    stage.show();
  }

  public void erroreaErakutsi() {
    erroreakKud.setHerrialdea(this.herrialdea);
    erroreakKud.setTestua();
    stage.setScene(sceneErrore);
    stage.show();
  }


}
