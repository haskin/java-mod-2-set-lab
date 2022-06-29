import java.util.Scanner;

import model.Book;
import model.Library;

public class Main {
    public static void main(String[] args) {
        System.out.println(Library.getLibrary());
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n---- Library System ----");
                System.out.print(
                        "Do you want to add a book or look up an existing book? (Choose add/LOOK): ");
                String userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("add"))
                    Library.addLibraryBooks(scanner);
                else
                    Library.lookupLibraryBook(scanner);

                System.out.print("\nAre you done with the library system? (Y/n): ");
                boolean isDone = !scanner.nextLine().equals("n");
                if (isDone)
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
