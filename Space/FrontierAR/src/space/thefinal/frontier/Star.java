package space.thefinal.frontier;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

public class Star 
{
	public static final String TAG = "Star";

	static float range  = 16;
	static float length = 0.5f;
	
	float x, y, z;

	Random random = new Random();
	
	float vertices[];

	FloatBuffer vertexBuffer;	
	
	public Star()
	{
		x = random.nextFloat() * range - range / 2;
		y = random.nextFloat() * range - range / 2;
		z = 0;

		vertices = new float[6];
	}
	
	public void draw(GL10 gl)
	{
		//predraw
		{
			int i = 0;
			vertices[i++] = x;
			vertices[i++] = y;
			vertices[i++] = z;
			
			double angle = Math.atan2(y, x) - Math.atan2(0, 0);
			
			vertices[i++] = x + length * (float)Math.cos(angle);
			vertices[i++] = y + length * (float)Math.sin(angle);
			vertices[i++] = z;
			
			ByteBuffer vbb = ByteBuffer.allocateDirect(6 * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertices);
			vertexBuffer.position(0);
		}
		
		//gl.glTranslatef(x, y, 0);
		//gl.glRotatef(45, 1, 0, 0);
		//gl.glScalef(width, height, 1);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);{
			
			//Log.d(TAG, "Drawing Star");
			gl.glColor4f(1, 1, 1, 1);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
			gl.glDrawArrays(GL10.GL_LINES, 0, 2);
			
			} gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
	
	public static float getLength() {return length;}

	public static void setLength(float length) {Star.length = length;}
}
