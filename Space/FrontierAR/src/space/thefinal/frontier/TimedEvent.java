//package space.thefinal.frontier;
//
//public class TimedEvent implements Runnable
//{
//	AlertReciever reciever;
//	
//	long start;
//	long trigger;
//	
//	boolean repeat;
//	boolean done = false;
//	
//	public interface AlertReciever
//	{
//		public void alert();
//	}
//	
//	public TimedEvent(AlertReciever receiver, long trigger, boolean repeat) 
//	{
//		this.reciever = receiver;
//		
//		this.trigger = trigger;
//		this.repeat = repeat;
//		
//		this.start = System.currentTimeMillis();
//		
//		new Thread(this).start();
//	}
//
//	@Override
//	public void run() 
//	{
//		while(!done)
//		{
//			if(System.currentTimeMillis() >= start + trigger) 
//			{
//				start = System.currentTimeMillis();
//				
//				reciever.alert();
//				
//				if(!repeat)
//				{
//					done = true;
//				}
//			}
//		}
//	}
//}
