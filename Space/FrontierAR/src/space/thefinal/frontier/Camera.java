package space.thefinal.frontier;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;

public class Camera extends GameObject
{
	float tox;
	float toy;
	float toz;
	float upx = 0;
	float upy = 1;
	float upz = 0;
	
	public Camera() 
	{
		z = -5;
		dz = .0001f;
	}
	
	public void update(GL10 gl)
	{ 
		yaw += .01f;
		if(yaw >= 360f) yaw = 0;
		if(yaw < 0) yaw     = 360;
				
//		x += dz * Math.sin(yaw);
//		z += dz * Math.sin(yaw);
		
		tox = (float)Math.sin(yaw);
		toy = 0;
		toz = (float)Math.cos(yaw);
		
		GLU.gluLookAt(gl, x, y, z, x + tox, y + toy, z + toz, upx, upy, upz);
	}
}
