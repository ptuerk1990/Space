package frontier.pc;

import org.lwjgl.util.glu.GLU;

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
		z = - 5;
		dz = .00001f;
	}
	
	public void update()
	{
		yaw += .01f;
		if(yaw >= 360f) yaw = 0;
		if(yaw < 0f) yaw    = 360;
		
		tox = (float)Math.sin(yaw);
		toy = 0;
		toz = (float)Math.cos(yaw);
		
		GLU.gluLookAt(x,  y,  z, x + tox,  y + toy, z + toz, upx, upy, upz);
	}
}
