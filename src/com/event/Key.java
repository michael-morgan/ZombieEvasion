package com.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.frame.Screen;

/**
 * KeyHandler class
 * @author nerdysweat
 */
public class Key extends KeyAdapter
{
	private Screen screen;
	
	public Key(Screen screen)
	{
		this.screen = screen;
	}

	/**
	 * keyPressed method
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == e.VK_UP)
		{
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
