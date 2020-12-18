package TrabajoEspecial;

import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public void addCard(Card c) {
		if(deck.size() == 0) {
			deck.add(c);
		}else if(deck.get(0).equals(c)){
			this.deck.add(c);
		}
	}
	
	public Card getCard(int i) {
		return deck.get(i);
	}
	
	public int getSize() {
		return this.deck.size();
	}
	
	public Card getFirstCard() {
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}

}
