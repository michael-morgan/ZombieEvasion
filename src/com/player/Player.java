package com.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Player class
 * @author nerdysweat
 */
public class Player
{
	private int playerX, playerY, health, points;
	
	/**
	 * Player constructor
	 */
	public Player()
	{
		init();
	} //end Player constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		playerX = 448;
		playerY = 288;
		health = 100;
	} //end of init method
	
	/**
	 * getPlayerX method
	 * @return playerX
	 */
	public int getPlayerX()
	{
		return playerX;
	} //end of getPlayerX method
	
	/**
	 * getPlayerY method
	 * @return playerY
	 */
	public int getPlayerY()
	{
		return playerY;
	} //end of getPlayerY method
	
	/**
	 * incrementPlayerX method
	 * @param x
	 */
	public void incrementPlayerX(int x)
	{
		playerX += x;
	} //end of incrementPlayerX method
	
	/**
	 * decrementPlayerX method
	 * @param x
	 */
	public void decrementPlayerX(int x)
	{
		playerX -= x;
	} //end of decrementPlayerX method
	
	/**
	 * incrementPlayerY method
	 * @param y
	 */
	public void incrementPlayerY(int y)
	{
		playerY += y;
	} //end of incrementPlayerY method
	
	/**
	 * decrementPlayerY method
	 * @param y
	 */
	public void decrementPlayerY(int y)
	{
		playerY -= y;
	} //end of decrementPlayerY method
	
	/**
	 * decrementHealth method
	 * @param amount
	 */
	public void decrementHealth(int amount)
	{
		health -= amount;
	} //end of decrementHealth method
	
	/**
	 * incrementHealth method
	 * @param amount
	 */
	public void incrementHealth(int amount)
	{
		health += amount;
	} //end of incrementHealth method
	
	/**
	 * getHealth method
	 * @return health
	 */
	public int getHealth()
	{
		return health;
	} //end of getHealth method
	
	/**
	 * incrementPoints method
	 * @param amount
	 */
	public void incrementPoints(int amount)
	{
		points += amount;
	} //end of incrementPoints method
	
	/**
	 * getPoints method
	 * @return points
	 */
	public int getPoints()
	{
		return points;
	} //end of getPoints method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(playerX, playerY, 32, 32);
	} //end of paint method
	
} //end of Player class
