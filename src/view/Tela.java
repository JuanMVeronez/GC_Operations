package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

public class Tela extends JPanel {
	
	Shape desenho;
	
	public Tela(Shape desenho) {
		this.desenho = desenho;
	}
	
	public void atualiza(Shape desenho) {
		this.desenho = desenho;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		this.setBackground(new Color(230, 230, 230));
		
		g2d.setStroke(new BasicStroke(15));
		
		g2d.fill(desenho);
		
	}

}
