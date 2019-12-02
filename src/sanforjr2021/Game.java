package sanforjr2021;

import sanforjr2021.tile.Grid;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/*
Author: Jacob Sanford
Created Date: 11/21/19
Purpose: Create a tower defense game.
File originally created by Blase Cindric at the University of Mount Union as Lab3x.html for CSC 380 course.
 */
public class Game extends JPanel {
    private float pixelSize;
    private Integer desiredWindowWidth = 1500;
    private Integer desiredWindowHeight = 1000;
    private Integer xSpawn, ySpawn, xEnd, yEnd;
    private Grid grid;
    private GameGUI gameGUI;
    // constructor method from Blase Cindric
    public Game() {
        setPreferredSize(new Dimension(desiredWindowWidth, desiredWindowHeight));
        setName("Tower Defense -Sanford J.");
        setUp();
        setBackground(Color.BLACK);
        //Remember 24 = 25th square. 0 = 1st square.
        xSpawn = 2; ySpawn =3;
        xEnd = 23; yEnd = 21;
        grid = new Grid(25, 25, xSpawn,ySpawn,xEnd,yEnd);
        gameGUI = new GameGUI(1000,0,1000,1500,10,50);
    } // end of constructor
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        //set cords to use world cords for project.
        AffineTransform originalDeviceCoords = g2.getTransform();
        pixelSize = applyWorldToDeviceTransformation(g2, 0, 1500, 0, 1000);
        grid.draw(g2);
        g2.setColor(new Color(0xff0000));
        g2.drawRect(0,0,1000,1000);
        gameGUI.draw(g2);
        System.out.println("Drawing");
    } // end of paintComponent()

    //Method from Blase Cindric
    private float applyWorldToDeviceTransformation(Graphics2D g2,
            double left, double right, double bottom, double top) {
            return applyWorldToDeviceTransformation(g2, left, right, bottom, top,
                                                 0, getWidth(), 0, getHeight());
    } // end of applyWorldToDeviceTransformation()

    //Method from Blase Cindric
    private float applyWorldToDeviceTransformation(Graphics2D g2,
            double left, double right, double bottom, double top, int pxMin,
            int pxMax, int pyMin, int pyMax) {
        int width = pxMax-pxMin;   // The width of this drawing area, in pixels.
        int height = pyMax-pyMin; // The height of this drawing area, in pixels.
        
        g2.setPaint(Color.RED);
        g2.drawRect(pxMin, pyMin, pxMax-pxMin, pyMax-pyMin);
        
        g2.translate(pxMin, pyMin);
        g2.scale( width / (right-left), height / (bottom-top) );
        g2.translate( -left, -top );
        
        double pixelWidth = Math.abs(( right - left ) / width);
        double pixelHeight = Math.abs(( bottom - top ) / height);
        // return pixel size in world coords
        return (float) Math.max(pixelWidth,pixelHeight);
    } // end of applyWorldToDeviceTransformation()
    
    
    /***********************************************
     * Do NOT change or delete anything below here!
     * Method from Blase Cindric
     ***********************************************/
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);    
    }

    public static void main(String args[]){new Game();}

} // end of class LabX3


