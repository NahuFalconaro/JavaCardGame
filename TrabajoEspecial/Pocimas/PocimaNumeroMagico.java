package TrabajoEspecial.Pocimas;

import java.util.ArrayList;

import TrabajoEspecial.Attribute;
import TrabajoEspecial.Card;

public class PocimaNumeroMagico extends Pocima {

	double valor;
	
	public PocimaNumeroMagico(double valor, String nombre) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public void aplicar(Card c) {
		ArrayList<Attribute> at = c.getAttributes();
		for(Attribute elem:at) {
			elem.setValue(valor);
		}
	}

}
