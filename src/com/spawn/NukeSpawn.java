package com.spawn;

import com.frame.Screen;

/**
 * NukeSpawn class
 * @author nerdysweat
 */
public class NukeSpawn implements Runnable
{
	private Thread nukeLoop;
	private boolean run;
	
	private Screen screen;
	
	/**
	 * NukeSpawn constructor
	 */
	public NukeSpawn(Screen screen)
	{
		this.screen = screen;
		
		init();
	} //end of NukeSpawn constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
		
		nukeLoop.start();
		run = true;
	} //end of init method
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		nukeLoop = new Thread(this);
		run = false;
	} //end of initVariables method
	
	/**
	 * run method
	 */
	public void run()
	{
		while(run)
		{
			screen.addNuke();
			
			try
			{
				nukeLoop.sleep(30000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} //end of run method
	
} //end of NukeSpawn class
