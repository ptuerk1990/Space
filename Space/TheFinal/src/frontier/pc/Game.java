package frontier.pc;

public abstract class Game implements Runnable
{
	private static  MySurfaceTest mySurface;
	int width;
	int height;
	
	protected Game(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void init()
	{
		new Thread(this).start();
	}

	public MySurfaceTest getMySurface() 
	{
		if(mySurface == null) mySurface = new MySurfaceTest(width, height);
		return mySurface;
	}
}
