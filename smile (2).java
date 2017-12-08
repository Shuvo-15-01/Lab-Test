package shuvo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Smile extends JFrame {
	public Smile(int height, int width)
	{

		super.setTitle("Smile");
		super.setSize(height,width);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);


	}
public static void main(String[] args)
{
	new Smile(350,350);
}
public void paint(Graphics s)
{
	s.setColor(Color.YELLOW);
	s.fillArc(100, 100, 200, 200, 0, 360);
	s.setColor(Color.BLUE);
	s.fillArc(140, 150, 40, 40, 0, 360);
	s.fillArc(220, 150, 40, 40, 0, 360);
	s.setColor(Color.RED);
	s.drawArc(160, 180, 80, 80, 200, 140);


}
}









