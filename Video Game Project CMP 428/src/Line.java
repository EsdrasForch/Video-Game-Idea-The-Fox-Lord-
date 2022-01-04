import java.awt.Graphics;

public class Line
{
	int x1;
	int y1;
	
	int x2;
	int y2;
	
	public Line(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;

		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(Graphics pen)
	{
		pen.drawLine(x1, y1, x2, y2);
	}
	
	public void moveLeft(int dx)
	{
		x1 -= dx;
		x2 -= dx;
	}
	
	public void moveRight(int dx)
	{
		x1 += dx;
		x2 += dx;
	}
	
	public void moveUp(int dy)
	{
		y1 -= dy;
		y2 -= dy;
	}
	
	public void moveDown(int dy)
	{
		y1 += dy;
		y2 += dy;
	}
	
	public void moveBy(int dx, int dy)
	{
		x1 += dx;
		y1 += dy;
		
		x2 += dx;
		y2 += dy;
	}


}