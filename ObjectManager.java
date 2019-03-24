
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	/*Rocketship rocket;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> alienList;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;*/
	Ball ball;
	ArrayList<Bricks> brickList;
	int score;
	
	public ObjectManager(Rocketship r){
		/*rocket = r;
		projectiles = new ArrayList<Projectile>();
		alienList = new ArrayList<Alien>();*/
		brickList = new ArrayList<Bricks>();
		score = 0;
	}
	
	void update() {
		rocket.update();
		/*for(Projectile p : projectiles)
			p.update();
		for(Alien a : alienList)
			a.update();*/
	}
	
	void draw(Graphics g) {
		/*rocket.draw(g);
		for(Projectile p : projectiles)
			p.draw(g);
		for(Alien a : alienList)
			a.draw(g);*/
	}
	/*
	void addProjcetile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien(Alien a) {
		alienList.add(a);
	}
	*/
	/*
	void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
                enemyTimer = System.currentTimeMillis();
        }
   }
        */
   void purgeObjects() {
	   for(int i = 0; i < alienList.size(); i++)
		   if(!alienList.get(i).isAlive)
			   alienList.remove(i);
   }
   
   void checkCollision() {
	   for(Bricks b : brickList)
		   if(ball.collisionBox.intersects(b.collisionBox)) {
			   b.isAlive = false;
			   score++;
		   }
	   /*for(Alien a : alienList)
	   {
		   if(rocket.collisionBox.intersects(a.collisionBox))
			   rocket.isAlive = false;
		   for(Projectile p : projectiles)
			   if(a.collisionBox.intersects(p.collisionBox)) {
				   a.isAlive = false;
				   score++;
			   }
	   }*/
   }
   
   int getScore() {
	   return score;
   }
   
}
