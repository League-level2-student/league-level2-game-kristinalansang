import java.awt.Graphics;

public class Ball extends GameObject {

	int speed;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.drawOval(x, y, width, height);;
	}
}
