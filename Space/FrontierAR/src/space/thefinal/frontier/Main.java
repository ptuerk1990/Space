package space.thefinal.frontier;

import android.app.Activity;
import android.os.Bundle;

public class Main extends Activity 
{
    public static final String TAG = "Main";

    MySurface game;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        (game = new MySurface(this)).init();
    }
	
	@Override
	protected synchronized void onResume() 
	{
		super.onResume();
		game.onResume();
	}
	
	@Override
	protected synchronized void onPause() 
	{
		super.onPause();
		game.onPause();
	}
}
