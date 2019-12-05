package sanforjr2021.tile;

import java.awt.*;
import java.util.ArrayList;

public class Grid {
    private Tile[][] tileArray;
    private Integer x,y;
    private Integer xSpawn, ySpawn, xEnd, yEnd;
    private Tile selectedTile = null;
    public Grid(Integer x, Integer y, Integer xSpawn, Integer ySpawn, Integer xEnd, Integer yEnd) {
        this.x = x;
        this.y = y;
        //todo: Add check to make sure spawn is < End.
        this.xSpawn = xSpawn;
        this.ySpawn = ySpawn;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        tileArray = new Tile[x][y];
        generateGrid();
    }
    public ArrayList<Tower> getTowers(){
        ArrayList<Tower> towers = new ArrayList<Tower>();
        for(int x = 0; x < this.x; x++){
            for(int y = 0; y < this.y; y++){
                if(tileArray[x][y].getName().contains("Tower")){
                    towers.add((Tower) tileArray[x][y]);
                }
            }
        }
        return  towers;
    }

    public void generateGrid(){
        //create basic grid layout
        for(int x = 0; x < this.x; x++){
            for(int y = 0; y < this.y; y++){
                tileArray[x][y] = new Tile(x,y);
            }
        }
        //generate road - currently does an L shape pattern
        for (int x = xSpawn; x < xEnd; x++){
            tileArray[x][yEnd] = new RoadTile(x, yEnd);
        }
        for(int y = ySpawn; y < yEnd; y++){
            tileArray[xSpawn][y] = new RoadTile(xSpawn, y);
        }

        //plot final tiles
        tileArray[xSpawn][ySpawn] = new RoadTile(xSpawn, ySpawn, "spawn");
        tileArray[xEnd][yEnd] = new RoadTile(xEnd, yEnd, "home");
    }

    public Integer getXSpawn() {
        return xSpawn;
    }

    public Integer getYSpawn() {
        return ySpawn;
    }
    public Integer getXEnd() {
        return xEnd;
    }

    public Integer getYEnd() {
        return yEnd;
    }

    public void draw(Graphics2D g2){
        for(int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {
                tileArray[x][y].draw(g2);
                }
            }
        if(selectedTile != null){
            selectedTile.drawAsSelected(g2);
        }
    }

    public Tile getTile(int x, int y){
        return tileArray[x][y];
    }
    public void setSelectedTile(int x, int y){
        selectedTile = tileArray[x][y];
    }
    public Tile getSelectedTile(){
        return selectedTile;
    }
    public void placeTower(int x, int y){
        tileArray[x][y] = new Tower(x,y);
    }
}
