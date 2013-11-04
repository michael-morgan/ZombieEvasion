package com.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.enemy.Zombie;
import com.event.Key;
import com.item.Health;
import com.item.Nuke;
import com.player.Player;
import com.spawn.HealthSpawn;
import com.spawn.NukeSpawn;
import com.spawn.ZombieSpawn;
import com.time.Time;

/**
 * Screen class
 * @author nerdysweat
 */

public class Screen extends JPanel implements Runnable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Thread gameLoop;
	private boolean run;
	
	private Frame frame;
	
	private Image dbImage;
	private Graphics dbg;
	
	private Image layout;
	
	public Player player;
	public Time time;
	public ArrayList<Zombie> zombie;
	public ArrayList<Health> health;
	public ArrayList<Nuke> nuke;
	public ZombieSpawn zombieSpawn;
	public HealthSpawn healthSpawn;
	public NukeSpawn nukeSpawn;
	
	
	/**
	 * Screen constructor
	 * @param frame
	 */
	public Screen(Frame frame)
	{
		this.frame = frame;
		
		init();
		
		addKeyListener(new Key(this));
	} //end of Screen constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
		
		gameLoop.start();
		run = true;
	} //end of init method
	
	/**
	 * initVariables method
	 */
	private void initVariables()
	{
		gameLoop = new Thread(this);
		run = false;
		
		layout = new ImageIcon("res/layout.png").getImage();
		
		player = new Player();
		time = new Time(this);
		zombie = new ArrayList<>();
		health = new ArrayList<>();
		nuke = new ArrayList<>();
		zombieSpawn = new ZombieSpawn(this);
		healthSpawn = new HealthSpawn(this);
		nukeSpawn = new NukeSpawn(this);
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	} //end of pain method
	
	/**
	 * paintComponent class
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		g.drawImage(layout, 0, 0, null);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		
		g.drawString("Zombies: ", 110, 645);
		g.drawString("Survived: ", 280, 645);
		g.drawString("Score: ", 460, 645);
		
		g.drawString("HP: ", 10, 645);
		
		if(player.getHealth() > 75)
		{
			g.setColor(Color.GREEN);
			
		}
		else if(player.getHealth() > 50)
		{
			g.setColor(Color.YELLOW);
		}
		else if(player.getHealth() > 25)
		{
			g.setColor(Color.ORANGE);
		}
		
		g.drawString("" + player.getHealth(), 55, 645);
		
		g.setColor(Color.GREEN);
		
		g.drawString("" + zombieSpawn.getZombieCount(), 220, 645);
		g.drawString(time.getMinutes() + ":" + time.getSeconds(), 395, 645);
		g.drawString("" + player.getPoints(), 540, 645);
		
		for(int i = 0; i < zombie.size(); i++)
		{
			zombie.get(i).paint(g);
		}
		
		for(int i = 0; i < health.size(); i++)
		{
			health.get(i).paint(g);
		}
		
		for(int i = 0; i < nuke.size(); i++)
		{
			nuke.get(i).paint(g);
		}
		
		player.paint(g);
	} //end of paintComponent method
	
	/**
	 * addZombie method
	 */
	public void addZombie()
	{
		zombie.add(new Zombie());
		zombieSpawn.incrementCount(1);
	} //end of addZombie method
	
	/**
	 * addHealth method
	 */
	public void addHealth()
	{
		health.add(new Health());
	} //end of addHealth method
	
	/**
	 * addNuke method
	 */
	public void addNuke()
	{
		nuke.add(new Nuke());
	} //end of addNuke method
	
	/**
	 * died method
	 * @return true if dead
	 */
	private boolean hit()
	{
		for(int i = 0; i < zombie.size(); i++)
		{
			if((player.getPlayerX() == zombie.get(i).getZombieX()) && (player.getPlayerY() == zombie.get(i).getZombieY()))
			{
				return true;
			}
		}
		
		return false;
	} //end of died method
	
	/**
	 * heal method
	 * @return true if healed
	 */
	private boolean heal()
	{
		for(int i = 0; i < health.size(); i++)
		{
			if((player.getPlayerX() == health.get(i).getHealthX()) && (player.getPlayerY() == health.get(i).getHealthY()))
			{
				health.remove(i);
				return true;
			}
		}
		
		return false;
	} //end of heal method
	
	/**
	 * terminate method
	 * @return true if nuked
	 */
	private boolean terminate()
	{
		for(int i = 0; i < nuke.size(); i++)
		{
			if((player.getPlayerX() == nuke.get(i).getNukeX()) && (player.getPlayerY() == nuke.get(i).getNukeY()))
			{
				System.out.println("Nuking!");
				nuke.remove(i);
				return true;
			}
		}
		
		return false;
	} //end of terminate method
	
	/**
	 * process method
	 */
	private void process()
	{
		if(hit())
		{
			if(player.getHealth() <= 0)
			{
				run = false;
				JOptionPane.showMessageDialog(frame, "Oh dear, you died!");
				JOptionPane.showConfirmDialog(frame, "Play again?", "Zombie Evasion", JOptionPane.YES_NO_OPTION);
			}
			else
			{
				player.decrementHealth(1);
			}
		}
		
		if(heal())
		{
			if(player.getHealth() <= 95)
			{
				player.incrementHealth(5);
			}
		}
		
		if(terminate())
		{
			for(int i = 0; i < zombie.size(); i++)
			{
				zombie.remove(i);
				zombieSpawn.decrementCount(1);
			}
			
			time.decrementSeconds(20);
		}
		
	} //end of process method
	
	/**
	 * run method
	 */
	public void run()
	{
		while(run)
		{
			process();	
			repaint();
			try
			{
				gameLoop.sleep(20);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} //end of run method
	
} //end of Screen class
