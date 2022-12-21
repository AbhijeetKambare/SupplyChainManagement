package com.example.supplychainmanagement;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {
    public TableView<Product> productTable;

    public Pane getAllProduct(){
        TableColumn id= new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name= new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product>data= FXCollections.observableArrayList();
//        data.add(new Product(1,"Lenovo",8432));
//        data.add(new Product(1,"Dell",9800));
        ObservableList<Product> products=Product.getAllProducts();

        productTable= new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);

        productTable.setMinSize(SupplyChain.width,SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Pane tablePane=new Pane();
        tablePane.getChildren().add(productTable);

        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width,SupplyChain.height);

        return tablePane;
    }

    public Pane getByProductName(String productName){
        TableColumn id= new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name= new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product>data= FXCollections.observableArrayList();
//        data.add(new Product(1,"Lenovo",8432));
//        data.add(new Product(1,"Dell",9800));
        ObservableList<Product> products=Product.getProductsByName(productName);

        productTable= new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);

        productTable.setMinSize(SupplyChain.width,SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Pane tablePane=new Pane();
        tablePane.getChildren().add(productTable);

        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width,SupplyChain.height);

        return tablePane;
    }
}
