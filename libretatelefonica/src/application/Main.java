package application;
	
import java.io.IOException;
import java.util.ArrayList;

import application.controller.Controller;
import application.controller.ControllerAjustes;
import application.controller.ControllerContacto;
import application.model.AccionContactoEnum;
import application.model.Agenda;
import application.model.Contacto;
import application.threads.AdminHilos;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application  {
	private Stage primaryStage;
	private Stage contactoStage;
	private Stage ajustesStage;
	
	private Agenda agenda=new Agenda("119");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage=primaryStage;
			this.primaryStage.setTitle("Agenda ");
			mostrarVentanaPrincipal();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
private void mostrarVentanaPrincipal() throws IOException {
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/PrincipalView.fxml"));

		AnchorPane rootLayout=(AnchorPane) loader.load();

		Controller controller=loader.getController();

		controller.setMain(this);
		
		Scene escena= new Scene(rootLayout);
		primaryStage.setScene(escena);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void cargarVistaContacto(AccionContactoEnum accion, Contacto contactoSeleccionado, Controller controller) {
		 try{
			this.contactoStage=new Stage();
			this.contactoStage.setTitle("Contacto ->"+accion);
			mostrarVentanaContacto(accion,contactoSeleccionado,controller);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void mostrarVentanaContacto(AccionContactoEnum accion, Contacto contactoSeleccionado, Controller controller) throws IOException {
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/ContactoView.fxml"));

		AnchorPane rootLayout=(AnchorPane) loader.load();

		ControllerContacto controllerContacto=loader.getController();

		controllerContacto.setMain(this,controller);
		controllerContacto.config(accion);
		if(accion==AccionContactoEnum.MOSTRAR)
			controllerContacto.setContacto(contactoSeleccionado);
		
		Scene escena= new Scene(rootLayout);
		contactoStage.setScene(escena);
		contactoStage.show();
		
	}

	public void cargarVistaAjustes() {
		
		try{
			this.ajustesStage=new Stage();
			this.ajustesStage.setTitle("Ajustes ");
			mostrarVentanaAjustes();

		} catch(Exception e) {
			e.printStackTrace();
		}

		
		
		
	}

	private void mostrarVentanaAjustes() throws IOException {
		
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AjustesView.fxml"));

		VBox rootLayout=(VBox) loader.load();

		ControllerAjustes controllerAjustes=loader.getController();

		controllerAjustes.setMain(this);
		
		Scene escena= new Scene(rootLayout);
		ajustesStage.setScene(escena);
		ajustesStage.show();
		
	}

	public ArrayList<Contacto> obtenerContactos() {
		return agenda.getContacts();
	}

	public void eliminarContacto(String nombre) {
		agenda.rm(nombre);
		
	}

	public void guardarContacto(Contacto contacto) {
		agenda.put(contacto);
		
	}

	public Contacto obtenerContacto(String key) {
		return agenda.getContact(key);
		
	}

}
