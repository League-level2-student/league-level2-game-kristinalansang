
public class Ball extends GameObject {

	int speed;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.drawRect(x,y,width,height);
	}
}
