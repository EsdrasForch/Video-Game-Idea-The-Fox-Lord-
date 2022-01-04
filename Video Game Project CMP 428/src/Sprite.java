import java.awt.Graphics;

public class Sprite
{
	
	// Position P
	double x;
	double y;
	
	// Velocity V
	double vx = 0;
	double vy = 0;
	
	// Accerleration a
	double ax = 0;
	double ay = gravity;
	
	
	int w;
	int h;
	
	
	final static double gravity = 50; 
	
	
	
	
	Animation[] animation;
	
	boolean moving = false;
	
	final int LT = 0;
	final int RT = 1;
	
	int action = RT;
	
	public Sprite(int x, int y, int w, int h, String name, String[] pose, int count, String filetype, int delay)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		animation = new Animation[pose.length];
		
		for(int i = 0; i < animation.length; i++)
			
			animation[i] = new Animation(name + pose[i], count, filetype, delay);
	}
	
	
	
	public void draw(Graphics pen)
	{
   	   if(moving)
	
		   pen.drawImage(animation[action].currentImage(), (int)x, (int)y, null);
		   
	   else

		   pen.drawImage(animation[action].stillImage(), (int)x, (int)y, null);
	   
	   moving = false;
	}
	
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	public void setAccelleration(double ax, double ay)
	{
		this.ax = ax;
		this.ay = ay;
	}
	
	public void jump()
	{
		vy = -8;
	}
	
	public void move()
	{
		// Moved based on current velocity
		x += vx;  
		y += vy;
		
		// Adjust Velocity based on current acceleration
		vx += ax;
		vy += ay;
		
		System.out.println(String.format("x: %d y: %d", (int)x, (int)y));
	}
	
	

	public void moveLeft(int dx)
	{
		x -= dx;
		
		moving = true;
		
		action = LT;
	}

	public void moveRight(int dx)
	{
		x += dx;
		
		moving = true;
		
		action = RT;
		
		
	}

	public void goLeft(int dx)
	{
		vx = -dx;
		
		moving = true;
		
		action = LT;
	}

	public void goRight(int dx)
	{
		vx = +dx;
		
		moving = true;
		
		action = RT;
	}

	public boolean overlaps(Rect r)
	{
		return (x + w >= r.x      ) &&
			   (x     <= r.x + r.w) &&
			   (y + h >= r.y      ) &&
			   (y     <= r.y + r.h);
	}
	
	
	public void pushUpFrom(Rect r1)
	{
		y -= y + h  - r1.y;
		
		vx = 0;
		vy = 0;
	}
	
	public boolean contains(int mx, int my)
	{
		return ( mx > x   ) &&   
			   ( mx < x+w ) && 
			   ( my > y   ) && 
			   ( my < y+h );
	}
	
	public void spawnPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}