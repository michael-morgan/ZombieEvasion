package com.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.frame.Screen;

/**
 * Mouse class
 * @author Michael Morgan
 *
 */
public class Mouse extends MouseAdapter
{
	private Screen screen;
	
	/**
	 * Mouse constructor
	 * @param screen
	 */
	public Mouse(Screen screen)
	{
		this.screen = screen;
	} //end of Mouse constructor
	
	/**
	 * mousePressed method
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{	
		if((e.getX() >= 375 && e.getX() <= 587) && (e.getY() >= 175 && e.getY() <= 250))
		{
			if(screen.getMenu())
			{
				screen.startGame();
			}
		}
		if((e.getX() >= 375 && e.getX() <= 587) && (e.getY() >= 288 && e.getY() <= 363))
		{
			if(screen.getMenu())
			{
				JOptionPane.showMessageDialog(screen.getFrame(), "Controls:" +
																"\n S - Toggle sound" +
																"\n Q - Quit" +
																"\n Arrow Keys - Move");
			}
		}
		if((e.getX() >= 375 && e.getX() <= 587) && (e.getY() >= 410 && e.getY() <= 487))
		{
			if(screen.getMenu())
			{
				System.exit(0);
			}
		}
	} //end of mousePressed method
	
} //end of Mouse class
