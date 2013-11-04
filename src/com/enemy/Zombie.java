package com.enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Bug class
 * @author nerdysweat
 */

public class Zombie
{
	private int zombieX, zombieY;
	
	private Random random;
	
	/**
	 * Bug constructor
	 */
	public Zombie()
	{
		init();
	} //end of Bug constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
	} //end of init method
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		random = new Random();
		
		zombieX = random.nextInt(30) * 32;
		zombieY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(zombieX, zombieY, 32, 32);
	} //end of paint method
	
	/**
	 * getZombieX method
	 * @return zombieX
	 */
	public int getZombieX()
	{
		return zombieX;
	} //end of getZombieX method
	
	/**
	 * getZombieY method
	 * @return zombieY
	 */
	public int getZombieY()
	{
		return zombieY;
	} //end of getZombieY method
	
} //end of Zombie class
