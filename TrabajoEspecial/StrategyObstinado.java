package TrabajoEspecial;

public class StrategyObstinado extends Strategy {
	
	String a;
	
	public StrategyObstinado(String a) {
		this.a = a;
		
	}
	
	public Attribute verificarAttribute(Card c) {
		if(c.getAttribute(this.a) == null) {
			Attribute ret = c.attributeRandom();
			this.a = ret.getClave();
			return ret;
			
		}
		return c.getAttribute(a);
	}

	@Override
	public Attribute getAtributo(Card c) {
		return this.verificarAttribute(c);
	}

}
