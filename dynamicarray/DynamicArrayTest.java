package eugenius.datastructures.dynamicarray;

//public class DynamicArrayTest {
//    public static void main(String[] args) {
//        // Create a DynamicArray instance
//        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
//
//        // Add elements to the dynamic array
//        dynamicArray.add(10);
//        dynamicArray.add(20);
//        dynamicArray.add(30);
//
//        // Display the array
//        System.out.println("DynamicArray contents: " + dynamicArray);
//
//        // Remove an element
//        dynamicArray.removeAt(1);
//        System.out.println("After removing index 1: " + dynamicArray);
//
//        // Check if an element exists
//        System.out.println("Contains 20? " + dynamicArray.contains(20));
//        System.out.println("Contains 10? " + dynamicArray.contains(10));
//    }
//}

import java.util.Scanner;

public class DynamicArrayTest {
    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Create a DynamicArray instance for integers
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        // Menu-driven program
        while (true) {
            System.out.println("\nDynamic Array Operations:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element by index");
            System.out.println("3. Check if an element exists");
            System.out.println("4. Display the array");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt(); // Read the user's choice

            switch (choice) {
                case 1: // Add an element
                    System.out.print("Enter an element to add: ");
                    int elementToAdd = scanner.nextInt();
                    dynamicArray.add(elementToAdd);
                    System.out.println("Added " + elementToAdd + " to the dynamic array.");
                    break;

                case 2: // Remove an element by index
                    System.out.print("Enter the index to remove: ");
                    int indexToRemove = scanner.nextInt();
                    try {
                        int removedElement = dynamicArray.removeAt(indexToRemove);
                        System.out.println("Removed element: " + removedElement);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;

                case 3: // Check if an element exists
                    System.out.print("Enter an element to check: ");
                    int elementToCheck = scanner.nextInt();
                    if (dynamicArray.contains(elementToCheck)) {
                        System.out.println("The element " + elementToCheck + " exists in the dynamic array.");
                    } else {
                        System.out.println("The element " + elementToCheck + " does not exist in the dynamic array.");
                    }
                    break;

                case 4: // Display the array
                    System.out.println("DynamicArray contents: " + dynamicArray);
                    break;

                case 5: // Exit the program
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close(); // Close the scanner
                    return;

                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}