package com.enemy;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Zombie class
 * @author Michael Morgan
 */
public class Zombie
{
	private int zombieX, zombieY;
	
	private Image zombie;
	
	private Random random;
	
	/**
	 * Zombie constructor
	 */
	public Zombie()
	{
		init();
	} //end of Zombie constructor
	
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
		
		zombie = new ImageIcon("res/zombie.png").getImage();
		
		zombieX = random.nextInt(30) * 32;
		zombieY = random.nextInt(19) * 32;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.drawImage(zombie, zombieX, zombieY, null);
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
