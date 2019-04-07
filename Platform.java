import java.awt.Graphics;
import java.awt.Color;

public class Platform extends GameObject{

	int speed;
	
	public Platform(int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 5;
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
}
