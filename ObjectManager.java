
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Ball ball;
	ArrayList<Bricks> brickList;
	int score;
	
	public ObjectManager(Rocketship r){
		brickList = new ArrayList<Bricks>();
		score = 0;
	}
	
	void update() {
		rocket.update();
		for(Bricks b : brickList)
			b.update();
		
	}
	
	void draw(Graphics g) {
		ball.draw(g);
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
			   score++;
		   }
   }
   
   int getScore() {
	   return score;
   }
   
}
