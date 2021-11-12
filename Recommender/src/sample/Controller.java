package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.jena.query.QuerySolution;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Controller class for the FXML file.
 * Here is where you find all the methods the buttons run
 */
public class Controller {

    //Fields ---

    @FXML
    private TableView<Product> table;

    @FXML
    private javafx.scene.control.TableColumn<Product,String> name;

    @FXML
    private TableColumn<Product,String> color;

    @FXML
    private TableColumn<Product, String> type;

    @FXML
    private TableColumn<Product, String> price;

    private OntologyMaker ontMaker = new OntologyMaker();

    private ArrayList<QuerySolution> qs = new ArrayList<>();

    private  ArrayList<SimpleStringProperty> nameList = new ArrayList<>();
    private ArrayList<SimpleStringProperty> colorList = new ArrayList<>();


    public Controller() throws IOException {
    }


    //Methods below----->

    @FXML
    private void allWines(ActionEvent event)
    {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try {
            table.setItems(getData(ontMaker.getAll()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allRed (ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));


        try {
            table.setItems(getAllRedData(ontMaker.getAllRed()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    private void fitsToCheese(ActionEvent event){
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.ost()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void fitsToFish(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.fisk()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToVegetables(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.gronnsaker()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToShellFish(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.skallDyr()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToLamb(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.lam()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToCattle(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.storfe()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToDesserts(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.dessert()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToBig_Game(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.storvilt()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void fitsToAppeTizers(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.aperitiff()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void fitsToPork(ActionEvent event) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
        price.setCellValueFactory(new PropertyValueFactory<Product,String>("price"));

        try{
            table.setItems(getData(ontMaker.svinekjott()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @FXML
    private void close(){
        System.exit(0);
    }

    @FXML
    private void clearData(ActionEvent event){
      table.getItems().clear();
    }


    private void updateQsResult() throws IOException {
        qs = ontMaker.getAll();
    }




    private ObservableList<Product> getData(ArrayList<QuerySolution> newList) throws IOException {
        ArrayList<QuerySolution> qsol = new ArrayList<>();
        qsol.addAll(newList);
        ObservableList<Product> list = FXCollections.observableArrayList();

        for(QuerySolution result : qsol)
        {
            String name = result.get("?navn").toString();
            String color = result.get("?farge").toString();
            String type = result.get("?type").toString();
            String pris = result.get("?pris").toString();

            Product nyVin = new Product(name, color, type, pris);
            list.add(nyVin);
        }


        return list;
    }

    private ObservableList<Product> getAllRedData(ArrayList<QuerySolution> newList) throws IOException {
        ArrayList<QuerySolution> qsol = new ArrayList<>();
        qsol.addAll(newList);
        ObservableList<Product> list = FXCollections.observableArrayList();

        for(QuerySolution result : qsol)
        {
            String name = result.get("?navn").toString();
            String color = result.get("?farge").toString();

            String pris = result.get("?pris").toString();

            Product nyVin = new Product(name, color, null, pris);
            list.add(nyVin);
        }


        return list;
    }



}
