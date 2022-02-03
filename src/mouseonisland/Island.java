package mouseonisland;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Island {

    static int row, col;

    public Island() {}

    public static int[][] importIsland(File islandFile) throws IOException {
        //Scanner importer = new Scanner(new File("/Users/alvintuo/Desktop/apcs/Chapter 8/src/mouseonisland/sampleIsland.txt"));
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

        //DEBUG MODE
        //System.out.println(rows);
        //System.out.println(cols);
        //System.out.println(Arrays.deepToString(island));
        return island;
    }

}
