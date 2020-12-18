package TrabajoEspecial;

import java.util.ArrayList;

import TrabajoEspecial.Pocimas.Pocima;

public class Card {

	private ArrayList<Attribute> attributes;
	private String name;
	Pocima pocima;
	
	public Card(String name) {
		this.name = name;
		this.attributes = new ArrayList<Attribute>();
		this.pocima = null;
	}
	
	public void setPocima(Pocima p) {
		this.pocima = p;
	}
	
	public Card returnCopia() {
        Card copia = new Card(this.name);
        copia.setPocima(this.pocima);
        copia.setAttributes(this.getAttributes());
        return copia;
    }
	
	public void aplicarPocima() {
		Card c = this.returnCopia();
		if(c.getPocima() != null) {
			c.setPocima(this.pocima);
			c.getPocima().aplicar(c);
		}
	}
	
	public int enfrentar(Card rival, Attribute atr) {
		this.aplicarPocima();
		rival.aplicarPocima();
		return this.getAttribute(atr.getClave()).comparar(rival.getAttribute(atr.getClave()));
	}
	
	public Pocima getPocima() {
        return this.pocima;
    }
	
	public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes.addAll(attributes);
    }

	public String showPocima(Attribute a) {
		if(pocima != null) {
			this.aplicarPocima();
			return ("Se aplico la pocima " + this.pocima.getNombre() + " valor resultante " + a.getValue());
		}
		return "";
	}
	
	public void addAttribute(Attribute a) {
		attributes.add(a);
	}
	
	public ArrayList<Attribute> getAttributes(){
		return this.attributes;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Attribute getMaxAttribute() {
		Attribute retorn = attributes.get(0);
		for(Attribute at:attributes) {
			if(at.comparar(retorn) > 1) {
				retorn = at;
			}
		}
		return retorn;
	}
	
	public Attribute attributeRandom() {
		return attributes.get((int)(Math.random() * attributes.size()));
	}

	public int getSizeAttributes() {
		return this.attributes.size();
	}

	public Attribute getAttribute(String a) {
		for(int i = 0; i < attributes.size(); i++) {
			if(attributes.get(i).compareAttribute(a)) {
				return attributes.get(i);
			}
		}
		return null;
	}
	
	public boolean equals(Object o) {
		Card c = (Card)o;
		if(this.attributes.size() == c.getSizeAttributes()) {
			if(c.getAttribute(this.attributes.get(0).getClave()) == null) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public String toString() {
		return (this.name);
	}
}
