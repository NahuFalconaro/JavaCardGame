package TrabajoEspecial.Pocimas;

import java.util.ArrayList;

import TrabajoEspecial.Attribute;
import TrabajoEspecial.Card;

public class PocimaReductora extends Pocima {

	double valor;
	
	public PocimaReductora(double valor, String nombre) {
		super(nombre);
		this.valor = valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public void aplicar(Card c) {
		ArrayList<Attribute> at = c.getAttributes();
		for(Attribute elem:at) {
			elem.setValue(elem.getValue() - (elem.getValue() * valor) / 100);
		}

	}

}
