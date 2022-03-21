package application.threads;

import java.io.IOException;

import application.Main;
import application.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminHilos extends Application implements Runnable{
	private Stage secundarystage;
	private Main main;
	Controller controlador;
	public AdminHilos(Stage secundarystage, Main main) {
		super();
		this.secundarystage = secundarystage;
		this.main = main;
		Thread hilo= new Thread(this);
		hilo.start();
		
	}
	@Override
	public void run() {
		try {
			start(this.secundarystage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PrincipalView.fxml"));

			AnchorPane rootLayout;
			rootLayout = (AnchorPane) loader.load();

			Controller controller=loader.getController();
			controller.setMain(main);


			Scene escena= new Scene(rootLayout);
			secundarystage.setScene(escena);
			secundarystage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}


}
	@Override
	public void start(Stage arg0) throws Exception {
		try {
			this.secundarystage=arg0;
			this.secundarystage.setTitle("Agenda ");
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

		controller.setMain(main);
		
		Scene escena= new Scene(rootLayout);
		secundarystage.setScene(escena);
		secundarystage.show();
	}
		
	}

