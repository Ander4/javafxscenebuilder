package ehu.isad;

import ehu.isad.controller.ui.NagusiaKud;
import ehu.isad.controller.ui.HerrialdeakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent ezarpenakUI;

  private Stage stage;

  private NagusiaKud nagusiaKud;
  private HerrialdeakKud herrialdeakKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Ezarpenak lortu");
    stage.setScene(new Scene(nagusiaUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
    nagusiaUI = (Parent) loaderKautotu.load();
    nagusiaKud = loaderKautotu.getController();
    nagusiaKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
    ezarpenakUI = (Parent) loaderMain.load();
    herrialdeakKud = loaderMain.getController();
    herrialdeakKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void ezarpenakErakutsi() {
    stage.setScene(new Scene(ezarpenakUI));
    stage.show();
    herrialdeakKud.getEzarpenak();
  }
}
