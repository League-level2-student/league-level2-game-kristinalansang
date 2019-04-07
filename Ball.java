import java.awt.Graphics;
import java.awt.Color;

public class Ball extends GameObject {

	int speed;
	boolean moveup, moveright;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		moveup = true;
		moveright = true;

		speed = 5;
		
	}
	
	void update() {
		super.update();
		
		if(y > HEIGHT)//if goes below platform
			isAlive = false;
		
		if(y <= 0)//if hits top
			moveup = false;
		
		if(x <= 0)//if  goes out of bounds on the left
			moveright = true;
		
		if(x => WIDTH)//if goes out of bounds on the right
			moveright = false;
		
		if(moveup)
			y -= speed;
		else
			y += speed;
		
		if(moveright)
			x += speed;
		else
			x -= speed;
			
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, width, height);;
	}
}
