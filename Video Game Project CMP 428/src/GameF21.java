import java.awt.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

import java.applet.Applet;


//Final Location : 805 - 830

public class GameF21 extends    Applet
                     implements Runnable, 
                                KeyListener, 
                                MouseListener
                            
                                
                                
                               
                                
                                
{

	//Boolean array that will store all of our Key event indexes
	boolean [] pressing = new boolean[1000];
	
	
	
	//Image variables for the sprites
	Image blast;
    Image moth;
	Image Foxe;
	Image grassp;
	Image moth2;
	Image blu;
	Image tower;
	
	//damage and health variables
	//int damage = 0;
	//int health = 3;
	

	//Class variables for our key events which will allow us to use our key inputs on different methods such as moving 
	final static int RT    = KeyEvent.VK_RIGHT;
	final static int LT    = KeyEvent.VK_LEFT;
	final static int UP    = KeyEvent.VK_UP;
	final static int DN    = KeyEvent.VK_DOWN;
	
	
	final static int SPACE   = KeyEvent.VK_SPACE;
	final static int SHIFT   = KeyEvent.VK_SHIFT;
	final static int CONTROL = KeyEvent.VK_CONTROL;
	final static int TAB     = KeyEvent.VK_TAB;
	
//-------------------------------------------------------------------------------------------------------------------//	
	
	//Player object that is created with a set location and dimensions
	Fox fox = new Fox(5, 730, 30, 50);
	
	
	ImageLayer sky            = new ImageLayer("Layer_0010_1.png", 30);
	ImageLayer shadedTrees    = new ImageLayer("Layer_0009_2.png", 10);
	ImageLayer regularTrees   = new ImageLayer("Layer_0008_3.png", 8);
	ImageLayer moreTrees      = new ImageLayer("Layer_0005_5.png", 6);
	ImageLayer evenMoreTrees  = new ImageLayer("Layer_0003_6.png", 4);
	ImageLayer treeLeaves     = new ImageLayer("Layer_0002_7.png", 3);
	ImageLayer grass          = new ImageLayer("Layer_0001_8.png", 2);
	ImageLayer darkGrass      = new ImageLayer("Layer_0000_9.png", 1);
	
	
	
	Image     offscreen_image;
	Graphics  offscreen_pen;
	

	
	//Grassy plain collision. The player will use this rectangle as the main physical platform
	Rect r1 = new Rect(0, 760, 4000, 50);
	
	
	//Extra platforms for our sprite to jump on
	Rect r2 = new Rect(700, 700, 65, 20);
	Rect r3 = new Rect(800, 700, 20, 20);
	Rect r4 = new Rect(790, 700, 65, 20);
	Rect r5 = new Rect(500, 700, 200, 20);
	Rect r6 = new Rect(600, 670, 200, 20);
	Rect r7 = new Rect(700, 710, 200, 20);
	Rect r8 = new Rect(750, 650, 200, 20);

	
	//-------------------------------------------------------------------------------------------------------------------//	


	
	//Init function to initialize our applet 
	public void init()
	{
		
		
		//method to request the focus of your program window 
		requestFocus();
		
		//Key listener for our pressed keys 
		addKeyListener(this);
		
		
		addMouseListener(this);
		
		
		offscreen_image = createImage(1920, 1080);  // offscreen_image is the double buffer
		offscreen_pen   = offscreen_image.getGraphics();
		
		
		//Thread method that will use a run method 
		Thread t = new Thread(this);
		
		//Starts the thread that was created
		t.start();
		
		//This play method will search for our au file in our directory and play as soon as the applet loads
		play(getCodeBase (), "DeepForest.au");
		
		
		blast = getImage(getDocumentBase(), "b.gif");
		moth   = getImage(getDocumentBase(),"moth1.gif");
		//Foxe   = getImage(getDocumentBase(),"foxer.gif");
		//moth2   = getImage(getDocumentBase(),"moth2.gif");
		blu   = getImage(getDocumentBase(),"Destroyer.gif");
		tower   = getImage(getDocumentBase(),"tower.png");
		
		
		
	}
	
		  


	
	//Method that keeps track of game time
	public void run()
	{
		
	
		while(true)
		{
			
			//I enclosed an if statement around the camera and player pressing to make our scroll stop after a certain point 
			if(Camera.x > 0)  {
			if(pressing[LT])   Camera.moveLeft(10);
			if(pressing[LT])    fox.moveLeft(1);
			}
			
			if(Camera.x < 8000) {
			if(pressing[RT])   Camera.moveRight(10);
			if(pressing[RT])    fox.moveRight(1);
			}
			
			//The player will jump and use the current gravity to estimate its physics 
			if(pressing[SPACE]) fox.jump();
			
			
			//If we press Space, the player will be set a velocity and acceleration 
			if (pressing[SPACE])
			{
				fox.setVelocity(0, -5);
				fox.setAccelleration(0, 2);
			}
		       	
						
		    // Responds to Physics
		    fox.move();
						
						
		    // Responses to Collisions
					if(fox.overlaps(r1))
						{
						fox.pushUpFrom(r1);
						}
						repaint();
						
						//Winning Conditions
					       if(fox.overlaps(r3)) {
								int Winner = JOptionPane.showConfirmDialog(null , "Don't go...","All foxes have been spawned",JOptionPane.YES_NO_OPTION);
								if(Winner == JOptionPane.NO_OPTION) {
									System.exit(0);
								} else if(Winner == JOptionPane.YES_OPTION) {
									fox.spawnPoint(0, 730);
								}
							
							}
						
			//try and catch statement to implement our real time system  			
			try
			{
			   Thread.sleep(15);
			}
			catch(Exception x) {};
			
			
		}
		
		
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------//	
	
	public void paint(Graphics pen)
	{
		r1.draw(pen);
		r2.draw(pen);
		r3.draw(pen);
		r4.draw(pen);
		
		sky.draw(pen);
		shadedTrees.draw(pen);
		regularTrees.draw(pen);
		moreTrees.draw(pen);
		evenMoreTrees.draw(pen);
		treeLeaves.draw(pen);
		
		
		
		/*r5.draw(pen);
		r6.draw(pen);
		r7.draw(pen);
		r8.draw(pen);*/
		
		grass.draw(pen);
		
		
		pen.drawImage(moth, 50,  300, this);
		pen.drawImage(moth, 100, 200, this);
		pen.drawImage(moth, 200, 250, this);
		pen.drawImage(moth, 250, 400, this);
		pen.drawImage(moth, 150, 330, this);
		pen.drawImage(moth, 350, 400, this);
		pen.drawImage(moth, 790, 360, this);
		pen.drawImage(moth, 400, 300, this);
		pen.drawImage(moth, 780, 250, this);
		pen.drawImage(moth, 500, 290, this);
		pen.drawImage(moth, 550, 250, this);
		pen.drawImage(moth, 600, 350, this);
		pen.drawImage(moth, 650, 290, this);
		pen.drawImage(moth, 700, 400, this);
		
		if (fox.overlaps(r2)) { 
			pen.drawImage(tower, 1010, 300, this);
			pen.drawImage(blu, 900, 550, this);
			}
		
		if (fox.overlaps(r4)) { 
			pen.drawImage(blast, 790, 500, this);
			}
		
	
		//pen.drawImage(Foxe, 793, 580, this);
		
		darkGrass.draw(pen);
		
		
		fox.draw(pen);
		


		
				
	}

	
	
	//-------------------------------------------------------------------------------------------------------------------//	

	
	public void mouseDragged(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------//	
	
	public void update(Graphics pen)
	{
		offscreen_pen.clearRect(0, 0,  1920, 1080);
		
		paint(offscreen_pen);
		
		pen.drawImage(offscreen_image, 0, 0, null);
	}
	
	//-------------------------------------------------------------------------------------------------------------------//	
	
	//This function will get called when the particular key is pressed 
	public void keyPressed(KeyEvent e)
	{
		pressing[e.getKeyCode()] = true;
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		pressing[e.getKeyCode()] = false;	
		
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------//		

}