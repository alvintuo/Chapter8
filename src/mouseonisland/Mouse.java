package mouseonisland;
import java.io.File;
import java.io.IOException;

import static mouseonisland.Island.myIsland;

public class Mouse {

    int moves;
    static int x, y;

    int[][] island;

    public Mouse() throws IOException {
        generateIsland();
        spawnMouse();
    }

    public void generateIsland() throws IOException {
        File islandMap = new File("/Users/alvintuo/Desktop/apcs/Chapter 8/src/mouseonisland/testIsland.txt");
        // Below is the code to switch to file reader
        island = Island.importIsland(islandMap);
        // Below is the code to switch to the default map
        // island = Island.myIsland;
    }

    public void spawnMouse() {
        moves = 100;
        generateRandomCoordinate();
        while (myIsland[x][y] == 0 || myIsland[x][y] == 2) {generateRandomCoordinate();}

    }

    public void generateRandomCoordinate(){
        x = (int)(Math.random() * ((Island.col - 0) + 1)); // creates random int [0, row] for x-coordinate
        y = (int)(Math.random() * ((Island.row - 0) + 1)); // creates random int [0, col] for y-coordinate

    }

    /*
    public boolean isAlive() {
        if (island[x][y] == 0) {return false;}
        if (moves > 0) {return false;}
        else {
            return true;
        }
    }
    */

    public int inquireStatus() {
        if (moves == 0) {return 2;}
        if (island[x][y] == 0) {return 0;}
        // if (myIsland[x][y] == 1) {return 100;}
        if (island[x][y] == 2) {return 10;}
        return 1;

    }

    public void move(){
        if (moves != 0) {
            moves--;
            int moveDirection = 1 + (int) (Math.random() * ((4 - 1) + 1)); // creates random int [1, 4]
            if (moveDirection == 1) {
                x++;
            } // moves up on 1
            if (moveDirection == 2) {
                x--;
            } // moves down on 2
            if (moveDirection == 3) {
                y++;
            } // moves right on 3
            if (moveDirection == 4) {
                y--;
            } // moves left on 4
        }
    }
}
