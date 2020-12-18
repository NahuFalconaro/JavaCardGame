package TrabajoEspecial.Pocimas;

import TrabajoEspecial.Card;

public abstract class Pocima {
	
	String nombre;
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract void aplicar(Card c);

}
