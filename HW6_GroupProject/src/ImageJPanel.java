import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ImageJPanel extends JPanel
{
	// state 1 components
	private JButton stateOne;
	
	
	// state 2 components
	private String mathProblem;
	private int answer;
	private JPanel answerPanel;
	private JLabel problemLabel;
	private TextField userAnswerBox;
	private String userAnswer;
	private JButton submitAnswer;
	private JButton hint;
	private Timer timer;
	private JLabel warn;

	// state3 components
	private BufferedImage img;
	JLabel photoLabel;
	 
	Random random = new Random();
	String operation;
		
	
	public ImageJPanel(BufferedImage img, int intFamily, String operation)
	{
		this.img = img;
		this.operation = operation;
		
		stateOne = new JButton();
		stateOne.setBackground(Color.ORANGE);
		stateOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setLayout(new GridLayout(3, 1, 1, 1));
				generateProblem(intFamily);
				
				removeAll();
				setup_box();
				revalidate();
			}
		});
		
		add(stateOne);
	}
	
	
	public void generateProblem(int intFamily)
	{		
		if (operation.equals("+"))
		{
			int tempRandom = random.nextInt(13);
			mathProblem = intFamily + " + " + tempRandom;
			answer = intFamily + tempRandom;
		}
		
		else
		{
			int tempRandom = random.nextInt(13);
			
			if (tempRandom > intFamily)
			{
				mathProblem = tempRandom + " - " + intFamily;
				answer = tempRandom - intFamily;
			}
			
			else
			{
				mathProblem = intFamily + " - " + tempRandom;
				answer = intFamily - tempRandom;
			}
		}
	}
	
	
	private void setup_box()
	{
		answerPanel = new JPanel();
		answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.X_AXIS));
		
		problemLabel = new JLabel(mathProblem + " = ");
		
		userAnswerBox = new TextField();
		userAnswerBox.setEditable(true);
		userAnswerBox.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k)
			{
				int keyCode = k.getKeyCode();
				
				if (keyCode == KeyEvent.VK_ENTER)
				{
					userAnswer = userAnswerBox.getText();
					
					if (userAnswer.equals(answer))
					{						
						// End Timer
						// Erase contents of JPanel and change to img.
						
						removeAll();
						photoLabel = new JLabel(new ImageIcon(img));
						revalidate();						
					}
					
					else
					{
						warn.setText(userAnswer + " is incorrect!");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		answerPanel.add(problemLabel);
		answerPanel.add(userAnswerBox);
		
		warn = new JLabel();
		answerPanel.add(warn);
		
		submitAnswer = new JButton("Submit");
		
		submitAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				userAnswer = userAnswerBox.getText();
				
				if (userAnswer.equals(answer))
				{
					// End Timer 
					// Erase contents of box and replace with img.
					
					removeAll();
					photoLabel = new JLabel(new ImageIcon(img));
					revalidate();
				}
				else
				{
					warn.setText(userAnswer + " is incorrect!");
				}
			}
		});
		
		add(submitAnswer);
		
		hint = new JButton("Hint");
		hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				hint.setText("The anser is " + answer);
			}
		});
		
		add(hint);	
	}
}
