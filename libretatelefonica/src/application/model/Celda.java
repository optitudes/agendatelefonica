package application.model;


import java.util.ArrayList;
import java.util.Collection;

public class Celda {
	public ArrayList<Contacto>  listaContactos= new ArrayList<Contacto>();

	public Celda() {
		super();
	}

	public ArrayList<Contacto> getListaContactos(){
		return listaContactos;
	}

	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	@Override
	public String toString() {
		return "Column--> [listaContactos=" + listaContactos + "]";
	}
	/*
	 * método que compara la key ingresada por parametro
	 * con las keys del nodo, retorna el Dato en caso
	 * de que coincida con algun Dato del nodo
	 */
	public Contacto obtenerContacto(String key)
	{
		for (Contacto contacto : listaContactos) {
			if(contacto.validarKey(key))
				return contacto;
		}
		return null;
	}

	/*
	 * método que agrega un dato al nodo
	 */
	public void put(Contacto contacto) {
		listaContactos.add(contacto);
		System.out.println("contacto agregado: "+contacto.toString());
	}
	/*
	 * método que valida si el nodo está vacio
	 * retorna true si está vacio o false en caso contrario
	 */
	public boolean isEmpty() {
		if(listaContactos.size()==0)
			return true;
		return false;
	}

	/*
	 * método que elimina un Dato del nodo usando su key
	 */
	public boolean rm(String key) {
		for (Contacto contacto : listaContactos) {
			if(contacto.validarKey(key)) {
				listaContactos.remove(contacto);
				return true;
			}
		}
		return false;
	}

	public int obtenerTamanio() {return listaContactos.size();}

}
