package com.item;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Health class
 * @author Michael Morgan
 */
public class Health
{	
	private int healthX, healthY;
	
	private Random random;
	
	private Image health;
	
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
		
		health = new ImageIcon("res/health.png").getImage();
		
		healthX = random.nextInt(30) * 32;
		healthY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.drawImage(health, healthX, healthY, null);
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