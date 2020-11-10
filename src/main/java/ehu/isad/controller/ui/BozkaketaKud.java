package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.model.BozkaketaAux;
import ehu.isad.model.Herrialde;
import ehu.isad.model.HerrialdeaBozkatu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

public class BozkaketaKud implements Kudeatzaile {

    private Main mainApp;

    private String bozkatzaile;

    private List<BozkaketaAux> bozkatuLista = new ArrayList<BozkaketaAux>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<HerrialdeaBozkatu> tblBoto;

    @FXML
    private TableColumn<HerrialdeaBozkatu, Image> banderaCol;

    @FXML
    private TableColumn<HerrialdeaBozkatu, String> herriCol;

    @FXML
    private TableColumn<HerrialdeaBozkatu, String> artistaCol;

    @FXML
    private TableColumn<HerrialdeaBozkatu, String> abestiCol;

    @FXML
    private TableColumn<HerrialdeaBozkatu, Integer> puntuCol;

    @FXML
    private Button btnBozkatu;

    @FXML
    private Label lblTestua;

    @FXML
    private ImageView imageBandera;

    @FXML
    private ImageView imageLogo;

    private ObservableList<HerrialdeaBozkatu> herrialdeBozkatuak = FXCollections.observableArrayList();

    @FXML
    void onGorde(ActionEvent event) {

        int i = 0;
        int puntuak = 0;
        while (i<tblBoto.getItems().size()){

            HerrialdeaBozkatu herrialdea = tblBoto.getItems().get(i);
            puntuak = puntuak + herrialdea.getPuntoak();
            i++;
        }
        if (puntuak ==5){

            this.sartuDB();
            mainApp.Top3Erakutsi();

        }

    }

    @Override
    public void setMainApp(Main main) {

        this.mainApp = main;

    }

    public void setBozkatzailea(String herri){

        this.bozkatzaile=herri;

    }

    private void setHerrialdeBozkatuak() {

        this.herrialdeBozkatuak.addAll(BozkaketaDBKud.getInstantzia().lortuBozkatzeko());

    }

    private void logoaEzarri(){

        this.imageLogo.setImage(new Image("eurobisioa.png"));

    }

    public void banderaEzarri(){

        this.imageBandera.setImage(new Image("banderak/"+bozkatzaile+".png"));

    }

   public void testuaEzarri(String nork){

        this.lblTestua.setText(nork+"k honela nahi ditu\n"+
                "bere puntuak banatu:");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.logoaEzarri();
        this.setHerrialdeBozkatuak();

        tblBoto.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        herriCol.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        artistaCol.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        puntuCol.setCellValueFactory(new PropertyValueFactory<>("Puntoak"));
        abestiCol.setCellValueFactory(new PropertyValueFactory<>("Abesti"));

        puntuCol.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        Callback<TableColumn<HerrialdeaBozkatu, Integer>, TableCell<HerrialdeaBozkatu, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        puntuCol.setCellFactory(col -> {
            TableCell<HerrialdeaBozkatu, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (!cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(this.bozkatzaile)) {
                        cell.setEditable(false);
                    } else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell;
        });

        this.bozkaketa(this.bozkatzaile);

        banderaCol.setCellValueFactory(new PropertyValueFactory<HerrialdeaBozkatu, Image>("bandera"));

        banderaCol.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty) {
                    final ImageView imageview = new ImageView();
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                } else {
                    setGraphic(null);
                    setText(null);
                }
            };
        });
        tblBoto.setItems(herrialdeBozkatuak);
    }

    private void bozkaketa(String nork){
        puntuCol.setOnEditCommit(
                t -> {
                    String  nori = t.getTableView().getSelectionModel().getSelectedItem().getHerrialdea();

                    if ( ! nori.equals(nork)) {
                        t.getTableView().getItems().get(t.getTablePosition().getRow())
                                .setPuntoak(t.getNewValue());

                        Integer puntua = t.getTableView().getItems().get(t.getTablePosition().getRow()).getPuntoak();
                        if (listanDago(nori)!=null){

                            listanDago(nori).setPuntuak(puntua);
                        }

                        else{

                            BozkaketaAux bozkaketa;
                            bozkaketa = new BozkaketaAux(nori, puntua);
                            bozkatuLista.add(bozkaketa);
                        }
                    }
                }
        );
    }


    private BozkaketaAux listanDago (String noriHerria){
        int i = 0;
        while (i<bozkatuLista.size()) {
            if (bozkatuLista.get(i).equals(noriHerria)){
                return bozkatuLista.get(i);
            }
            i++;
        }
        return null;
    }

    private void sartuDB(){

        int i = 0;
        while (i<bozkatuLista.size()){
            String nori = bozkatuLista.get(i).getHerrialdea();
            Integer puntu = bozkatuLista.get(i).getPuntuak();

            BozkaketaDBKud.getInstantzia().puntuakSartu(this.bozkatzaile, nori, puntu);

            BozkaketaDBKud.getInstantzia().orezkaritzaAktualizatu(nori, puntu);

            i++;
        }

    }
}
