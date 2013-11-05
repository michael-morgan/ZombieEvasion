package com.time;

import java.util.Random;

import com.frame.Screen;

/**
 * Time class
 * @author Michael Morgan
 */
public class Time implements Runnable
{
	private Thread timeLoop;
	private boolean run;
	
	private Screen screen;
	
	private int minutes, seconds;
	private Random random;
	
	/**
	 * Time constructor
	 */
	public Time(Screen screen)
	{
		this.screen = screen;
		
		init();
	} //end of Time constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
		
		timeLoop.start();
		run = true;
	} //end of initMethod
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		timeLoop = new Thread(this);
		run = false;
		
		minutes = 0;
		seconds = 0;
		random = new Random();
	} //end of initVariables method
	
	/**
	 * process method
	 */
	private void process()
	{
		if(!(seconds >= 59))
		{
			seconds++;
		}
		else
		{
			minutes++;
			seconds = 0;
		}
		
		screen.player.incrementPoints(random.nextInt(3) + 1);
		
		if(screen.player.getPoints() >= 100)
		{
			if(screen.player.getPoints() <= 2500)
			{
				screen.zombieSpawn.setFrequency((screen.player.getPoints() / 100) * 10);
			}
		}
		
		screen.player.setRound((screen.player.getPoints() / 100) + 1);
	} //end of process method
	
	/**
	 * stop method
	 */
	@SuppressWarnings("deprecation")
	public void stop()
	{
		run = false;
		timeLoop.stop();
		timeLoop = null;
	} //end of stop method
	
	/**
	 * run method
	 */
	@SuppressWarnings("static-access")
	public void run()
	{
		while(run)
		{
			process();
			
			try
			{
				timeLoop.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} //end of run method
	
	/**
	 * getMinutes method
	 * @return minutes
	 */
	public int getMinutes()
	{
		return minutes;
	} //end of getMinutes method
	
	/**
	 * getSeconds method
	 * @return seconds
	 */
	public int getSeconds()
	{
		return seconds;
	} //end of getSeconds method
	
	/**
	 * decrementSeconds method
	 * @param amount
	 */
	public void decrementSeconds(int amount)
	{
		seconds -= amount;
	} //end of decrementSeconds method
	
} //end of Time class
