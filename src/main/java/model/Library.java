package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Library {
    private static Map<String, Book> books = new HashMap<>();
    private static Set<String> genres = new HashSet<>();

    private Library() {
    }

    public static void lookupLibraryBook(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n---- Lookup Book ----");
                System.out.print("Lookup by either title or genre (TITLE/genre): ");
                if (scanner.nextLine().equalsIgnoreCase("genre"))
                    lookupGenre(scanner);
                else
                    lookupTitle(scanner);
                System.out.print("\nAre you done looking up books?(Y/n): ");
                Boolean isDone = !scanner.nextLine().equals("n");
                if (isDone)
                    return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void lookupGenre(Scanner scanner) {
        try {
            System.out.println("\n---- Lookup Genre ----");
            System.out.print("Please enter a genre: ");
            String genre = scanner.nextLine();
            if (!Library.genres.contains(genre)) {
                System.out.println("The Library does not contain this genre.");
                return;
            }
            System.out.println(String.format("These book have the genre %s:", genre));

            Library.books.values().stream()
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .forEach(System.out::println);

            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Looks up books based by title.
     * 
     * @param scanner
     */
    public static void lookupTitle(Scanner scanner) {
        try {
            System.out.println("\n---- Lookup Title ----");
            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
            if (!Library.books.containsKey(title))
                System.out.println(String.format("Sorry, we couldn't find the book \"%s\"", title));
            else
                System.out.println(Library.books.get(title));

            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds book(s) from user input to book container
     * 
     * @param scanner
     */
    public static void addLibraryBooks(Scanner scanner) {
        while (true) {
            String title = "", genre = "";
            Integer numberOfPages = 0;
            System.out.println("\n---- Adding Book(s) ----\n");
            try {
                System.out.print("Please enter the title: ");
                title = scanner.nextLine();
                System.out.print("Please enter the genre: ");
                genre = scanner.nextLine();

                if (title.isBlank() || genre.isBlank())
                    throw new Exception("Blank values are invalid. Please try again.");

                System.out.print("Please enter the number of pages: ");
                numberOfPages = scanner.nextInt();
                scanner.nextLine();

                Book book = new Book(title, genre, numberOfPages);
                Library.addBook(title, book);

                System.out.print("Are you done adding books?(Y/n): ");
                Boolean isDone = !scanner.nextLine().equals("n");
                if (isDone)
                    return;
            } catch (Exception e) {
                String errorMessage = e.getMessage() == null ? "\nERROR: Invalid number of pages. Please try again."
                        : "\nERROR:" + e.getMessage();
                System.out.println(errorMessage);
                // scanner.nextLine();
                if (scanner.hasNextLine())
                    scanner.nextLine();
            }
        }
    }

    public static void addBook(String title, Book book) {
        Library.genres.add(book.getGenre());
        Library.books.put(title, book);
    }

    public static void getBook(String title) {
        Library.books.remove(title);
    }

    public static Map<String, Book> getLibrary() {
        return Library.books;
    }

    @Override
    public String toString() {
        return Library.books.toString();
    }

}
