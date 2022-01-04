import java.awt.*;

// Class to represent Axis-Aligned Rectangles


public class Rect
{
	int x;
	int y;
	
	int w;
	int h;
	
	Color color = Color.BLACK;
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
	}
	
	public Rect(int x, int y, int w, int h, Color color)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
		
	    setColor(color);
	}
	
	public void moveLeft(int dx)
	{
		x -= dx;
	}
	
	public void moveRight(int dx)
	{
		x += dx;
	}
	
	public void moveUp(int dy)
	{
		y -= dy;
	}
	
	public void moveDown(int dy)
	{
		y += dy;
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public boolean contains(int mx, int my)
	{
		return ( mx > x   ) &&   
			   ( mx < x+w ) && 
			   ( my > y   ) && 
			   ( my < y+h );
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public boolean contains_v2(int mx, int my)
	{
		return (mx > x) && (mx < x + w) && (my > y) && (my < y + h);
	}
	
	public boolean contains_v1(int mx, int my)
	{
		if((mx > x) && (mx < x + w) && (my > y) && (my < y + h))
			
			return true;
		
		else
			
			return false;		
	}
	
	public void draw(Graphics pen)
	{
		pen.setColor(color);
		
		pen.drawRect(x, y, w, h);
	}
}