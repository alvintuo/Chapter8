package mouseonisland;
import java.io.IOException;
import java.text.DecimalFormat;

public class RunMouse {

    public static void main(String[] args) throws IOException {

        int starved = 0, drowned = 0, escaped = 0;
        double runtimes = 10000.0;

        for (int i = 0; i < runtimes; i++) {
            Mouse mouse = new Mouse();
            while (true) {
                mouse.move();
                if (mouse.inquireStatus() == 10) {
                    // System.out.println("Mouse has escaped!");
                    escaped++;
                    break;
                }
                if (mouse.inquireStatus() == 2) {
                    // System.out.println("Mouse has starved!");
                    starved++;
                    break;
                }
                if (mouse.inquireStatus() == 0) {
                    // System.out.println("Mouse has drowned!");
                    drowned++;
                    break;
                }
            }
        }

        // Cleanup and print code below
        DecimalFormat formatPercentage = new DecimalFormat("#.00");
        System.out.println("Ran the simulation " + (int) runtimes + " times. Below are the results:");
        System.out.println("Escaped: " + escaped + " times, " + (formatPercentage.format((escaped/runtimes)*100)) + "% of the time");
        System.out.println("Starved: " + starved + " times, " + (formatPercentage.format((starved/runtimes)*100)) + "% of the time");
        System.out.println("Drowned: " + drowned + " times, " + (formatPercentage.format((drowned/runtimes)*100)) + "% of the time");


        //DEBUG MODE
        /*
        Mouse mouse = new Mouse();
        mouse.spawnMouse();
        System.out.println(Mouse.x);
        System.out.println(Mouse.y);
        System.out.println(Mouse.island[x][y]);
        System.out.println(mouse.isAlive());
        System.out.println(mouse.inquireStatus());
        System.out.println(mouse.mouseStatusString(mouse));
        */

    }

}
