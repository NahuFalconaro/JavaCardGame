package TrabajoEspecial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;



import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import TrabajoEspecial.Pocimas.Pocima;

public class Game {

	private Deck deck;
	private Player p1;
	private Player p2;
	private ArrayList<Pocima> pocimas;
	private int turnosMax;
	private boolean turnoDe1;
	
	public Game (Player p1, Player p2, int turnosMax) {
		this.p1 = p1;
		this.p2 = p2;
		this.deck = new Deck();
		this.pocimas = new ArrayList<Pocima>();
		this.turnosMax = turnosMax;
		this.turnoDe1 = true;
	}
	
	private void repartirCartas() {
		while(deck.getSize() > 1) {
			p1.addCard(deck.getFirstCard());
			p2.addCard(deck.getFirstCard());
		}
	}
	
	public void initGame(String jsonFile) {
		File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");

                Card c1 = new Card(nombreCarta);

                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet()) {
                    atributosStr = atributosStr + nombreAtributo + ": " +
                            atributos.getInt(nombreAtributo) + "; ";
                            Attribute a1 = new Attribute(nombreAtributo, atributos.getInt(nombreAtributo));
                    c1.addAttribute(a1);
                //System.out.println(c1.getName() + "-" + c1.devolverAtributo(a1));
                }
                this.deck.addCard(c1);
            }
            this.repartir();
            reader.close();

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public void roadToGame(int turnos) {
		for(int i = 0; i <= turnos; i++) {
        	System.out.println(this.Jugar(i));
        }
	}
	
	public void repartir(){
		for(int i=0; i < this.pocimas.size(); i++) {
			Pocima p = pocimas.get(i);
            if(p != null) {
                this.deck.getCard(i).setPocima(p);
            }else {
                i = this.deck.getSize();
            }
            pocimas.remove(i);
        }
		this.repartirCartas();
	}
	
	public void addPocima(Pocima p) {
		this.pocimas.add(p);
	}
	
	public void changeTurns() {
		if(turnoDe1) {
			this.turnoDe1 = false;
		}else {
			this.turnoDe1 = true;
		}
	}
	
	public String Jugar(int turnos) {
		if(!p1.isEmptyDeck() && !p2.isEmptyDeck()) {
			if((turnos < turnosMax) && this.turnoDe1) {
				return ("------Ronda Numero " + turnos + "------ \n") + this.JugarRonda(p1, p2);
			}else if((turnos < turnosMax) && !this.turnoDe1) {
				return ("------Ronda Numero " + turnos + "------ \n") + this.JugarRonda(p2, p1);
			}else{
				if(isFinishGame(p1, p2) > 0) {
					return this.showWon(p1);
				}else if(isFinishGame(p1, p2) < 0) {
					return this.showWon(p2);
				}else {
					return this.showEmpate(p1, p2);
				}
			}
		}else if(turnos < turnosMax){
			if(p1.isEmptyDeck()) {
				this.turnosMax = turnos;
				return this.showWon(p2);
			}else {
				this.turnosMax = turnos;
				return this.showWon(p1);
			}
		}else {
			return "";
		}
	}
	
	private String JugarRonda(Player pPlay, Player pRival) {
		String retorno = "";
		
		
		Card cPlay = pPlay.copyFirstCard();
		Attribute aPlay = pPlay.getAttribute(cPlay);
		Card cRival = pRival.copyFirstCard();
		Attribute aRival = cRival.getAttribute(aPlay.getClave());
		
		retorno += this.showAttribute(pPlay, aPlay);
		retorno += this.showCard(pPlay, cPlay, aPlay);
		retorno += this.showCard(pRival, cRival, aRival);

		int resultado = pPlay.enfrenta(pRival);
		
		if(resultado != 0) {
			if(resultado > 0) {
				pPlay.addWinCard(pPlay.firstCard(), pRival.firstCard());
				retorno += showWinner(pPlay, pRival);
			}else {
				this.changeTurns();
				pRival.addWinCard(pPlay.firstCard(), pRival.firstCard());
				retorno += showWinner(pRival, pPlay);
			}
		}
		return retorno;
	}
	
	
	private String showAttribute(Player player, Attribute atr) {
		return ("El jugador " + player + " selecciona competir por el atributo " + atr.getClave() + "\n");
	}
	
	private String showCard(Player player, Card carta, Attribute atr) {
		String retorno = "";
		retorno += ("La carta de " + player + " es " + carta + " con " + atr);
		retorno += (" " + carta.showPocima(atr) + "\n");
		return retorno;
	}
	
	private String showWinner(Player ganador, Player perdedor) {
		return ("Gana la ronda " + ganador + " y queda con " + ganador.getSizeDeck() + " cartas (" + perdedor + 
				" ahora posee " + perdedor.getSizeDeck() + " cartas) \n");
	}
	
	private String showEmpate(Player pPlay, Player pRival) {
		return ("Empato la ronda " + pPlay + " y queda con " + pPlay.getSizeDeck() + " cartas y " + pRival + 
				" ahora posee " + pRival.getSizeDeck() + " cartas \n");
	}
	
	private String showWon(Player ganador) {
		return ("****GANO EL JUGADOR " + ganador + " *******");
	}
	
	private int isFinishGame(Player p1, Player p2) {
		if(p1.getSizeDeck() > p2.getSizeDeck()) {
			return 1;
		}else if(p1.getSizeDeck() < p2.getSizeDeck()) {
			return -1;
		}else {
			return 0;
		}
	}
}























