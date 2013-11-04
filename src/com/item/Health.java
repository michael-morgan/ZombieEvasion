package com.item;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Health class
 * @author nerdysweat
 */
public class Health
{	
	private int healthX, healthY;
	
	private Random random;
	
	/**
	 * Health constructor
	 */
	public Health()
	{	
		init();
	} //end of Health constructor
	
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
		
		healthX = random.nextInt(30) * 32;
		healthY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(healthX, healthY, 32, 32);
	} //end of paint method
	
	/**
	 * getHealthX method
	 * @return healthX
	 */
	public int getHealthX()
	{
		return healthX;
	} //end of getHealthX method
	
	/**
	 * getHealthY method
	 * @return healthY
	 */
	public int getHealthY()
	{
		return healthY;
	} //end of getHealthY method
	
} //end of Health class