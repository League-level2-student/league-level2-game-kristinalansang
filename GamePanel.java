
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont, titleFont1;
	Ball ball;
	ObjectManager manager;
	int level;
	
	/*
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
    */
	
	GamePanel(){
		timer = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.BOLD, 48);
		titleFont1 = new Font("Arial", Font.BOLD, 25);
		ball = new ball(250,700,50,50);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//gameobject.update();
		repaint();
		if(currentState == MENU_STATE){
            updateMenuState();
		}else if(currentState == GAME_STATE){
            updateGameState();
		}else if(currentState == END_STATE){
            updateEndState();
		}
	}
	
	void startGame()
	{
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
            drawMenuState(g);
		}else if(currentState == GAME_STATE){
            drawGameState(g);
		}else if(currentState == END_STATE){
            drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keytyped");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			platform.x += platform.speed;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			platform.x -= platform.speed;

		if(e.getKeyCode() ==KeyEvent.VK_SPACE && currentState == MENU_STATE)
			JOptionPane.showConfirmDialog(null, "Use arrow keys to move left and right. Don't let the ball go below the platform");
			
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == END_STATE) {
				//rocket = new Rocketship(250, 700, 50, 50);
				ball = new Ball(250,700,50,50);
				manager = new ObjectManager(rocket);
			}
			if(currentState >= END_STATE)
				currentState = MENU_STATE;
			else
				currentState++;
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyreleased");
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		manager.update();
		//manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if(!ball.isAlive)
			currentState = END_STATE;
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, BrickBreaker.WIDTH, BrickBreaker.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("BRICK BREAKER", 20, 200);
		
		g.setFont(titleFont1);
		
		g.drawString("Press ENTER to start", 125, 350);
		g.drawString("Press SPACE for instructions",80, 500);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, BrickBreaker.WIDTH, BrickBreaker.HEIGHT);
		
		manager.draw(g);
		
	}


	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, BrickBreaker.WIDTH, BrickBreaker.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 200);
		
		g.setFont(titleFont1);
		g.drawString("You got " + manager.getScore() + " points", 125, 350);
		g.drawString("Press ENTER to restart",110, 500);
	}
}
