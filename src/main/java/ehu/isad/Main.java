package ehu.isad;

import ehu.isad.controller.ui.*;
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
  private Parent bozkaketaUI;
  private Parent top3UI;

  private Stage stage;

  private HasieraKud hasieraKud;
  private HerrialdeakKud herrialdeakKud;
  private ErroreaKud erroreakKud;
  private BozkaketaKud bozkaketaKud;
  private Top3Kud top3Kud;

  private Herrialde herrialdea;
  private Scene sceneHasiera;
  private Scene sceneHerri;
  private Scene sceneErrore;
  private Scene sceneBozkaketa;
  private Scene sceneTop3;


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
    sceneHasiera = new Scene(hasieraUI,400,250);
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

    FXMLLoader loaderBozkatu = new FXMLLoader(getClass().getResource("/BazkaketaUI.fxml"));
    bozkaketaUI = (Parent) loaderBozkatu.load();
    sceneBozkaketa = new Scene(bozkaketaUI,600,450);
    bozkaketaKud = loaderBozkatu.getController();
    bozkaketaKud.setMainApp(this);

    FXMLLoader loaderTop3 = new FXMLLoader(getClass().getResource("/Top3UI.fxml"));
    top3UI = (Parent) loaderTop3.load();
    sceneTop3 = new Scene(top3UI,600,450);
    top3Kud = loaderTop3.getController();
    top3Kud.setMainApp(this);
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
    stage.setTitle("Informazioaren Eguneraketa");
    stage.setScene(sceneHerri);
    stage.show();
  }

  public void erroreaErakutsi() {
    stage.setTitle(this.herrialdea.getIzena()+"ren inguruko informazioa");
    erroreakKud.setHerrialdea(this.herrialdea);
    erroreakKud.setTestua();
    erroreakKud.banderaEzarri();
    stage.setScene(sceneErrore);
    stage.show();
  }

  public void bozkaketaErakutsi() {
    stage.setTitle("Bozkaketa Panela");
    bozkaketaKud.setBozkatzailea(this.herrialdea.getIzena());
    bozkaketaKud.banderaEzarri();
    bozkaketaKud.testuaEzarri(this.herrialdea.getIzena());//ez dakit zergatik kudeatzaile barruan herrialdea null moduan artzen du testua egiterakona, baina kodea egiterakoan ondo doa
    stage.setScene(sceneBozkaketa);
    stage.show();
  }

  public void Top3Erakutsi() {
    stage.setTitle("TOP 3");
    top3Kud.hasieratu();
    stage.setScene(sceneTop3);
    stage.show();
  }

}
