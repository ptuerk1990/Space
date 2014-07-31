import java.util.Random;

import frontier.pc.Camera;
import frontier.pc.Game;
import frontier.pc.objects.Cube;

public class Main extends Game
{
	static Random rand = new Random();
	
	static Camera camera;
	
	static Cube[] myCubes;
	
	boolean running = true;
	
	public static void main(String[] args) 
	{
		camera = new Camera();
		
		myCubes = new Cube[1000];
		for(int i = 0; i < myCubes.length; i++)
		{
			float range = 50;
			myCubes[i] = new Cube();
			myCubes[i].setX(rand.nextFloat() * range - range / 2);
			myCubes[i].setY(rand.nextFloat() * range - range / 2);
			myCubes[i].setZ(rand.nextFloat() * range - range / 2);
		}
		
		new Main(800, 600);
	}
	
	public Main(int width, int height) 
	{
		super(width, height);
		init();
	}

	@Override
	public void run() 
	{		
		while(running)
		{
			if(!getMySurface().update()) running = false;
			
			for(int i = 0; i < myCubes.length; i++)
			{
				myCubes[i].update();
				myCubes[i].draw();
			}
			
			getMySurface().draw();
		}
	}
}
