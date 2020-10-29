package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EurobisioaDBKud;
import ehu.isad.model.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeakKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private ComboBox<Herrialde> comboHerrialde;

  @FXML
  private Button OKbtn;

  public void setMainApp(Main main) {
    this.mainApp = main;
  }

  private void comboDatuak(){

    comboHerrialde.setConverter(new StringConverter<Herrialde>() {
      @Override
      public String toString(Herrialde herri) {
        if (herri == null)
          return "";
        return herri.getIzena();
      }

      @Override
      public Herrialde fromString(String string) {
        return null;
      }
    });

  }

  private void comboHasieratu(){

    this.comboDatuak();

    List<Herrialde> herrialdeak = EurobisioaDBKud.getInstantzia().lortuHerrialdeak();
    ObservableList<Herrialde> books = FXCollections.observableArrayList();
    books.addAll(herrialdeak);
    comboHerrialde.setItems(books);
    comboHerrialde.setEditable(false);

  }

  @FXML
  public void onClick(ActionEvent actionEvent) {

    Herrialde herri =comboHerrialde.getValue();
    mainApp.setHerrialde(herri);
    mainApp.erroreaErakutsi();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    this.comboHasieratu();

  }

}