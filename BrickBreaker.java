import java.awt.Dimension;

import javax.swing.JFrame;

public class BrickBreaker {
	JFrame window;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel game;
	
	public LeagueInvaders() {
		window = new JFrame();
		game = new GamePanel();
	}
	
	void main(String[] args)
	{
		BrickBreaker b = new BrickBreaker();
		b.setup();
	}
	
	void setup() {
		window.add(game);
		window.addKeyListener(game);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.pack();

        game.startGame();
	}
}
