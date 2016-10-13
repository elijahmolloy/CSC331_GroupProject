import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel
{
	private int firstOption;
	private int rows, columns;
	private int thirdOption;
	
	private int correctGuesses;
	private int totalGuesses;
	
	private ImageIcon image;
	private ArrayList<ImageIcon> splitImages;
	
	
	public GamePanel(ArrayList<ImageJButton> imageList)
	{
		setLayout(new BorderLayout());
		
		setup_PageStart();
		setup_Center();
		setup_PageEnd();
	}

	
	public void setup_PageStart()
	{
		JPanel pageStart_subPanel = new JPanel();
		pageStart_subPanel.setLayout(new GridLayout(2, 3, 5, 5));
		
		JLabel time = new JLabel("Time");
		JLabel numberCorrectGuesses = new JLabel("Number Correct Guesses");
		JLabel numberTotalGuesses = new JLabel("Number Total Guesses");
		
		JLabel showTime = new JLabel();
		JLabel showNumCorrectGuesses = new JLabel();
		JLabel showNumTotalGuesses = new JLabel();
		
		pageStart_subPanel.add(time);
		pageStart_subPanel.add(numberCorrectGuesses);
		pageStart_subPanel.add(numberTotalGuesses);
		pageStart_subPanel.add(showTime);
		pageStart_subPanel.add(showNumCorrectGuesses);
		pageStart_subPanel.add(showNumTotalGuesses);
		
		add(pageStart_subPanel, BorderLayout.PAGE_START);
	}
	
	
	public void setup_Center()
	{		
		// Code that will set up 2x2, 3x3, or 4x4 split picture to display on 
	}
	
	
	public void setup_PageEnd()
	{
		
	}
}
