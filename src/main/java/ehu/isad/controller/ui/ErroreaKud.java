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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private Main mainApp;

    private Herrialde herrialdea;

    @FXML
    private Label lblMezua;

    @FXML
    private Button OKbtn;

    @FXML
    private ImageView imageBandera;

    @FXML
    private ImageView imageLogo;

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

    private void logoaEzarri(){

        this.imageLogo.setImage(new Image("eurobisioa.png"));

    }

    public void banderaEzarri(){

        this.imageBandera.setImage(this.herrialdea.getBandera());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.logoaEzarri();

    }
}