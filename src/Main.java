import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;




public class Main {

    public static Robot robot;
    public static Scanner scnr;

    static {                      //creating robot in order to press keystrokes for user
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws AWTException {
    }

    public static void firstAction(String str) {         //solves first action given the string of solutions
        //used a first and second action method because it was easier than
        //parsing through the string
        String secondStr = "";

        try {
            robot.delay(360);
            switch (str.charAt(str.indexOf('.') + 1)) {
                //if the next word in the string starts with d it recognizes it as down
                //and then makes sure to send the next string based on the substring after the n in down
                case 'd':
                    //send a down arrow key outPut
                    //System.out.println("down");

                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);

                    secondStr = str.substring(str.indexOf('n') + 1);
                    break;

                //if the next word in the string starts with l it recognizes it as left
                //and then makes sure to send the next string based on the substring after the t in leftt
                case 'l':
                    //send a left arrow key
                    //System.out.println("left");

                    robot.keyPress(KeyEvent.VK_LEFT);
                    robot.keyRelease(KeyEvent.VK_LEFT);

                    secondStr = str.substring(str.indexOf('t') + 1);
                    break;

                //if the next word in the string starts with r it recognizes it as right
                //and then makes sure to send the next string based on the substring after the t in right
                case 'r':
                    //send a right arrow key
                    //System.out.println("right");

                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);

                    secondStr = str.substring(str.indexOf('t') + 1);
                    break;

                //if the next word in the string starts with u it recognizes it as up
                //and then makes sure to send the next string based on the substring after the p in up
                case 'u':
                    //send an up arrow key
                    //System.out.println("up");

                    robot.keyPress(KeyEvent.VK_UP);
                    robot.keyRelease(KeyEvent.VK_UP);


                    secondStr = str.substring(str.indexOf('p') + 1);
                    break;
            }

            if (!secondStr.isEmpty()) {
                secondAction(secondStr);
            }

        }

        catch (Exception e) {
            System.out.println("something went wrong");
        }

    }

    public static void secondAction (String str ) {         //second action performs the same as first action
        //was easier to make the program work separating them

        String thirdStr = "";

        try {
            robot.delay(360);
            switch (str.charAt(0)) {
                case 'd':
                    //send a down arrow key outPut
                    //System.out.println("down");

                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    thirdStr = str.substring(str.indexOf('n') + 1);
                    break;

                case 'l':
                    //send a left arrow key
                    //System.out.println("left");

                    robot.keyPress(KeyEvent.VK_LEFT);
                    robot.keyRelease(KeyEvent.VK_LEFT);
                    thirdStr = str.substring(str.indexOf('t') + 1);
                    break;

                case 'r':
                    //send a right arrow key
                    //System.out.println("right");

                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);
                    thirdStr = str.substring(str.indexOf('t') + 1);
                    break;

                case 'u':
                    //send an up arrow key
                    //System.out.println("up");
                    robot.keyPress(KeyEvent.VK_UP);
                    robot.keyRelease(KeyEvent.VK_UP);

                    thirdStr = str.substring(str.indexOf('p') + 1);
                    break;
            }

            if (!thirdStr.isBlank()) {
                secondAction(thirdStr);
            }

        }

        catch(Exception e) {
            System.out.println("something went wrong");
        }

    }

    public static void puzzleSolver(String inputStr){      //calls the solver methods into action with the user given string



        scnr = new Scanner(inputStr);
        String temp = "";

        while (scnr.hasNext()) {
            temp = scnr.next();
            firstAction(temp);
        }


    }






    public static void main(String[] args) {

        String userInput = JOptionPane.showInputDialog("Enter Puzzle directions, or stop to exit:");            //provides a pane to enter your text in to avoid needing


        //access to the console
        //this window also keeps priority over other windows
        //so you do not have to find it hiding behind other tabs

        int x = 1;
        while (!userInput.equalsIgnoreCase("stop")) {                //allows the solver to run infinitely or until users X's out or types stop

            System.out.println("Waiting 5 seconds to begin");
            robot.delay(5000);
            puzzleSolver(userInput);

            userInput = JOptionPane.showInputDialog("Enter Puzzle directions, or stop to exit:");

        }



    }



}
