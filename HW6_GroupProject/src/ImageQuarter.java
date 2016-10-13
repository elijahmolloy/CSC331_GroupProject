package p4Open_img_save_grids;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Open an image file, create a grid 2 x 2 and 
//save each portion of the grid as an separate image file (makes 4)
//displays the original image and the 4 new image
//to change target image syntax needs to be change

public class ImageQuarter {

	private static BufferedImage img = null;
	private static BufferedImage topLeftImg = null;
	private static BufferedImage topRightImg = null;
	private static BufferedImage botLeftImg = null;
	private static BufferedImage botRightImg = null;

	// Takes image file and split it into four

	// @param none
	// @return none
	// @see original image and image split in four
	private static void ImageReader() {

		try {
			img = ImageIO.read(new File("220px-2006_Quarter_Proof.png"));
			JFrame frame = new JFrame();
			frame.getContentPane().setLayout(new FlowLayout());
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));

			int height = img.getHeight();
			int width = img.getWidth();
			topLeftImg = img.getSubimage(0, 0, (width / 2), (height / 2));
			topRightImg = img.getSubimage((width / 2), 0, (width / 2), (height / 2));
			botLeftImg = img.getSubimage(0, (height / 2), (width / 2), (height / 2));
			botRightImg = img.getSubimage((width / 2), (height / 2), (width / 2), (height / 2));
			frame.getContentPane().add(new JLabel(new ImageIcon(topLeftImg)));
			frame.getContentPane().add(new JLabel(new ImageIcon(topRightImg)));
			frame.getContentPane().add(new JLabel(new ImageIcon(botLeftImg)));
			frame.getContentPane().add(new JLabel(new ImageIcon(botRightImg)));
			frame.pack();
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// makes four image files

	// @param none
	// @return none
	// @see none
	private static void FileMaker() {
		try {
			File f1 = new File("FirstQuarter.png");
			File f2 = new File("SecondQuarter.png");
			File f3 = new File("ThirdQuarter.png");
			File f4 = new File("ForthQuarter.png");
			ImageIO.write(topLeftImg, "PNG", f1);
			ImageIO.write(topRightImg, "PNG", f2);
			ImageIO.write(botLeftImg, "PNG", f3);
			ImageIO.write(botRightImg, "PNG", f4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Main
	public static void main(java.lang.String[] args) {
		ImageReader();
		FileMaker();
	}
}
