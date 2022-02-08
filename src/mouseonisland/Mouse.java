package mouseonisland;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Mouse {

    static int moves;
    static int row, col, x, y;

    static int[][] island;

    public Mouse() throws IOException {
        island = importIsland(new File("/Users/alvintuo/Desktop/apcs/Chapter 8/src/mouseonisland/Island.txt"));
        spawnMouse();
    }

    public static int[][] importIsland(File islandFile) throws IOException {
        Scanner importer = new Scanner(islandFile);
        int rows = importer.nextInt();
        row = rows;
        int cols = importer.nextInt();
        col = cols;
        int [][] island = new int [rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                island[i][j] = Integer.parseInt(importer.next());
            }
        }
        importer.close();
        return island;
    }

    public void spawnMouse() {
        moves = 100;
        generateRandomCoordinate();
        while (island[x][y] == 0 || island[x][y] == 2) {generateRandomCoordinate();}

    }

    public void generateRandomCoordinate(){
        x = (int)(Math.random() * ((row - 1) + 1)); // creates random int [0, row] for x-coordinate
        y = (int)(Math.random() * ((col - 1) + 1)); // creates random int [0, col] for y-coordinate

    }

    public int status() {
        if (moves == 0) {return 2;}                 // 2 = starved
        if (island[x][y] == 0) {return 0;}          // 0 = drowned
        // if (myIsland[x][y] == 1) {return 100;}   // 1 = normal
        if (island[x][y] == 2) {return 10;}         // 10 = escaped
        return -1;                                  // -1 = error mode

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
