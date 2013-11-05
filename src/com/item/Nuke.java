package com.item;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Nuke class
 * @author Michael Morgan
 */
public class Nuke
{
	private int nukeX, nukeY;
	
	private Random random;
	
	private Image nuke;
	
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
		
		nuke = new ImageIcon("res/nuke.png").getImage();
		
		nukeX = random.nextInt(30) * 32;
		nukeY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.drawImage(nuke, nukeX, nukeY, null);
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