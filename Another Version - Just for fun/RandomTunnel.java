/*
 * Lizette Osorio
 * 08/29/2021
 * Random Tunnel Code Challenge
 */
package randomtunnel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomTunnel {

    private int maxHeight;
    private int maxWidth;
    private int currHeight;
    private int currWidth;
    private boolean[][] clearPath;

    public RandomTunnel(int height, int width) {
        maxHeight = height;
        maxWidth = width;

        Random randEntrance = new Random(); //random entrance on first row
        currWidth = randEntrance.nextInt(maxWidth - 1);
        currHeight = 0;

        clearPath = new boolean[maxHeight][maxWidth];
        resetMap();
        makePath();
    }

    private void resetMap(){
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                clearPath[i][j]=false;
            }
        }
    }

    private void makePath() {
        clearPath[currHeight][currWidth] = true; //entrance opening
        boolean bottomReached = false;
        Random rand = new Random();

        while (!bottomReached) {
            ArrayList<String> travelBounds = new ArrayList<String>(Arrays.asList("N", "S", "E", "W"));


            //set map boundaries
            if (currHeight == 0 || clearPath[currHeight-1][currWidth]) {
                travelBounds.remove("N");
            } 
            if (currHeight == maxHeight - 1 || clearPath[currHeight+1][currWidth]) {
                travelBounds.remove("S");
            } 
            if (currWidth == 0 || clearPath[currHeight][currWidth-1]) {
                travelBounds.remove("E");
            }
            if (currWidth == maxWidth - 1 || clearPath[currHeight][currWidth+1]) {
                travelBounds.remove("W");
            }

            //move one square
            if(travelBounds.size()==0){
                travelBounds.add("S");
            }

            int dirTravel = rand.nextInt(travelBounds.size());
            if (travelBounds.get(dirTravel) == "N") {
                currHeight = currHeight - 1;
            } else if (travelBounds.get(dirTravel) == "S") {
                currHeight = currHeight + 1;
            } else if (travelBounds.get(dirTravel) == "E") {
                currWidth = currWidth - 1;
            } else if (travelBounds.get(dirTravel) == "W") {
                currWidth = currWidth + 1;
            }

            clearPath[currHeight][currWidth] = true; //mark opening

            if (currHeight == maxHeight - 1) { //last row reached
                bottomReached = true;
            }

        }
    }

    public void printTunnel() {
        System.out.println("-".repeat(maxWidth + 2));
        for (int i = 0; i < maxHeight; i++) {
            System.out.print("|");
            for (int j = 0; j < maxWidth; j++) {
                if (clearPath[i][j]) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(maxWidth + 2));
    }

    public int getHeight() {
        return maxHeight;
    }

    public int getWidth() {
        return maxWidth;
    }

}
