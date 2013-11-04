package com.spawn;

import com.frame.Screen;

/**
 * HealthSpawn class
 * @author nerdysweat
 */
public class HealthSpawn implements Runnable
{
	private Thread healthLoop;
	private boolean run;
	
	private Screen screen;
	
	/**
	 * HealthSpawn constructor
	 */
	public HealthSpawn(Screen screen)
	{
		this.screen = screen;
		
		init();
	} //end of HealthSpawn construcor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
		
		healthLoop.start();
		run = true;
	} //end of init method
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		healthLoop = new Thread(this);
		run = false;
	} //end of initVariables method
	
	/**
	 * run method
	 */
	public void run()
	{
		while(run)
		{
			screen.addHealth();
			
			try
			{
				healthLoop.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} //end of run method
	
} //end of HealthSpawn class
