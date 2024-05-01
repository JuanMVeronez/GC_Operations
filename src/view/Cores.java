package view;

import java.awt.Color;

public enum Cores {
	
	VERMELHO(Color.RED),
	LARANJA(Color.ORANGE), 
	AMARELO(Color.YELLOW), 
	VERDE(Color.GREEN), 
	AZUL(Color.BLUE), 
	INDIGO(Color.CYAN), 
	VIOLETA(Color.MAGENTA);
	
	Color cor;
	private Cores(Color cor) {
		this.cor = cor;
	}
	
	public Color getCor() {
		return cor;
	}
	
	public Cores next() {
		return values()[ (ordinal()+1) % values().length ];
	}
	

}
