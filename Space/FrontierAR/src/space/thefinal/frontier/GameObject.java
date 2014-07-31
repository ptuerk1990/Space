package space.thefinal.frontier;

import javax.microedition.khronos.opengles.GL10;

public abstract class GameObject 
{
	float x;
	float y;
	float z;
	float dx;
	float dy;
	float dz;
	
	float roll;
	float pitch;
	float yaw;
	
	public void draw(GL10 gl)
	{	
		gl.glTranslatef(x, y, z);
		gl.glRotatef(pitch, 1, 0, 0);
		gl.glRotatef(yaw, 0, 1, 0);
		gl.glRotatef(roll, 0, 0, 1);
	}
	
	protected void endDraw(GL10 gl)
	{
		gl.glRotatef(-roll, 0, 0, 1);
		gl.glRotatef(-yaw, 0, 1, 0);
		gl.glRotatef(-pitch, 1, 0, 0);
		gl.glTranslatef(-x, -y, -z);
	}
}
