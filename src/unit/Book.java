package unit;

import java.util.Comparator;
import java.util.Objects;

public class Book {
    String name;
    String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
        this.name = " ";
        this.author = " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name = '" + name + '\'' +
                ", author = '" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
    static class BookComparatorName implements Comparator<Book> {

        public int compare(Book b1, Book b2) {

            return b1.name.compareTo(b2.name);
        }

    }

    static class BookComparatorAuthor implements Comparator<Book> {

        public int compare(Book b1, Book b2) {

            return b1.author.compareTo(b2.author);
        }

    }
}

