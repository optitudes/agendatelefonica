package application.model;


public class Dato {
	
	public String key;
	public String value;
	public Dato(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Dato [key=" + key + ", value=" + value + "]";
	}
	public boolean validarKey(String key2) {
		if(this.key.equals(key2))
			return true;
		return false;
	}
	
	

}
