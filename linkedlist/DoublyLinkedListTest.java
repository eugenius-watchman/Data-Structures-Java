package eugenius.datastructures.linkedlist;

import java.util.Scanner;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        // instance of the DoublyLinkedList to store user inputs.
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice; // variable to store user menu choice.

        // loop to display menu repeatedly until user chooses to exit
        do {
            // menu options.
            System.out.println("\nDoubly Linked List Operations:");
            System.out.println("1. Add to the front");
            System.out.println("2. Add to the end");
            System.out.println("3. Remove from the front");
            System.out.println("4. Remove from the end");
            System.out.println("5. View first item");
            System.out.println("6. View last item");
            System.out.println("7. Check if list is empty");
            System.out.println("8. Clear the list");
            System.out.println("9. Display the list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read user choice.
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character after number input

            // Perform the operation based on the user's choice.
            switch (choice) {
                case 1: // Add an item to the front of the list.
                    System.out.print("Enter the value to add to the front: ");
                    String frontValue = scanner.nextLine(); // read input value
                    list.addFirst(frontValue); // add value to front of list
                    System.out.println("Added \"" + frontValue + "\" to the front.");
                    break;

                case 2: // Add an item to the end of the list
                    System.out.print("Enter the value to add to the end: ");
                    String endValue = scanner.nextLine(); // read input value
                    list.addLast(endValue); // add value to end of list
                    System.out.println("Added \"" + endValue + "\" to the end.");
                    break;

                case 3: // remove item from front of list
                    try {
                        String removedFront = list.removeFirst(); // remove first item
                        System.out.println("Removed \"" + removedFront + "\" from the front.");
                    } catch (RuntimeException e) {
                        System.out.println("The list is empty! Cannot remove.");
                    }
                    break;

                case 4: // remove item from end of list
                    try {
                        String removedEnd = list.removeLast(); // remove last item
                        System.out.println("Removed \"" + removedEnd + "\" from the end.");
                    } catch (RuntimeException e) {
                        System.out.println("The list is empty! Cannot remove.");
                    }
                    break;

                case 5: // view first item in list
                    try {
                        System.out.println("First item: " + list.peekFirst());
                    } catch (RuntimeException e) {
                        System.out.println("The list is empty!");
                    }
                    break;

                case 6: // view last item in list
                    try {
                        System.out.println("Last item: " + list.peekLast());
                    } catch (RuntimeException e) {
                        System.out.println("The list is empty!");
                    }
                    break;

                case 7: // check if list empty.
                    System.out.println("Is the list empty? " + (list.isEmpty() ? "Yes" : "No"));
                    break;

                case 8: // clear all items from list
                    list.clear(); // clear list
                    System.out.println("The list has been cleared.");
                    break;

                case 9: // display all items in the list
                    System.out.println("Current List: " + list);
                    break;

                case 0: // exit program
                    System.out.println("***Exiting... Goodbye!***");
                    break;

                default: // handle invalid menu choices
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0); // repeat until user chooses to exit

        // close scanner to free system resources
        scanner.close();
    }
}