
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Ball ball;
	Platform platform;
	ArrayList<Bricks> brickList;
	int score;
	
	public ObjectManager(Ball b, Platform p){
		ball = b;
		platform = p;
		
		brickList = new ArrayList<Bricks>();
		
		for(int x = 0; x < 500; x += 50)
			for(int y = 0; y < 300; y += 25)
				brickList.add(new Bricks(x,y,50,25));
		
		score = 0;
	}
	
	void update() {
		ball.update();
		platform.update();
		
		for(Bricks b : brickList)
			b.update();
		
	}
	
	void draw(Graphics g) {
		ball.draw(g);
		platform.draw(g);
		
		for(Bricks b : brickList)
			b.draw(g);
		
	}
	
   void purgeObjects() {
	   for(int i = 0; i < brickList.size(); i++)
		   if(!brickList.get(i).isAlive)
			   brickList.remove(i);
   }
   
   void checkCollision() {
	   for(Bricks b : brickList)
		   if(ball.collisionBox.intersects(b.collisionBox)) {
			   b.isAlive = false;
			   ball.movingup = false;
			   score++;
		   }
	   
	   if(ball.collisionBox.intersect(platform.collisionBox))
		   ball.movingup = true;

	   }
   
   int getScore() {
	   return score;
   }
   
}
