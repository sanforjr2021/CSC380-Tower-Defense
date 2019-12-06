package sanforjr2021;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameGUI {
    private Integer x, y, width, height, lives, gold;
    private String displayString = "None Selected";
    public GameGUI(Integer x, Integer y, Integer width, Integer height, Integer lives, Integer gold) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lives = lives;
        this.gold = gold;
    }
    public void draw(Graphics2D g2){
        //store transforms for drawing
        AffineTransform originalTransform = g2.getTransform();
        g2.translate(x,y);
        g2.setColor(new Color(0x486A81));
        g2.fillRect(0,0,width,height);
        //Draw Text
        g2.setTransform(new AffineTransform());
        g2.translate(x,y);
        g2.setFont(new Font("impact", 1, 32));
        g2.setColor(Color.red);
        if(lives < 1){
            g2.drawString("Game Over", 10, 32);
        }
        else {
            g2.drawString("Lives: " + lives, 10, 32);
        }
        g2.setColor(Color.ORANGE);
        g2.drawString("Gold: " + gold, 10, 64);
        g2.fillRect(0,68, 500, 3);
        g2.setColor(Color.ORANGE);
        int displayInfoYCord = 100;
        for (String line : displayString.split("\n"))
            g2.drawString(line, 10, displayInfoYCord += g2.getFontMetrics().getHeight());
        //Upgrade Button @ Cords 10, 400, 200, 440
        if(displayString.contains("Tower")){
            g2.setColor(Color.blue);
            g2.fillRect(10,400,190,40);
            g2.setColor(Color.ORANGE);
            g2.drawRect(10,400,190,40);
            g2.drawString("Upgrade", 20, 432);
        }
        g2.setTransform(originalTransform);

    }
    //getters & setters
    public Integer getLives() {
        return lives;
    }

    public void setDisplayString(String name) {
        this.displayString = name;
    }

    public void subtractLives(Integer lives) {
        this.lives -= lives;
    }
    public Integer getGold() {
        return gold;
    }
    public void addGold(Integer gold) {
        this.gold += gold;
    }
    public void subtractGold(Integer gold){
        this.gold-= gold;
    }
}
