package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeakKud implements Initializable {

  // Reference to the main application.
  private Main mainApp;

  @FXML
  private ComboBox<Herrialde> comboHerrialde;

  public void setMainApp(Main main) {
    this.mainApp = mainApp;
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

    ObservableList<Herrialde> books = FXCollections.observableArrayList();
    books.addAll(
            new Book("1491910399", "R for Data Science"),
            new Book("1491946008", "Fluent Python"),
            new Book("9781491906187", "Data Algorithms")
    );
    comboHerrialde.setItems(books);
    comboHerrialde.setEditable(false);

  }

  @FXML
  public void onClick(ActionEvent actionEvent) {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    this.comboHasieratu();

  }

}