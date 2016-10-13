import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Class will set up contents of a JPanel to be displayed on a main JFrame.
 * 
 * Contents of MenuPanel will be that of a Menu Page.
 * MenuPanel will be in BorderLayout(). it will give users several options to choose
 * from for the game, and will include a start button to begin the game.
 * 
 * When start is choosen, MenuPanel() will be erased from the main JFrame and a
 * new JPanel will be overwritten. MenuPanel() only serves as a "Menu" for user to select
 * initial options for the game. 
 * 
 * @author Elijah, Tristen, Alexia
 *
 */
public class MenuPanel extends JPanel
{
	public String firstOption;
	public String secondOption;
	public String thirdOption;
	
	// used to get image in image ArrayList.atPosition(imageCount)
	private int imageCount = 0;
	private ArrayList<BufferedImage> images;
	
	private int rows;
	private int columns;
	
	private JLabel photoLabel;
	
	/**
	 * Constructor for MenuPanel()
	 * 
	 * This constructor will have no parameters, and consists of 5 methods.
	 * 
	 * Each method will create one of the 5 sections of the BorderLayout() that 
	 * MenuPanel() consists of.
	 * @throws IOException 
	 */
	public MenuPanel() throws IOException
	{
		// Declares MenuPanel() layout == BorderLayout()
		setLayout(new BorderLayout());
		
		// Methods that set up each section of the BorderLayout()
		setup_imageArray();
		setup_PageStart();
		setup_West();
		setup_Center();
		setup_East();
		setup_PageEnd();
	}
	
	/**
	 * this method will setup the photoArray used to store the photos
	 * that are displayed in the CENTER section of MenuPanel()
	 * @throws IOException 
	 */
	private void setup_imageArray() throws IOException 
	{
		// TODO Auto-generated method stub
		
		images = new ArrayList<BufferedImage>();
		
		BufferedImage one = ImageIO.read(new File("photo_1.jpg"));
		BufferedImage two = ImageIO.read(new File("photo_2.png"));
		BufferedImage three = ImageIO.read(new File("photo_3.jpg"));
		
		images.add(one);
		images.add(two);
		images.add(three);		
	}
	
	/**
	 * this method will setup the PAGE_START section of MenuPanel()
	 */
	public void setup_PageStart()
	{
		// A sub-panel, with a different layout, to be displayed on PAGE_START panel
		// GridLayout(2x3) is desirable formatting for the contents of PAGE_START panel
		JPanel pageStart_subPanel = new JPanel();
		pageStart_subPanel.setLayout(new GridLayout(2, 3, 5, 5));
		
		// Options for the below JComboBoxes
		String[] optionOne = {"Add/Subtract", "Multiply/Divide"};
		String[] optionTwo = {"2x2", "3x3", "4x4"};
		String[] optionThree = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		// JLabels to identify the JComboBoxes by giving them titles
		JLabel labelOne = new JLabel("Operation Type");
		JLabel labelTwo = new JLabel("Size of Board");
		JLabel labelThree = new JLabel("Integer Family");
		
		// The JComboBoxes contain options for the user to select.
		// Selections will be passed to GamePanel() as parameters
		JComboBox boxOne = new JComboBox(optionOne);
		JComboBox boxTwo = new JComboBox(optionTwo);
		JComboBox boxThree = new JComboBox(optionThree);
		
		boxOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox)e.getSource();
				firstOption = (String)combo.getSelectedItem();
				// System.out.println(firstOption);
			}
		});
		
		boxTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox)e.getSource();
				secondOption = (String)combo.getSelectedItem();
				// System.out.println(secondOption);
			}
		});
		
		boxThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox)e.getSource();
				thirdOption = (String)combo.getSelectedItem();
				// System.out.println(thirdOption);
			}
		});
		
		
		// Add JLabels and JComboBoxes to sub-panel
		pageStart_subPanel.add(labelOne);
		pageStart_subPanel.add(labelTwo);
		pageStart_subPanel.add(labelThree);
		pageStart_subPanel.add(boxOne);
		pageStart_subPanel.add(boxTwo);
		pageStart_subPanel.add(boxThree);
		
		// add the sub-panel to PAGE_START panel
		add(pageStart_subPanel, BorderLayout.PAGE_START);
	}
	
	
	
	/**
	 * This method will setup the WEST section of MenuPanel()
	 * 
	 * WEST contains a button that, when pressed, scroll's forward through the class's
	 * ArrayList of images.
	 */
	public void setup_West()
	{
		// JButton is the sole contents of the WEST panel of MenuPanel()
		// The EventHandler will iterate backwards through the ArrayList images
		// and will set JLabel photoLabel to the newly selected image.
		JButton scrollLeft = new JButton(" << Scroll Left");
		scrollLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				// scroll Left through images ArrayList
				imageCount = (imageCount - 1) % 3;
				photoLabel.setIcon(new ImageIcon(images.get(imageCount)));
			}
		});
		
		add(scrollLeft, BorderLayout.WEST);
	}
	
	
	
	/**
	 * This method will setup the CENTER section of MenuPanel()
	 * 
	 * CENTER will only display the currently selected image, as determined
	 * by the class variable "int imageCount".
	 */
	public void setup_Center()
	{
		// posts photoLabel on CENTER section of MenuPanel()
		photoLabel = new JLabel(new ImageIcon(images.get(0)));
		
		add(photoLabel, BorderLayout.CENTER);
	}
	
	
	
	/**
	 * This method will setup the EAST section of MenuPanel()
	 * 
	 * EAST contains a button that, when pressed, scroll's forward through the class's
	 * ArrayList of images.
	 */
	public void setup_East()
	{
		// JButton is the sole contents of the EAST panel of MenuPanel()
		// The EventHandler will iterate forward through the ArrayList images
		// and will set JLabel photoLabel to the newly selected image.
		JButton scrollRight = new JButton("Scroll Right >>");
		scrollRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				// scroll right through images Arraylist
				imageCount = (imageCount + 1) % 3;
				photoLabel.setIcon(new ImageIcon(images.get(imageCount)));
			}
		});
		
		add(scrollRight, BorderLayout.EAST);
	}
	
	
	
	/**
	 * This method will setup the PAGE_END section of MenuPanel()
	 * 
	 * It contains a button that will start the game, using the parameters
	 * as determined by the JComboBox options in PAGE_START, which are determined by the 
	 * user. Ultimately, this JButton will erase the MenuPanel() from the main JFrame and
	 * will replace it with a GamePanel() JFrame, which will be where the game play takes place.
	 */
	public void setup_PageEnd()
	{
		JButton startGame = new JButton("Start Game");
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				startGame();
			}
		});
		
		add(startGame, BorderLayout.PAGE_END);
	}
	
	
	public void startGame()
	{
		if (secondOption.equals("2x2"))
		{
			rows = 2;
			columns = 2;
		}
		
		else if (secondOption.equals("3x3"))
		{
			rows = 3;
			columns = 3;
		}
		
		else if (secondOption.equals("4x4"))
		{
			rows = 4;
			columns = 4;
		}
		
		for (int i = 1; i <= rows; i ++)
		{			
			double heightStart = photoLabel.getHeight() * (i - 1);
			double heightEnd = photoLabel.getHeight() * i;
			
			for (int j = 1; j <= columns; j ++)
			{
				double widthStart = photoLabel.getWidth() * (j - 1);
				double widthEnd = photoLabel.getWidth() * j;
				
				// ImageIcon newImg = photoLabel.getSubImage((int)widthStart, (int)heightStart)
			}
		}
	}
}