package com.e.contactmanager;

// TODO: Auto-generated Javadoc

import java.util.Scanner;

/**
 * The Class UserInput.
 *
 * @author Sashae
 */
public class UserInput {

    private Logger logger;

    /**
     * @param newLogger
     */
    public UserInput(Logger newLogger) {
        this.logger = newLogger;
    }

    /**
     * Gets the input string.
     *
     * @param scanner the scanner
     * @return the input string
     */
    public String getInputString(Scanner scanner) {

        boolean checker = false;
        String input = null;

        while (true) {
            try {
                checker = true;
                input = scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                checker = false;
                System.out.println("Input not valid!");
                logger.log("Invalid input but user. | " + input + " |");
                scanner.nextLine();
            } finally {
                if(checker) return input;
            }
        }
    }

}

