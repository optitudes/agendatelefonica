package application.model;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class TablaHash {

	private Celda [] arreglo;

	public TablaHash() {
		super();
		arreglo=new Celda[10];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i]=new Celda();
		}
	}

	/*
	 * método que recibe un Dato y lo asigna a un nodo(arraylist)
	 */
	public void put(String key, Contacto value) {
		int pos=gethash(key);
		if(arreglo[pos].obtenerContacto(key)==null)
		{
			arreglo[pos].put(value);
		}else {
			System.err.println("el contacto ya existe");
		}
	}
	/*
	 * método que obtiene e imprime la información de un Dato
	 * por medio de su key
	 */
	public Contacto get(String key) {
		int pos=gethash(key);
		Contacto contactoAux=arreglo[pos].obtenerContacto(key);
		return contactoAux;
		
	}
	/*
	 * método que elimina un Dato de su nodo(arraylist)
	 * usando su key
	 */
	public void rm(String key) {
		int pos=gethash(key);
		if(arreglo[pos].rm(key))
		{
			System.out.println("dato eliminado con éxito");

		}else {
			System.err.println("el dato no se pudo eliminar");
		}
	}
	/*
	 * método que imprime todos los Datos de la hashtable
	 */
	public ArrayList<Contacto> getAll() {
		ArrayList<Contacto> listaTotal= new ArrayList<Contacto>();

		for (int i = 0; i < arreglo.length; i++) {
			listaTotal.addAll(arreglo[i].getListaContactos());
		}
		
		return listaTotal;
	}
	/*
	 * método que obtiene la posición de un Dato usando su key
	 */
	public int gethash(String hash) {return Math.abs(hash.hashCode()%arreglo.length) ;}

	/*
	 * método que redimensiona la tablehash(elimina todos los datos)
	 */
	public void redimensionar(int tamanio) {

		Celda [] arregloNuevo=new Celda[tamanio];
		for (int i = 0; i < arregloNuevo.length; i++) {
			arregloNuevo[i]=new Celda();
		}
		
		this.arreglo=arregloNuevo;
		System.out.println("Redimensionamiento completado");
	}


}
