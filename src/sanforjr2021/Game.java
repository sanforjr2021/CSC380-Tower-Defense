package sanforjr2021;

import sanforjr2021.enemy.EnemyList;
import sanforjr2021.tile.Grid;
import sanforjr2021.tile.Tile;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.EventListener;
import java.util.Random;

/*
Author: Jacob Sanford
Created Date: 11/21/19
Purpose: Create a tower defense game.
File originally created by Blase Cindric at the University of Mount Union as Lab3x.html for CSC 380 course.
 */
public class Game extends JPanel implements Runnable, MouseListener {
    public static final Random RANGEN = new Random();
    private float pixelSize;
    private Integer desiredWindowWidth = 1500;
    private Integer desiredWindowHeight = 1000;
    private Integer xSpawn, ySpawn, xEnd, yEnd;
    private Grid grid;
    private GameGUI gameGUI;
    private EnemyList enemyList;
    private Double gameDifficulty;

    public Game() {
        setPreferredSize(new Dimension(desiredWindowWidth, desiredWindowHeight));
        setName("Tower Defense -Sanford J.");
        setUp();
        setBackground(Color.BLACK);
        gameGUI = new GameGUI(1000,0,1000,1500,10,50);
        //Setup Mouse Listener
        addMouseListener(this);
        //Remember 24 = 25th square. 0 = 1st square.
        xSpawn = 2; ySpawn =3;
        xEnd = 23; yEnd = 21;
        gameDifficulty = 1.0;
        //Implement containers
        grid = new Grid(25, 25, xSpawn,ySpawn,xEnd,yEnd);
        enemyList = new EnemyList(xSpawn,ySpawn, xEnd, yEnd);
        enemyList.generateEnemies(1,1);
        //start thread to run the game.
        run();

    } // end of constructor

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        //set cords to use world cords for project.
        AffineTransform originalDeviceCoords = g2.getTransform();
        pixelSize = applyWorldToDeviceTransformation(g2, 0, 1500, 0, 1000);
        //Draw list
        grid.draw(g2);
        enemyList.draw(g2);
        gameGUI.draw(g2);
    } // end of paintComponent()
    ///////////////////////////////////////////////////////////////////////////////////////
    //Game Mechanics Calculations
    //////////////////////////////////////////////////////////////////////////////////////
    public void gameCalculations(){
        enemyList.moveEnemies(); // moves enemies
        gameGUI.subtractLives(enemyList.checkForCapture()); //removes enemies and calculates hearts left
        gameGUI.addGold(enemyList.checkForDeadEnemies()); // remove dead enemies and adds gold
    }

    @Override
    public void run() {
        int timer = 0;
        while(true){
            if(gameGUI.getLives() < 1){
                System.out.println("Game Lost");
                repaint();
                return; //kills for loop
            }
            else {
                timer++;
                gameCalculations();
                repaint();
                if (timer % 300 == 0) {
                    gameDifficulty *= 1.0 + (((double)(RANGEN.nextInt(20) + 1)) / 100); //multiplies game difficulty by 1.01 to 1.20 every 15 seconds
                    System.out.println("Game Difficulty Updated: New Difficulty is: " + gameDifficulty);
                }
                if (timer % 50 == 0) {
                    enemyList.generateEnemies(RANGEN.nextInt((int) (1 + gameDifficulty)), (1 * gameDifficulty)); // spawn a new enemy every
                }
                try {
                    Thread.sleep(50); // updates every 1/20 of a second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//////////////////////////////////////////////////////////////
//Mouse Listener
//////////////////////////////////////////////////////////////
    @Override
    public void mouseClicked(MouseEvent e) {
        int xCord = (e.getX() / Tile.getWIDTH());
        int yCord = (Math.abs(e.getY()-this.getHeight()) /Tile.getHEIGHT());
        try{
            grid.setSelectedTile(xCord, yCord);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            //TODO: Put in upgrade options as this selects the GUI
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    ///////////////////////////////////////////////////////////////////////////////////////
    //Methods from Blase Cindric
    //////////////////////////////////////////////////////////////////////////////////////
    private float applyWorldToDeviceTransformation(Graphics2D g2,
            double left, double right, double bottom, double top) {
            return applyWorldToDeviceTransformation(g2, left, right, bottom, top,
                                                 0, getWidth(), 0, getHeight());
    } // end of applyWorldToDeviceTransformation()

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


