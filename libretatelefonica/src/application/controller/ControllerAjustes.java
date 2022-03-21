package application.controller;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerAjustes implements Initializable {
	Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    void cerrarAction(ActionEvent event) {
    	cerrarVentana(event);

    }

	private void cerrarVentana(ActionEvent event) {
		Node source= (Node) event.getSource();
    	Stage stage= (Stage) source.getScene().getWindow();
    	stage.close();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setMain(Main main) {
		this.main=main;
		
	}
}