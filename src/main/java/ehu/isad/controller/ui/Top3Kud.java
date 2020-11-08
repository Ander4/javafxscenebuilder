package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.controller.db.Top3DBKud;
import ehu.isad.model.Top3Herri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Top3Kud implements Kudeatzaile{

    private Main mainApp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTOP1;

    @FXML
    private Label lblTOP2;

    @FXML
    private Label lblTOP3;

    @FXML
    private ImageView imgTOP1;

    @FXML
    private ImageView imgTOP2;

    @FXML
    private ImageView imgTOP3;

    @FXML
    private Button btnOK;

    @FXML
    void onSakatu(ActionEvent event) {

        System.out.println("amaitua da programa");
        System.exit(0);

    }

    @Override
    public void setMainApp(Main main) {

        this.mainApp = main;
        
    }

    private void setTop1(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String izena = emaitza.get(0).getIzena();
        int puntuak = emaitza.get(0).getPuntuGuztiak();
        this.lblTOP1.setText(izena+"-"+puntuak);

    }

    private void setTop2(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String izena = emaitza.get(1).getIzena();
        int puntuak = emaitza.get(1).getPuntuGuztiak();
        this.lblTOP2.setText(izena+"-"+puntuak);

    }

    private void setTop3(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String izena = emaitza.get(2).getIzena();
        int puntuak = emaitza.get(2).getPuntuGuztiak();
        this.lblTOP3.setText(izena+"-"+puntuak);


    }

    private void setBanderaTop1(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String bandera = emaitza.get(0).getBandera();
        String image = "banderak/"+bandera+".png";
        Image irudi = new Image(image);
        this.imgTOP1.setImage(irudi);

    }

    private void setBanderaTop2(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String izena = emaitza.get(1).getIzena();
        String bandera = emaitza.get(1).getBandera();
        String image = "banderak/"+bandera+".png";
        Image irudi = new Image(image);
        this.imgTOP2.setImage(irudi);

    }

    private void setBanderaTop3(){

        List<Top3Herri> emaitza = Top3DBKud.getInstantzia().lortuTop3();
        String izena = emaitza.get(2).getIzena();
        String bandera = emaitza.get(2).getBandera();
        String image = "banderak/"+bandera+".png";
        Image irudi = new Image(image);
        this.imgTOP3.setImage(irudi);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setTop1();
        setTop2();
        setTop3();
        setBanderaTop1();
        setBanderaTop2();
        setBanderaTop3();

    }
}
