package com.item;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Nuke class
 * @author nerdysweat
 */
public class Nuke
{
	private int nukeX, nukeY;
	
	private Random random;
	
	/**
	 * Nuke constructor
	 */
	public Nuke()
	{
		init();
	} //end of Nuke constructor
	
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
		
		nukeX = random.nextInt(30) * 32;
		nukeY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(nukeX, nukeY, 32, 32);
	} //end of paint method
	
	/**
	 * getNukeX method
	 * @return nukeX
	 */
	public int getNukeX()
	{
		return nukeX;
	} //end of getNukeX method
	
	/**
	 * getNukeY method
	 * @return nukeY
	 */
	public int getNukeY()
	{
		return nukeY;
	} //end of getNukeY method
	
} //end of Nuke class