package TrabajoEspecial;

public class Player {

	Deck deck;
	String name;
	Strategy estrategia;
	
	public Player(String name, Strategy estrategia) {
		this.deck = new Deck();
		this.name = name;
		this.estrategia = estrategia;
	}
	
	public String getName() {
		return name;
	}

	public void addCard(Card c) {
		this.deck.addCard(c);
	}
	
	public void setStrategy(Strategy s) {
		this.estrategia = s;
	}
	
	public Attribute getAttribute(Card c) {
		return this.estrategia.getAtributo(c);
	}

	public int enfrenta(Player r) {
		Card cardPlayer = this.copyFirstCard();
		Card cardRival = r.copyFirstCard();
		return cardPlayer.enfrentar(cardRival, this.estrategia.getAtributo(cardPlayer));
	}

	public Card firstCard() {
		return this.deck.getFirstCard();
	}
	
	public Card copyFirstCard() {
		return this.deck.getCard(0).returnCopia();
	}

	public int getSizeDeck() {
		return deck.getSize();
	}
	
	public void addWinCard(Card c1, Card c2) {
		this.addCard(c1);
		this.addCard(c2);
	}
	
	public boolean isEmptyDeck() {
		return (this.deck.getSize() == 0);
	}
	
	public String toString() {
		return (this.name);
	}
}
