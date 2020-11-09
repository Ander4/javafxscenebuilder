package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private Main mainApp;

    private Herrialde herrialdea;

    @FXML
    private Label lblMezua;

    @FXML
    private Button OKbtn;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    void onClick(ActionEvent event) {

        mainApp.Top3Erakutsi();

    }

    public void setTestua(){

        lblMezua.setText(this.herrialdea.getIzena() + "k jada banatu ditu bere puntuak.");
        lblMezua.setAlignment(Pos.CENTER);

    }

    public void setHerrialdea(Herrialde herri){

        this.herrialdea=herri;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}