package TrabajoEspecial;

public class Attribute {

	private String attribute;
	private double value;
	
	public Attribute(String attribute, double value) {
		this.attribute = attribute;
		this.value = value;
	}

	public String getClave() {
		return this.attribute;
	}

	public double getValue() {
		return this.value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public int comparar(Attribute a) {
		if(this.value > a.getValue()) {
			return 1;
		}else if(this.value == a.getValue()) {
			return 0;
		}else {
			return -1;
		}
	}
	
	public boolean compareAttribute(String a) {
		return(this.attribute.equals(a));
	}
	
	public boolean equals(Object o) {
		Attribute a = (Attribute)o;
		return(a.getClave().equals(this.attribute) && this.value == a.getValue());
	}
	
	public String toString() {
		return (this.attribute + " " + this.value);
	}
}
