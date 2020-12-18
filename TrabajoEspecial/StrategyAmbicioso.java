package TrabajoEspecial;

public class StrategyAmbicioso extends Strategy {
	
	public StrategyAmbicioso() {
	}
	
	@Override
	public Attribute getAtributo(Card c) {
		return (c.getMaxAttribute());
	}

}
