package application.controller;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.exception.DatosInvalidosException;
import application.model.AccionContactoEnum;
import application.model.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerContacto implements Initializable {
	private Main main;
	private Controller controller;
	private Contacto contactoAux;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblFijo;

    @FXML
    private TextField txtNombre;

    @FXML
    private Label lblNombre;

    @FXML
    private TextField txtFijo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnGuardarCambios;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnCerrar;

    @FXML
    void guardarCambiosAction(ActionEvent event){
    	guardarCambios();
    	cerrarAction(event);

    }

  

	@FXML
    void cancelarAction(ActionEvent event) {
    	cerrarVentana(event);
    }

    @FXML
    void editarAction(ActionEvent event) {
    	configEditar();

    }

   

	@FXML
    void cerrarAction(ActionEvent event) {
    	cerrarVentana(event);
    }

    private void cerrarVentana(ActionEvent event) {
    	controller.refrescarTablas();
    	Node source= (Node) event.getSource();
    	Stage stage= (Stage) source.getScene().getWindow();
    	stage.close();
		
	}

	@FXML
    void agregarAction(ActionEvent event) {
		agregar();
		cerrarAction(event);

    }

	private void agregar() {
    	try {
			validarDatos();

			int telefono=Integer.parseInt(txtTelefono.getText());
			int fijo=Integer.parseInt(txtFijo.getText());

			main.guardarContacto(new Contacto(txtNombre.getText(),telefono,fijo));

		} catch (DatosInvalidosException | NumberFormatException e) {
			e.printStackTrace();
		}


	}



	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setMain(Main main, Controller controller) {
		this.main= main;
		this.controller=controller;
		
	}

	public void config(AccionContactoEnum accion) {
		if(accion==AccionContactoEnum.AGREGAR)
		{
			configurarAgregar();
		}else{
			configurarMostrar();
		}
		
	}

	private void configurarMostrar() {
		btnAgregar.setVisible(false);
		btnCancelar.setVisible(false);
		
		btnCerrar.setVisible(true);
		btnEditar.setVisible(true);
		btnGuardarCambios.setVisible(false);

		
	}
	private void configEditar() {
		txtNombre.setEditable(true);;
		txtTelefono.setEditable(true);;
		txtFijo.setEditable(true);;

		
		btnAgregar.setVisible(false);
		btnCancelar.setVisible(true);
		
		btnCerrar.setVisible(false);
		btnEditar.setVisible(false);
		btnGuardarCambios.setVisible(true);

	}
	private void configurarAgregar() {
		txtNombre.setEditable(true);;
		txtTelefono.setEditable(true);;
		txtFijo.setEditable(true);;

		txtNombre.setPromptText("Ingrese el nombre");
		txtTelefono.setPromptText("Ingrese el telefono");
		txtFijo.setPromptText("Ingrese el fijo");
		
		btnAgregar.setVisible(true);
		btnCancelar.setVisible(true);
		
		btnCerrar.setVisible(false);
		btnEditar.setVisible(false);
		btnGuardarCambios.setVisible(false);
		
	}

	public void setContacto(Contacto contactoSeleccionado) {
		this.contactoAux=contactoSeleccionado;
		if(contactoSeleccionado!=null)
		{
			txtNombre.setText(contactoSeleccionado.getNombre());
			txtTelefono.setText(contactoSeleccionado.getTelefono()+"");
			txtFijo.setText(contactoSeleccionado.getFijo()+"");

		}
			}

	private void guardarCambios() {

    	try {
			validarDatos();

			int telefono=Integer.parseInt(txtTelefono.getText());
			int fijo=Integer.parseInt(txtFijo.getText());

			
			main.eliminarContacto(contactoAux.getNombre());
			main.guardarContacto(new Contacto(txtNombre.getText(),telefono,fijo));

		} catch (DatosInvalidosException | NumberFormatException e) {
			e.printStackTrace();
		}

		
	}



	private void validarDatos() throws DatosInvalidosException {
		String mensaje="";
		if(txtNombre.getText().isEmpty())
			mensaje+="la casilla de nombre está vacía";
		if(txtTelefono.getText().isEmpty())
			mensaje+="la casilla de telefono está vacía";
		if(txtFijo.getText().isEmpty())
			mensaje+="la casilla de fijo está vacía";

		if(!mensaje.isEmpty())
			throw new DatosInvalidosException(mensaje);

		
	}



}