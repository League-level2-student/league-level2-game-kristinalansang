import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bricks extends GameObject{

	public Bricks (int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}
}
