import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    boolean isAlive;
    Rectangle collisionBox;
    
    
    GameObject(int a, int b, int w, int h){
    		x = a;
    		y = b;
    		width = w;
    		height = h;    	
    		isAlive = true;
    		collisionBox = new Rectangle(x,y,w,h);
    }
    
    void update() {
    		collisionBox.setBounds(x, y, width, height);
    }
    
    void draw(Graphics g) {
    		
    }
}