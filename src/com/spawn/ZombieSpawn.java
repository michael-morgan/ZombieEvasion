package com.spawn;

import com.frame.Screen;

/**
 * ZombieSpawn class
 * @author Michael Morgan
 */
public class ZombieSpawn implements Runnable
{
	private Thread zombieLoop;
	private boolean run;

	private int amount, frequency;
	
	private Screen screen;

	/**
	 * ZombieSpawn constructor
	 */
	public ZombieSpawn(Screen screen)
	{
		this.screen = screen;

		init();
	} //end of ZombieSpawn construcor

	/**
	 * init method
	 */
	private void init()
	{
		initVariables();

		zombieLoop.start();
		run = true;
	} //end of init method

	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		zombieLoop = new Thread(this);
		run = false;
		
		amount = 0;
		frequency = 0;
	} //end of initVariables method

	/**
	 * clean method
	 */
	private void clean()
	{
		if(screen.zombie.size() > 1)
		{
			for(int i = 0; i < screen.zombie.size(); i++)
			{
				for(int ii = i + 1; ii < screen.zombie.size(); ii++)
				{
					if((screen.zombie.get(i).getZombieX() == screen.zombie.get(ii).getZombieX())
							&& (screen.zombie.get(i).getZombieY() == screen.zombie.get(ii).getZombieY()))
					{
						screen.zombie.remove(i);
						screen.zombieSpawn.decrementCount(1);
					}
				}
			}
		}
	} //end of clean method
	
	/**
	 * stop method
	 */
	@SuppressWarnings("deprecation")
	public void stop()
	{
		run = false;
		zombieLoop.stop();
		zombieLoop = null;
	} //end of stop method

	/**
	 * run method
	 */
	@SuppressWarnings("static-access")
	public void run()
	{
		while(run)
		{
			screen.addZombie();
			clean();

			try
			{
				zombieLoop.sleep(300 - frequency);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} //end of run method
	
	/**
	 * getZombieCount method
	 * @return amount
	 */
	public int getZombieCount()
	{
		return amount;
	} //end of getZombieCount method
	
	/**
	 * incrementCount method
	 */
	public void incrementCount(int amount)
	{
		this.amount += amount;
	} //end of incrementCount method
	
	/**
	 * decrementCount method
	 */
	public void decrementCount(int amount)
	{
		this.amount -= amount;
	} //end of decrementCount method
	
	/**
	 * setFrequency method
	 * @param amount
	 */
	public void setFrequency(int amount)
	{
		frequency = amount;
	} //end of setFrequency method
	
	/**
	 * incrementFrequency method
	 * @param amount
	 */
	public void incrementFrequency(int amount)
	{
		frequency += amount;
	} //end of incrementFrequency method
	
	/**
	 * decrementFrequency method
	 * @param amount
	 */
	public void decrementFrequency(int amount)
	{
		frequency -= amount;
	} //end of decrementFrequency method
	
	/**
	 * getFrequency method
	 * @return frequency
	 */
	public int getFrequency()
	{
		return frequency;
	} //end of getFrequency method
	
} //end of ZombieSpawn class