package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.AccionContactoEnum;
import application.model.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller  implements Initializable{
	Main main;
	Contacto contactoSeleccionado;
	
	
	ObservableList<Contacto> listaContactos= FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Contacto, Integer> columnTelefono;

    @FXML
    private Button btnAjustes;

    @FXML
    private TextField txtNombre;

    @FXML
    private Label lblNombre;

    @FXML
    private TableColumn<Contacto, Integer> columnFijo;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnCredits;

    @FXML
    private TableColumn<Contacto, String> columnNombre;

    @FXML
    private Button btnAgregar;

    @FXML
    private TableView<Contacto> tableContactos;

    @FXML
    private Button btnBuscar;

    @FXML
    void buscarAction(ActionEvent event) {
    	Contacto contactoAux;
    	if(!(txtNombre.getText().isEmpty()))
    	{
    			contactoAux=main.obtenerContacto(txtNombre.getText());
    			if(contactoAux!=null){
    				main.cargarVistaContacto(AccionContactoEnum.MOSTRAR, contactoAux, this);
    			}else{
    				System.err.println("contacto con key ["+txtNombre.getText()+"] no está registrado");
    			}

				
    		
    	}

    }

    @FXML
    void agregarAction(ActionEvent event) {
    	agregarContacto();

    }

    

	@FXML
    void eliminarAction(ActionEvent event) {
    	eliminarContacto();
    }

   

	@FXML
    void AjustesAction(ActionEvent event) {
    	main.cargarVistaAjustes();

    }

    @FXML
    void creditsAction(ActionEvent event) {

    }
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.columnFijo.setCellValueFactory(new PropertyValueFactory<>("fijo"));

		tableContactos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {

			contactoSeleccionado = newSelection;
			if(contactoSeleccionado!=null)
				main.cargarVistaContacto(AccionContactoEnum.MOSTRAR,contactoSeleccionado,this);


		});


	}
	private void agregarContacto() {
    	main.cargarVistaContacto(AccionContactoEnum.AGREGAR,null,this);
		
	}
	public void setMain(Main main) {
		this.main=main;
		tableContactos.getItems().clear();;
		refrescarTablas();
		
	}

	public void refrescarTablas() {
		tableContactos.setItems(getListaContactosData());
		tableContactos.refresh();

	}

	private ObservableList<Contacto> getListaContactosData() {
		listaContactos.clear();
		listaContactos.addAll(main.obtenerContactos());

		System.out.println(listaContactos.toString());

		return listaContactos;
	}
	private void eliminarContacto() {
		if(contactoSeleccionado!=null){
			main.eliminarContacto(contactoSeleccionado.getNombre());
			refrescarTablas();
		}
		
	}

}
