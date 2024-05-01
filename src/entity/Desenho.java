package entity;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Desenho extends Path2D.Double {
	
	double raio;
	Point2D.Double centro;
	int quantidadePontos;
	
	public Desenho(int aQuantidadePontos) {
		super();
		this.quantidadePontos = aQuantidadePontos;
		centro = new Point2D.Double(350, 350);
		raio = 100;
		
		updateCirculo();
	}
	
	public void updateQuantidadePontos(int aQuantidadePontos) {
		this.quantidadePontos = aQuantidadePontos;
		updateCirculo();
	}
	
	private void updateCirculo() {
		reset();
		double intervaloMinimo = 0, intervalorMaximo = 2*Math.PI;
		double incremento = intervalorMaximo/quantidadePontos;
		
		Point2D.Double pontoInicial = calculaPonto(intervaloMinimo);
		
		moveTo(pontoInicial.x, pontoInicial.y);
		
		for(int i=1; i<quantidadePontos; i++) {
			double t = i*incremento;
			Point2D.Double p = calculaPonto(t);
			lineTo(p.x, p.y);
		}
		
		closePath();
		
	}
	
	private Point2D.Double calculaPonto(double t){
		double x = centro.x + raio*Math.cos(t);
		double y = centro.y + raio*Math.sin(t);
		return new Point2D.Double(x, y);
	}
	
	
	
	public Point2D.Double getPontoCentral() {
		Rectangle2D.Double retangulo = (Rectangle2D.Double)getBounds2D();
		
		Point2D.Double canto = new Point2D.Double(retangulo.x, retangulo.y);
		
		Point2D.Double pontoCentral = new Point2D.Double(
				canto.x + retangulo.width/2, 
				canto.y + retangulo.height/2 
				);
		
		return pontoCentral;
	}
	
	

}
