package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkaketaDBKud;
import ehu.isad.model.HerrialdeaBozkatu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

public class BozkaketaKud implements Kudeatzaile {

    private Main mainApp;

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

    private ObservableList<HerrialdeaBozkatu> herrialdeBozkatuak = FXCollections.observableArrayList();

    @FXML
    void onGorde(ActionEvent event) {

        mainApp.Top3Erakutsi();

    }

    @Override
    public void setMainApp(Main main) {

        this.mainApp = main;

    }

    private void setHerrialdeBozkatuak() {

        this.herrialdeBozkatuak.addAll(BozkaketaDBKud.getInstantzia().lortuBozkatzeko());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals("Alemania")) {
                        cell.setEditable(false);
                    } else {
                        cell.setEditable(true);
                    }
                }
            });

            return cell;
        });


        puntuCol.setOnEditCommit(
                t -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setPuntoak(t.getNewValue());
                    //datubasea aktualizatu


                }
        );

        banderaCol.setCellValueFactory(new PropertyValueFactory<HerrialdeaBozkatu, Image>("bandera"));

        banderaCol.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty) {
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
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
}
