package TrabajoEspecial.Pocimas;

import TrabajoEspecial.Attribute;
import TrabajoEspecial.Card;

public class PocimaSelectiva extends Pocima {

	String attribute;
	double valor;
	
	public PocimaSelectiva(String attribute, double valor, String nombre) {
		super(nombre);
		this.attribute = attribute;
		this.valor = valor;
	}

	@Override
	public void aplicar(Card c) {
		Attribute a = new Attribute(attribute, 0);
		Attribute attribute = c.getAttribute(a.getClave());
		if(attribute != null) {
			attribute.setValue(attribute.getValue() + (attribute.getValue() * valor) / 100);
		}
	}

}
