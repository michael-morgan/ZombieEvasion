package com.frame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Frame class
 * @author Michael Morgan
 *
 */
public class Frame extends JFrame
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 30, HEIGHT = 20;
	private Dimension size = new Dimension(32 * WIDTH + 5, (32 * HEIGHT - 3) + 57);
	
	/**
	 * Frame constructor
	 */
	public Frame()
	{
		this.setTitle("Zombie Evasion! || By Michael Morgan");
		this.setSize(size);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Screen screen = new Screen(this);
		screen.setFocusable(true);
		this.add(screen);
		
		this.setVisible(true);
	} //end of Frame constructor
	
} //end of Frame class