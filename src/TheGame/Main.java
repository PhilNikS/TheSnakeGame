package TheGame;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Window window = new Window();
		
		frame.setBounds(450, 220, 871, 675);
		frame.setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("The Snake 2D");
		
		
		frame.add(window);
		
		

		
		frame.setVisible(true);
		
		


	}

}
