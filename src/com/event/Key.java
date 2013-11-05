package com.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.frame.Screen;

/**
 * KeyHandler class
 * @author Michael Morgan
 */
public class Key extends KeyAdapter
{
	private Screen screen;
	
	/**
	 * Key constructor
	 * @param screen
	 */
	public Key(Screen screen)
	{
		this.screen = screen;
	} //end of Key constructor

	/**
	 * keyPressed method
	 * @param e
	 */
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == e.VK_Q)
		{
			if(screen.getGame())
			{
				screen.startMenu();
			}
			else if(screen.getMenu())
			{
				System.exit(0);
			}
		}
		if(e.getKeyCode() == e.VK_S)
		{
			if(screen.sound.getSoundOn())
			{
				screen.sound.stopSound();
			}
			else
			{
				screen.sound.playSound();
			}
		}
		if(e.getKeyCode() == e.VK_UP)
		{
			screen.player.resetPlayer();
			screen.player.setUp();
			
			if(screen.player.getPlayerY() <= 0)
			{
				screen.player.decrementPlayerY(0);
			}
			else
			{
				screen.player.decrementPlayerY(32);
			}
		}
		if(e.getKeyCode() == e.VK_DOWN)
		{
			screen.player.resetPlayer();
			screen.player.setDown();
			
			if(screen.player.getPlayerY() >= 576)
			{
				screen.player.decrementPlayerY(0);
			}
			else
			{
				screen.player.incrementPlayerY(32);
			}
		}
		if(e.getKeyCode() == e.VK_LEFT)
		{
			screen.player.resetPlayer();
			screen.player.setLeft();
			
			if(screen.player.getPlayerX() <= 0)
			{
				screen.player.decrementPlayerX(0);
			}
			else
			{
				screen.player.decrementPlayerX(32);
			}
		}
		if(e.getKeyCode() == e.VK_RIGHT)
		{
			screen.player.resetPlayer();
			screen.player.setRight();
			
			if(screen.player.getPlayerX() >= 928)
			{
				screen.player.decrementPlayerX(0);
			}
			else
			{
				screen.player.incrementPlayerX(32);
			}
		}
	} //end of keyPressed method
	
} //end of KeyHandler class
