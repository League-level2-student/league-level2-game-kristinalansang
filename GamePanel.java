
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
		//timer = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.BOLD, 48);
		titleFont1 = new Font("Arial", Font.BOLD, 25);
		ball = new ball(250,700,50,50);
		
		/*
		rocket = new Rocketship(250, 700, 50, 50);
		manager = new ObjectManager(rocket);
		
		
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

    }
*/

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
		//gameobject.draw(g);
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
			platform.x += rocket.speed;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			platform.x -= rocket.speed;

		if(e.getKeyCode() ==KeyEvent.VK_SPACE && currentState == MENU_STATE)
			JOptionPane.showConfirmDialog(null, "Use arrow keys to move left and right. Try not to die");
			
		
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
		if(!rocket.isAlive)
			currentState = END_STATE;
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("BRICK BREAKER", 20, 200);
		
		g.setFont(titleFont1);
		
		g.drawString("Press ENTER to start", 125, 350);
		g.drawString("Press SPACE for instructions",80, 500);
	}
	
	void drawGameState(Graphics g) {
		//g.drawImage(spaceImg, WIDTH, HEIGHT, null);
		manager.draw(g);
		
	}


	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 200);
		
		g.setFont(titleFont1);
		g.drawString("You got " + manager.getScore() + " points", 125, 350);
		g.drawString("Press ENTER to restart",110, 500);
	}
}
