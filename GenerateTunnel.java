/*
 * Lizette Osorio
 * 08/29/2021
 * Random Tunnel Code Challenge
 */
package randomtunnel;

import java.util.Scanner;

public class GenerateTunnel {

    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);

        boolean valInput = true;

        // create new tunnels until user asks to stop
        while (valInput) {
            System.out.println("Do you want to generate a new tunnel? y/n");
            String response = uInput.nextLine().toUpperCase();

            if (response.equals("Y")) {
                RandomTunnel rTunnel = new RandomTunnel(50, 50);
                rTunnel.printTunnel();
            } else if (response.equals("N")) {
                valInput = false;
            } else {
                System.out.println("Invalid input.");
            }
        }
        uInput.close();

    }
}
