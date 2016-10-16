import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by tristenwitt on 10/3/16.
 */
public class Kodac extends JPanel {
    int width;
    int height;
    int x;
    int y;
    BufferedImage imagesslice;
    String problem;
    int firstNum = 0;
    int secondNum = 0;
    boolean isSubtraction = false;
    double answer;
    int state;
    JTextField box = new JTextField();
    JLabel mathProb = new JLabel(this.problem);
    Random r = new Random();
    long startTime;
    long endTime;
    long timeDiff;
    boolean saveTime = true;


    public Kodac(BufferedImage imageslice, int numFam){
        this.imagesslice = imageslice;
        state = 1;
        this.generateProblem(numFam);
        this.box.addKeyListener(new CustomKeyListener());
        //problem = "2 + 2 = ?";
        height = imagesslice.getHeight();
        width = imagesslice.getWidth();


        setSize(width, height);

    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);

        if(state == 1) {
            g2.fillRect(0, 0, width, height);
        }else if(state == 2){
            g2.fillRect(0, 0, width, height);
        }else if(state == 3){
            float[] scales = { 1f, 1f, 1f, 1f };
            float[] offsets = new float[4];
            RescaleOp rop = new RescaleOp(scales, offsets, null);
            g2.drawImage(imagesslice, rop, 0, 0);
        }
    }

    public void changeState(int newState){
        if(newState == 2 && state != 1){
            return;
        }
        if(newState == 3 && state == 2){
            remove(mathProb);
            remove(box);
            if(saveTime) {
                endTime = System.currentTimeMillis();
                timeDiff = endTime - startTime;
                Framer.times.add(timeDiff);
                Framer.setAvgTimeLabel();
            }
        }

        state = newState;
        if(state == 2){
            mathProb.setText(this.problem);
            mathProb.setHorizontalAlignment(2);
            box.setColumns(2);
            add(mathProb);
            add(box);
            startTime = System.currentTimeMillis();
        }
        repaint();
    }

    public void checkAnswer(int newAnswer){
        if(answer == newAnswer){
            changeState(3);
        }else {
            JOptionPane.showMessageDialog(null, "The answer is the same as: " + (int)(this.answer-2) + " + 2", "Hint!", JOptionPane.INFORMATION_MESSAGE);
            saveTime = false;
        }
    }

    public void generateProblem(int firstChoice){
        this.firstNum = firstChoice;
        this.secondNum = r.nextInt(13);
        int isMinus = r.nextInt(2);
        if(isMinus == 0){
            this.isSubtraction = false;
            problem = firstNum + " + " + secondNum + " = ?";
            answer = firstNum + secondNum;
        }else if(isMinus == 1){
            this.isSubtraction = true;
            problem = firstNum + " - " + secondNum + " = ?";
            answer = firstNum - secondNum;
        }
    }

}
