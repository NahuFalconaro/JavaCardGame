package TrabajoEspecial;

import TrabajoEspecial.Pocimas.Pocima;
import TrabajoEspecial.Pocimas.*;

public class Main {
	
	

	public static void main(String[] args) {
		
		String mazoPath = "./src/superheroes.json";
		
		int turnos = 40;
		
		Strategy s1 = new StrategyObstinado("peso");
		Strategy s2 = new StrategyTimbero();

		Player player1 = new Player("Nahuel", s1);
		Player player2 = new Player("Chole", s2);
		
		Pocima p1 = new PocimaFortalecedora(14, "Fortalecedora");
	    Pocima p2 = new PocimaFortalecedora(19, "Fortalecedora");
	    Pocima p3 = new PocimaNumeroMagico(28, "Numero Magico");
	    Pocima p4 = new PocimaNumeroMagico(25, "Numero Magico");
	    Pocima p5 = new PocimaSelectiva("peso", 1, "Selectiva");
	    Pocima p6 = new PocimaSelectiva("peso", 2, "Selectiva");
	    Pocima p7 = new PocimaReductora(29, "Reductora");
	    Pocima p8 = new PocimaReductora(7, "Reductora");
	    Pocima p9 = new PocimaCocktail(p1,p5, "Cocktail");
	    Pocima p10 = new PocimaCocktail(p2, p4, "Cocktail");
	    Pocima p11 = new PocimaFortalecedora(46, "Fortalecedora");
	    Pocima p12 = new PocimaNumeroMagico(2, "Numero Magico");
	    Pocima p13 = new PocimaSelectiva("altura", 30, "Selectiva");
	    Pocima p14 = new PocimaReductora(55, "Reductora");
	    Pocima p15 = new PocimaCocktail(p11, p13, "Cocktail");
		
		Game game = new Game(player1, player2, turnos);
		
		game.addPocima(p1);
		game.addPocima(p2);
		game.addPocima(p3);
		game.addPocima(p4);
		game.addPocima(p5);
		game.addPocima(p6);
		game.addPocima(p7);
		game.addPocima(p8);
		game.addPocima(p9);
		game.addPocima(p10);
		game.addPocima(p11);
		game.addPocima(p12);
		game.addPocima(p13);
		game.addPocima(p14);
		game.addPocima(p15);
		
        game.initGame(mazoPath);
        
        game.roadToGame(turnos);
	}
}
