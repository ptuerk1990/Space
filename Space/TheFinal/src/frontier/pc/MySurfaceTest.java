package frontier.pc;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class MySurfaceTest 
{
	int width;
	int height;
	
	Texture tex;
	
	MySurfaceTest(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		try 
		{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setVSyncEnabled(true);
			Display.create();
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		
		width = Display.getDisplayMode().getWidth();
		height = Display.getDisplayMode().getHeight();
		
		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		//GLU.gluPerspective(45.0f, (float)width / (float)height, 0.1f, 500.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
//		GL11.glShadeModel(GL11.GL_SMOOTH);
//		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//		GL11.glClearDepth(1.0f);
//		GL11.glEnable(GL11.GL_DEPTH_TEST);
//		GL11.glDepthFunc(GL11.GL_LEQUAL);
//		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
//		GL11.glEnable(GL11.GL_NORMALIZE);
//		
//		GL11.glEnable(GL11.GL_LIGHTING);
//		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
//		GL11.glEnable(GL11.GL_LIGHT0);
//		
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		try 
		{
			tex = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Resources/back2.png"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public boolean update()
	{
		if(Display.isCloseRequested()) return false;
		return true;
	}
	
	public void draw()
	{
		Display.update();
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
	}
}
