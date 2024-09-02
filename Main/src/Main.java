//some of the syntax are borrowed from:  Daniel Magdziarz
// interactive calculator for calculating the area and volume of a cylinder 

import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        int menuChoice;
        mainMenu();
        while (!quit) {
            System.out.print("Enter Menu Choice: ");
            boolean hasInteger = keyboard.hasNextInt();
            if (hasInteger) {
                menuChoice = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                String wrongInput = keyboard.nextLine();
                System.out.println("Enter numerical value for menu selection. "
                        .concat("\"" + wrongInput + "\" is a wrong input."));
                continue;
            }
            switch (menuChoice) {
                case 0:
                    quit = true;
                    System.out.println("Bye...");
                    break;
                case 1:
                    mainMenu();
                    break;
                case 2:
                    System.out.printf("Area of the circle is: %,.2f%n", calculateCircle());
                    break;
                case 3:
                    Cylinder cylinder = calculateCylinder();
                    System.out.printf("\nHeight of the cylinder is: %,.2f%n", cylinder.getHeight());
                    System.out.printf("Radius of the cylinder's base is: %,.2f%n", cylinder.getRadius());
                    System.out.printf("Area of the cylinder is: %,.2f%n", cylinder.getArea());
                    System.out.printf("Volume of the cylinder is: %,.2f%n", cylinder.getVolume());
                    break;
                default:
                    System.out.println("Invalid Main Menu selection.");
                    mainMenu();
                    break;
            }
        }
        keyboard.close();
    }

    public static Cylinder calculateCylinder(){
        System.out.println("Enter the radius of the cylinder base (circle).");
        double cylinderBase = inputValidation();
        System.out.println("Enter the height of the cylinder.");
        double cylinderHeight = inputValidation();
        return new Cylinder(cylinderHeight, cylinderBase);
    }

    public static double calculateCircle(){
        System.out.println("Enter the radius of the circle.");
        Circle circle = new Circle(inputValidation());
        return circle.getArea();
    }

    public static double inputValidation() {
        while (true) {
            System.out.print("Enter input: ");
            String userInput = keyboard.nextLine();
            try {
                return Double.parseDouble(userInput);
            } catch (NumberFormatException nfe) {
                System.out.println("\"" + userInput + "\" is an illegal input. Digits only.");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("0 - exit.\n" +
                "1 - Print Main Menu.\n" +
                "2 - Calculate circle area.\n" +
                "3 - Calculate cylinder volume & area.\n");
    }

}
