package application.model;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.collections.ObservableList;

public class Agenda {
	private String iD;
	private TablaHash tablaContactos= new TablaHash();
	
	public Agenda(String iD) {
		super();
		this.iD = iD;
		setearDatos();
	}

	private void setearDatos() {
		tablaContactos.put("pablo", new Contacto("pablo",123333,72344));
		tablaContactos.put("daniel", new Contacto("daniel",22222223,7344));
		
	}

	public ArrayList<Contacto> getContacts() {
		return tablaContactos.getAll();
	}

	public void rm(String nombre) {
		tablaContactos.rm(nombre);
		
	}

	public void put(Contacto contacto) {
		tablaContactos.put(contacto.getNombre(), contacto);
	}

	public Contacto getContact(String key) {
		return tablaContactos.get(key);
	} 


}
