package application.model;

public class Contacto {
	
	private String nombre;
	private Integer    telefono;
	private Integer    fijo;
	public Contacto(String nombre, int telefono, int fijo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.fijo = fijo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Integer getFijo() {
		return fijo;
	}
	public void setFijo(int fijo) {
		this.fijo = fijo;
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", fijo=" + fijo + "]";
	}
	public boolean validarKey(String key) {
		if(nombre.equals(key))
			return true;
			
		return false;
	}
	
	
	

}
