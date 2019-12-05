package sanforjr2021.enemy;

import sanforjr2021.tile.Tile;
import sanforjr2021.tile.Tower;

import java.awt.*;
import java.util.ArrayList;
import static sanforjr2021.Game.RANGEN;

public class EnemyList {
    private Integer xSpawn, ySpawn, xEnd, yEnd;
    private ArrayList<Enemy> enemies;
    public EnemyList(Integer xSpawn, Integer ySpawn, Integer xEnd, Integer yEnd) {
        this.xSpawn = xSpawn*Tile.getWIDTH();
        this.ySpawn = ySpawn*Tile.getHEIGHT();
        this.xEnd = xEnd*Tile.getWIDTH();
        this.yEnd = yEnd*Tile.getHEIGHT();
        enemies = new ArrayList<Enemy>();
    }
    public void generateEnemies(int num, double health){
        for(int i = 0; i < num; i++){
            enemies.add(new Enemy(
                    RANGEN.nextInt(21)-10 + xSpawn + Tile.getWIDTH()/4,
                    RANGEN.nextInt(30)-15 + ySpawn,
                    health));
        }
    }
    public Integer checkForCapture(){
        int damageTaken = 0;
        for(int i = 0; i < enemies.size(); i++){
            if((xEnd < enemies.get(i).getX() && yEnd < enemies.get(i).getY())){
                enemies.remove(i);
                damageTaken++;
            }
        }
        return damageTaken;
    }
    public void moveEnemies(){
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getY() < yEnd + 10){
                enemies.get(i).addY(1);
            }
            else if(enemies.get(i).getX() < xEnd + 10){
                enemies.get(i).addX(1);
            }
        }
    }
    public Integer checkForDeadEnemies(){
        int gold = 0;
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getHealth() <= 0){
                gold += enemies.get(i).getGold();
                enemies.remove(i);
            }
        }
        return gold;
    }
    public void draw(Graphics2D g2){
        for( int i = 0; i < enemies.size(); i++){
            enemies.get(i).draw(g2);
        }
    }
    private Double distanceFormula(Integer x1, Integer y1, Integer x2, Integer y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2))/Tile.getHEIGHT();

    }
    public void createProjectiles(ArrayList<Tower> towers){
        for(int tower = 0; tower < towers.size(); tower++){
            int x1 = towers.get(tower).getCenterX();
            int y1 = towers.get(tower).getCenterY();

            double radius = towers.get(tower).getRadius();
            for(int enemy = 0; enemy < enemies.size(); enemy++){
                int x2 =  enemies.get(enemy).getX();
                int y2 = enemies.get(enemy).getY();
                if(distanceFormula(x1,y1,x2,y2) <= radius){
                    enemies.get(enemy).addProjectile(towers.get(tower).createProjectile());
                    break; //forces only 1 projectile to be shot
                }
            }
        }
    }
    public void moveProjectiles(){
        for(int enemy = 0; enemy < enemies.size(); enemy++){
            enemies.get(enemy).moveProjectiles();
        }
    }

}
