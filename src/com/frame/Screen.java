package com.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.audio.Sound;
import com.enemy.Zombie;
import com.event.Key;
import com.event.Mouse;
import com.item.Health;
import com.item.Nuke;
import com.player.Player;
import com.spawn.HealthSpawn;
import com.spawn.NukeSpawn;
import com.spawn.ZombieSpawn;
import com.time.Time;

/**
 * Screen class
 * @author Michael Morgan
 */
public class Screen extends JPanel implements Runnable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Thread gameLoop;
	private boolean run, menu, game;
	
	private Frame frame;
	
	private Image dbImage;
	private Graphics dbg;
	
	private Image gameLayout, menuLayout;
	
	private Random random;
	public Sound sound;
	
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
		
		this.addKeyListener(new Key(this));
		this.addMouseListener(new Mouse(this));
		
		init();
	} //end of Screen constructor
	
	/**
	 * init method
	 */
	private void init()
	{
		initVariables();
		
		startMenu();
		
		sound.playSound();
		
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
		
		sound = new Sound();
		random = new Random();
		
		menu = true;
		game = false;
	} //end of initVariables method
	
	/**
	 * paint method
	 * @param g
	 */
	@Override
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	} //end of paint method
	
	/**
	 * paintComponent class
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		if(menu)
		{
			g.drawImage(menuLayout, 0, 0, null);
		}
		else if(game)
		{
			g.drawImage(gameLayout, 0, 0, null);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			
			g.drawString("Zombies: ", 110, 645);
			g.drawString("Survived: ", 280, 645);
			g.drawString("Score: ", 460, 645);
			g.drawString("Round: ", 600, 645);
			
			g.drawString("HP: ", 10, 645);
			
			if(player.getHealth() > 75)
			{
				g.setColor(Color.GREEN);
				
				g.drawImage(player.getPlayerFace(0), 800, 620, null);
			}
			else if(player.getHealth() > 50)
			{
				g.setColor(Color.YELLOW);
				
				g.drawImage(player.getPlayerFace(1), 800, 620, null);
			}
			else if(player.getHealth() > 25)
			{
				g.setColor(Color.ORANGE);
				
				g.drawImage(player.getPlayerFace(2), 800, 620, null);
			}
			else
			{
				g.setColor(Color.RED);
				
				g.drawImage(player.getPlayerFace(3), 800, 620, null);
			}
			
			g.drawString("" + player.getHealth(), 55, 645);
			
			g.setColor(Color.GREEN);
			
			g.drawString("" + zombieSpawn.getZombieCount(), 220, 645);
			g.drawString(time.getMinutes() + ":" + time.getSeconds(), 395, 645);
			g.drawString("" + player.getPoints(), 540, 645);
			g.drawString("" + player.getRound(), 690, 645);
			
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
		}
	} //end of paintComponent method
	
	/**
	 * startGame method
	 */
	public void startGame()
	{	
		gameLayout = new ImageIcon("res/layout.png").getImage();
		
		player = new Player();
		time = new Time(this);
		zombie = new ArrayList<>();
		health = new ArrayList<>();
		nuke = new ArrayList<>();
		zombieSpawn = new ZombieSpawn(this);
		healthSpawn = new HealthSpawn(this);
		nukeSpawn = new NukeSpawn(this);
		
		menuLayout = null;
		
		menu = false;
		game = true;
	} //end of startGame method
	
	/**
	 * startMenu method
	 */
	public void startMenu()
	{	
		menuLayout = new ImageIcon("res/menu.png").getImage();
		
		if(game)
		{
			time.stop();
			zombieSpawn.stop();
			healthSpawn.stop();
			nukeSpawn.stop();
			gameLayout = null;
			player = null;
			time = null;
			zombie = null;
			health = null;
			nuke = null;
			zombieSpawn = null;
			healthSpawn = null;
			nukeSpawn = null;
		}
		
		game = false;
		menu = true;
	} //end of startMenu method
	
	/**
	 * getGame method
	 * @return game
	 */
	public boolean getGame()
	{
		return game;
	} //end of getGame method
	
	/**
	 * getMenu method
	 * @return menu
	 */
	public boolean getMenu()
	{
		return menu;
	} //end of getMenu method
	
	/**
	 * getFrame method
	 * @return frame
	 */
	public Frame getFrame()
	{
		return frame;
	} //end of getFrame method
	
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
			if(player.getHealth() > 0)
			{
				player.decrementHealth(1);
			}
		}
		
		if(heal())
		{
			if(player.getHealth() <= 90)
			{
				player.incrementHealth(5 + random.nextInt(5));
			}
			else
			{
				player.setHealth(100);
			}
		}
		
		if(terminate())
		{
			for(int i = 0; i < zombie.size(); i++)
			{
				zombie.remove(i);
				zombieSpawn.decrementCount(1);
			}
		}
		
		if(player.getHealth() <= 0)
		{
			repaint();
			JOptionPane.showMessageDialog(frame, "Oh dear, the zombies found your flesh.");
			startMenu();
		}
		
	} //end of process method
	
	/**
	 * run method
	 */
	@SuppressWarnings("static-access")
	public void run()
	{
		while(run)
		{
			if(game)
			{
				process();
			}
			
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
