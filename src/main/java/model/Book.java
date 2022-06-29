package model;

public class Book {
    // Title
    private String title;
    // Genre
    private String genre;
    // Number of pages
    private Integer numberOfPages;

    public Book(String title, String genre, Integer numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public String toString() {
        return "Book [genre=" + genre + ", numberOfPages=" + numberOfPages + ", title=" + title + "]";
    }

}