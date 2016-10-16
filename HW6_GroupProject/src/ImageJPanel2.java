import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageJPanel2 extends JPanel
{
	private JLabel problemLabel;
	private TextField answerField;
	
	
	
	private boolean guessed;
	private boolean correct;
	private String mathProblem;
	private int answer;
	private JPanel panel;
	private JButton button;
	private BufferedImage img;
	
	private boolean addNext;
	private int intFamily;
	
	Random random = new Random();
		
	
	public ImageJPanel2(BufferedImage img, int intFamily, String operation)
	{
		setLayout(new GridLayout(1, 2, 2, 2));
		this.intFamily = intFamily;
		
		this.img = img;
		generateProblem(intFamily);		
	}
	
	public void generateProblem(int intFamily)
	{
		boolean addNext;
		addNext = random.nextBoolean();
		
		if (addNext)
		{
			int tempRandom = random.nextInt(13);
			mathProblem = intFamily + " + " + tempRandom;
			answer = intFamily + tempRandom;
		}
		
		else
		{
			int tempRandom = random.nextInt(13);
			mathProblem = intFamily + " - " + tempRandom;
			answer = intFamily - tempRandom;
		}
	}
	
	
	
	
	
	
	public void setAvgTimeLabel()
	{
		long sum = 0;
		for (long time : times)
		{
			
		}
	}

	private void setup_mathProblem(int intFamily, String operation) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		remove
	}
}