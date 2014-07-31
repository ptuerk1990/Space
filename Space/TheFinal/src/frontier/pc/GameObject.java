package frontier.pc;

import org.lwjgl.opengl.GL11;

public class GameObject 
{
	protected float x;
	protected float y;
	protected float z;
	protected float dx;
	protected float dy;
	protected float dz;
	
	protected float roll;
	protected float pitch;
	protected float yaw;
	
	public void draw()
	{
		GL11.glTranslatef(x,  y ,  z);
		GL11.glRotatef(pitch, 1, 0, 0);
		GL11.glRotatef(yaw, 0, 1, 0);
		GL11.glRotatef(roll, 0, 0, 1);
	}
	
	public void endDraw()
	{
		GL11.glRotatef(-roll, 0, 0, 1);
		GL11.glRotatef(-yaw, 0, 1, 0);
		GL11.glRotatef(-pitch, 1, 0, 0);
		GL11.glTranslatef(-x,  -y ,  -z);
	}
}
