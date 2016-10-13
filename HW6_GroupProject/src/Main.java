import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class Main extends JFrame 
{
	JMenuBar menuBar;
	
	public Main() throws IOException
	{
		setup_menuBar();
		add(menuBar);
		
		MenuPanel mp = new MenuPanel();
		add(mp);
		
		setSize(new Dimension(600, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		setVisible(true);
	}
	
	public void setup_menuBar()
	{
		menuBar = new JMenuBar();
		
		// Code to setup JMenuBar on JFrame here
	}
	
	public static void main(String[] args) throws IOException
	{		
		new Main();
	}
}