package space.thefinal.frontier;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

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
	
	short[] pIndex = 
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
	
	ShortBuffer pBuffer;
	
	public Cube()
	{
		ByteBuffer bBuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);
		
		ByteBuffer pbBuff = ByteBuffer.allocateDirect(pIndex.length * 2);
		pbBuff.order(ByteOrder.nativeOrder());
		pBuffer = pbBuff.asShortBuffer();
		pBuffer.put(pIndex);
		pBuffer.position(0);
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
	
	public synchronized void draw(GL10 gl)
	{
		super.draw(gl);
		
		gl.glColor4f(0, 0.5f, 0.75f, 1);
		
		
		gl.glFrontFace(GL10.GL_CW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_FRONT);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); {
		
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuff);
			gl.glDrawElements(GL10.GL_TRIANGLES, pIndex.length, GL10.GL_UNSIGNED_SHORT, pBuffer);
		
			} gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			  gl.glDisable(GL10.GL_CULL_FACE);
		
		super.endDraw(gl);
	}

	public float getX() {return x;}
	public void setX(float x) {this.x = x;}
	public float getY() {return y;}
	public void setY(float y) {this.y = y;}
	public float getZ() {return z;}
	public void setZ(float z) {this.z = z;}
}
