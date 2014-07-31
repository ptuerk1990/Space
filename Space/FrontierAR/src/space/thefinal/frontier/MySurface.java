package space.thefinal.frontier;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import space.thefinal.frontier.TimedEvent.AlertReciever;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.Window;
import android.view.WindowManager;

public class MySurface extends GLSurfaceView implements Renderer, AlertReciever, Runnable
{
	public static final String TAG = "MySurface";
	
	Random rand = new Random();
	Main main;
	
	TimedEvent drawTimer;
	boolean draw = true;
	
	Camera camera;
	
	Cube[] myCubes;
	
	public MySurface(Context context) 
	{
		super(context);
		main = (Main)context;
		
		this.main.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.main.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.setRenderer(this);
		this.main.setContentView(this);
	}
	
	@Override
	public void onPause() 
	{
		super.onPause();
	}
	
	public void init()
	{
		//drawTimer = new TimedEvent(this, 20/1000, true);
		camera = new Camera();
		
		myCubes = new Cube[100];
		for(int i = 0; i < myCubes.length; i++)
		{
			float range = 50;
			myCubes[i] = new Cube();
			myCubes[i].setX(rand.nextFloat() * range - range / 2);
			myCubes[i].setY(rand.nextFloat() * range - range / 2);
			myCubes[i].setZ(rand.nextFloat() * range - range / 2);
		}
		
		new Thread(this).start();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) 
	{
		gl.glClearColor(0,  0,  0, 1);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) 
	{	
		if(height == 0) height = 1;
		
		gl.glViewport(0, 0, width, height);
		float ratio = ((float)width) / ((float)height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 250);
	}

	@Override
	public void onDrawFrame(GL10 gl) 
	{	
		//if(draw)
		{
			draw = false;
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			gl.glLoadIdentity();
			
			camera.update(gl);
			
			for(int i = 0; i < myCubes.length; i++)
			{
				myCubes[i].draw(gl);
			}		
		}
	}

	@Override
	public synchronized void alert() 
	{
		draw = true;
	}

	@Override
	public void run() 
	{	
		while(true)
		{
			//if(draw)
			{
				for(int i = 0; i < myCubes.length; i++)
				{
					myCubes[i].update();
				}	
			}
		}
	}
}
