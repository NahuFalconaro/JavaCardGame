package TrabajoEspecial.Pocimas;

import TrabajoEspecial.Card;

public class PocimaCocktail extends Pocima {

	Pocima p1,p2;
	
	public PocimaCocktail(Pocima p1, Pocima p2, String nombre) {
		super(nombre);
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public void aplicar(Card c) {
		p1.aplicar(c);
		p2.aplicar(c);
	}

}
