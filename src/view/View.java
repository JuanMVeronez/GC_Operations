package view;

import java.awt.Shape;
import java.awt.geom.Point2D;

import javax.swing.event.ChangeListener;

import entity.Desenho;

public class View {
	
	Janela janela;
	
	public View(Shape desenho) {
		janela = new Janela(desenho);
	}
	
	public void atualiza(Shape desenho) {
		janela.atualiza(desenho);
	}
	
	public void adicionaListenerSlide(ChangeListener cl) {
		janela.adicionaListenerSlide(cl);
	}
	
	public Point2D.Double getValorT() {
		return janela.getValorSlideT();
	}

	public Point2D.Double getValorScale() {
		return janela.getValorSlideScale();
	}

	public Point2D.Double getValorShear() {
		return janela.getValorSlideShear();
	}

	public int getValorQtd() {
		return janela.getValorSlideQtd();
	}

	public double getValorR() {
		return janela.getValorSlideR();
	}

}
