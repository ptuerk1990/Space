package frontier.pc.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

import frontier.pc.GameObject;

public class Cube extends GameObject
{
	float vertices[] =
	{
		 1,  1, -1,
		 1, -1, -1,
		-1, -1, -1,
		-1,  1, -1,
		 1,  1,  1,
		 1, -1,  1,
		-1, -1,  1,
		-1,  1,  1
	};
	
	FloatBuffer vertBuff;
	
	int[] pIndex = 
	{
		3, 4, 0,
		0, 4, 1,
		3, 0, 1,
		3, 7, 4,
		7, 6, 4,
		7, 3, 6,
		3, 1, 2,
		1, 6, 2,
		6, 3, 2,
		1, 4, 5,
		5, 6, 1,
		6, 5, 4
	};
	
	IntBuffer pBuffer;
	
	public Cube()
	{
		ByteBuffer bBuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);
		
		IntBuffer pbBuff = IntBuffer.allocate(pIndex.length * 2);
		//pbBuff.order(ByteOrder.nativeOrder());
		pbBuff.put(pIndex);
		pbBuff.position(0);
//	
//		pBuffer = IntBuffer.wrap(pIndex);
//		
//		for(int i = 0; i < vertBuff.capacity(); i++)
//		{
		//TODO: FiX !!!!!!!IMEaDIAtLY !!!!!!!
//			pIndex[i] = pBuffer.get(i);
//		}
	}
	
	public synchronized void update()
	{
		yaw += .01f;
		if(yaw >= 360f) yaw = 0;
		if(yaw < 0) yaw     = 360;
		
		pitch += .01f;
		if(pitch >= 360f) pitch = 0;
		if(pitch < 0) pitch     = 360;

		roll += .01f;
		if(roll >= 360f) roll = 0;
		if(roll < 0) roll     = 360;
	}
	
	public synchronized void draw()
	{
		super.draw();
		
		GL11.glColor4f(0, 0.5f, 0.75f, 1);
		
		
		GL11.glFrontFace(GL11.GL_CW);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_FRONT);
		GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY); {
		
			GL11.glVertexPointer(3, GL11.GL_FLOAT, vertBuff);
			// TODO: !!!!!!!!!!WrONg duMBO !!!!!!!!!!
			if(pBuffer != null)
			GL11.glDrawElements(GL11.GL_TRIANGLES, pBuffer);
		
			} GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
			  GL11.glDisable(GL11.GL_CULL_FACE);
		
		super.endDraw();
	}

	public float getX() {return x;}
	public void setX(float x) {this.x = x;}
	public float getY() {return y;}
	public void setY(float y) {this.y = y;}
	public float getZ() {return z;}
	public void setZ(float z) {this.z = z;}
}
