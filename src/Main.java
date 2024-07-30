import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.*;




public class Main {

    public static Robot robot;
    public static Scanner scnr = new Scanner(System.in);

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws AWTException {
    }

    public static void firstAction(String str) {

        String secondStr = "";

        try {
            robot.delay(300);
            switch (str.charAt(str.indexOf('.') + 1)) {
                case 'd':
                    //send a down arrow key outPut
                    //System.out.println("down");

                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);

                    secondStr = str.substring(str.indexOf('n') + 1);
                    break;

                case 'l':
                    //send a left arrow key
                    //System.out.println("left");

                    robot.keyPress(KeyEvent.VK_LEFT);
                    robot.keyRelease(KeyEvent.VK_LEFT);

                    secondStr = str.substring(str.indexOf('t') + 1);
                    break;

                case 'r':
                    //send a right arrow key
                    //System.out.println("right");

                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);

                    secondStr = str.substring(str.indexOf('t') + 1);
                    break;

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

    public static void secondAction (String str ) {

        String thirdStr = "";

        try {
            robot.delay(300);
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

    public static void puzzleSolver(){

        String temp = "";

        temp = scnr.nextLine();


        System.out.println("resting 5 seconds");
        robot.delay(5000);
        firstAction(temp);

        while (scnr.hasNextLine()) {
            temp = scnr.nextLine();
            firstAction(temp);
        }
        temp = scnr.nextLine();

    }


    public static void main(String[] args) {


        //String userInput = JOptionPane.showInputDialog("Please enter a string:");


        int x = 1;
        while (x < 2) {
            puzzleSolver();
        }



    }



}

