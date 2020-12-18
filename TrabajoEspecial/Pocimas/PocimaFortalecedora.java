package TrabajoEspecial.Pocimas;

import java.util.ArrayList;

import TrabajoEspecial.Attribute;
import TrabajoEspecial.Card;

public class PocimaFortalecedora extends Pocima {

	int valor;
	
	public PocimaFortalecedora(int valor, String nombre) {
		super(nombre);
		this.valor = valor;
	}
	
	@Override
	public void aplicar(Card c) {
		ArrayList<Attribute> at = c.getAttributes();
		for(Attribute elem:at) {
			elem.setValue(elem.getValue() + ((elem.getValue() * valor) / 100));
		}
	}
}
