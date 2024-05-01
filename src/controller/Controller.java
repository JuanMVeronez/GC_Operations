package controller;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import view.View;

public class Controller {
	
	View view;
	Model model;
	
	public Controller() {
		model = new Model();
		view = new View(model.getDesenho());
		
		view.adicionaListenerSlide(new MudaSlide());
	}
	
	class MudaSlide implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			int quantidadePontos = view.getValorQtd();
			model.updateQuantidade(quantidadePontos);
			
			double rotation = view.getValorR();
			Point2D.Double translation = view.getValorT();
			Point2D.Double scale = view.getValorScale();
			Point2D.Double shear = view.getValorShear();

			
			Shape desenho = model.makeTransformacoes(translation, scale, shear, rotation);
			
			view.atualiza(desenho);
		}
		
	}
	

}
