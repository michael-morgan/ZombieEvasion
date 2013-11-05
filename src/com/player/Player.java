package com.player;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Player class
 * @author Michael Morgan
 */
public class Player
{
	private int playerX, playerY, health, points, round;
	
	private boolean left, right, up, down;
	
	private Image[] player, face;
	
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
		initVariables();
	} //end of init method
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		playerX = 448;
		playerY = 288;
		health = 100;
		round = 0;
		
		player = new Image[4];
		player[0] = new ImageIcon("res/playerleft.png").getImage();
		player[1] = new ImageIcon("res/playerright.png").getImage();
		player[2] = new ImageIcon("res/playerback.png").getImage();
		player[3] = new ImageIcon("res/playerfront.png").getImage();
		
		face = new Image[4];
		face[0] = new ImageIcon("res/playerface1.png").getImage();
		face[1] = new ImageIcon("res/playerface2.png").getImage();
		face[2] = new ImageIcon("res/playerface3.png").getImage();
		face[3] = new ImageIcon("res/playerface4.png").getImage();
		
		left = false;
		right = false;
		up = false;
		down = true;
	} //end of initVariables method
	
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
	 * setHealth method
	 * @param amount
	 */
	public void setHealth(int amount)
	{
		health = amount;
	} //end of setHealth method
	
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
	 * getPlayerFace method
	 * @param number
	 * @return face[number]
	 */
	public Image getPlayerFace(int number)
	{
		return face[number];
	} //end of getPlayerFace method
	
	/**
	 * setRound method
	 * @param amount
	 */
	public void setRound(int amount)
	{
		round = amount;
	} //end of setRound method
	
	/**
	 * getRound method
	 * @return round
	 */
	public int getRound()
	{
		return round;
	} //end of getRound method
	
	/**
	 * setLeft method
	 */
	public void setLeft()
	{
		left = true;
	} //end of setLeft method
	
	/**
	 * setRight method
	 */
	public void setRight()
	{
		right = true;
	} //end of setRight method
	
	/**
	 * setUp method
	 */
	public void setUp()
	{
		up = true;
	} //end of setUp method
	
	/**
	 * setDown method
	 */
	public void setDown()
	{
		down = true;
	} //end of setDown method
	
	/**
	 * resetPlayer method
	 */
	public void resetPlayer()
	{
		left = false;
		right = false;
		up = false;
		down = false;
	} //end of resetPlayer method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		if(left)
		{
			g.drawImage(player[0], playerX, playerY, null);
		}
		else if(right)
		{
			g.drawImage(player[1], playerX, playerY, null);
		}
		else if(up)
		{
			g.drawImage(player[2], playerX, playerY, null);
		}
		else if(down)
		{
			g.drawImage(player[3], playerX, playerY, null);
		}
	} //end of paint method
	
} //end of Player class
