
public class Bricks extends GameObject{

	public Bricks (int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.drawRect(x,y,width, height);
	}
}
