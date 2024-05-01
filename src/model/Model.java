package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import entity.Desenho;

public class Model {
	
	Desenho desenho = new Desenho(3);
	
	public Model() {
	}
	
	public void updateQuantidade(int quantidadePontos) {
		desenho.updateQuantidadePontos(quantidadePontos);
	}
	
	public Shape makeTransformacoes(
			Point2D.Double t,  // valor da transformação de translação
			Point2D.Double s,  // valor da transformação de escala
			Point2D.Double sh, // valor da transformação de cisalhamento
			double a  // valor do angulo de rotação
			) {
		
		Point2D.Double pontoCentral = desenho.getPontoCentral();
		
		AffineTransform transformacao = new AffineTransform();
		
		// Transformação de Escala
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(-pontoCentral.x, -pontoCentral.y));
		transformacao.preConcatenate(AffineTransform.getScaleInstance(s.x, s.y));
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(pontoCentral.x, pontoCentral.y));

		// Transformação de Cisalhamento
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(-pontoCentral.x, -pontoCentral.y));
		transformacao.preConcatenate(AffineTransform.getShearInstance(sh.x, sh.y));
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(pontoCentral.x, pontoCentral.y));

		// Transformação de rotação
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(-pontoCentral.x, -pontoCentral.y));
		transformacao.preConcatenate(AffineTransform.getRotateInstance(a));
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(pontoCentral.x, pontoCentral.y));

		// Transformação de Translação
		transformacao.preConcatenate(AffineTransform.getTranslateInstance(t.x, t.y));
		
		Shape desenhoTransformado = transformacao.createTransformedShape(desenho);
		
		return desenhoTransformado;
		
		
	}
	
	public Desenho getDesenho() {
		return desenho;
	}
	
	
	

}
