package unit;
import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BookShelf bookList = new BookShelf();

        String inFileName = "input.json";
        String outFileName = "output.json";

        System.out.println("reading input.json");
        bookList.readJSON(inFileName);
        bookList.showAll();
        System.out.println("\n\n");

        System.out.println("recording output.json");
        bookList.writeJSON(outFileName);
        System.out.println("\n\n");

        System.out.println("sorting by name");
        Comparator<Book> compare=new Book.BookComparatorName();
        bookList.sort(compare);
        bookList.showAll();
        System.out.println('\n');

        String name="Pride and Prejudice";
        if(bookList.searchByName(name)!=null) {
            System.out.println("Yes "+name+" "+bookList.searchByName(name));
            System.out.println('\n');
        }
        else{
            System.out.println("there is no book "+name);
            System.out.println('\n');
        }

        System.out.println("sorting by author");
        Comparator<Book> compar=new Book.BookComparatorAuthor();
        bookList.sort(compar);
        bookList.showAll();
        System.out.println('\n');

        System.out.println('\n');
        System.out.println("Shoes by Charlotte Brontë:");
        bookList.authorList("Charlotte Brontë").stream().forEach(System.out::println);

        System.out.println('\n');
        System.out.println("grouped:");
        System.out.println(bookList.group());



    }
}


