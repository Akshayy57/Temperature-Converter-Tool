package com.akshay.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		//Call the method of createMenu
		MenuBar menuBar = createMenu();

		//add menuBar to our root node
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}

	private MenuBar createMenu(){

		//File menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> System.out.println("New Menu Item clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		//Help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutMenuItem = new MenuItem("About");

		aboutMenuItem.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutMenuItem);

		//Menu Bar
		MenuBar menuBar = new MenuBar();
		//to add all menu into menuBar
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		//return menuBar
		return menuBar;

	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Java App");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am new to it but soon i will code well.");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);


		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes button Clicked.");
		} else {
			System.out.println("No button Clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
