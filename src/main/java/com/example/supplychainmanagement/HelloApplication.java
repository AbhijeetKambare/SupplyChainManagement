package com.example.supplychainmanagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width,height+headerBar);

        bodyPane.setMinSize(width,height);
        bodyPane.getChildren().addAll(loginPage());
        bodyPane.setTranslateY(headerBar);
        root.getChildren().addAll(headerBar(),bodyPane);

        return root;
    }
    private GridPane loginPage(){
        Label emailLabel =new Label("Email");
        Label passwordLabel =new Label("Password");
        Label massagelabel=new Label("I am Massage");
        TextField emailTextField =new TextField();
        TextField passwordTextField =new TextField();

        Button LoginButton=new Button("Log In");
        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText();
                String password=passwordTextField.getText();
                massagelabel.setText(email+" && " +password);
            }
        });
        GridPane gridPane= new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),bodyPane.getMinHeight());
        gridPane.setVgap(8);
        gridPane.setHgap(8);
        gridPane.setStyle("-fx-background-color: #C0C0C0");

        gridPane.setAlignment(Pos.CENTER);
        //first x and 2nd y
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordTextField,1,1);
        gridPane.add(LoginButton,0,2);
        gridPane.add(massagelabel,0,3);

        return gridPane;
    };

    public static final int width=700,height=600,headerBar=50;

    Pane bodyPane=new Pane();
    private GridPane headerBar(){
        TextField searchText= new TextField();
        Button searchButton= new Button("Search");

        GridPane gridPane=new GridPane();

        gridPane.setMinSize(bodyPane.getMinWidth(),headerBar-10);
        gridPane.setVgap(8);
        gridPane.setHgap(8);
        gridPane.setStyle("-fx-background-color: #C0C0C0");
        gridPane.setAlignment(Pos.CENTER);


        gridPane.add(searchText,0,0);
        gridPane.add(searchButton,1,0);

        return gridPane;
    }

    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}