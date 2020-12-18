package TrabajoEspecial;

public class StrategyTimbero extends Strategy {

	public StrategyTimbero() {
		
	}
	
	@Override
	public Attribute getAtributo(Card c) {
		return c.attributeRandom();
	}

}
