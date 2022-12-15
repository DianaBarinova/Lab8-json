package unit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    ArrayList<Book> bookList;

    public BookShelf(ArrayList<Book> shelf) {
        this.bookList = shelf;
    }

    public BookShelf() {
        this.bookList = new ArrayList<Book>();
    }
    public void writeJSON(String jsonFileName) throws IOException {
        FileWriter fr = new FileWriter(jsonFileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jString = objectMapper.writeValueAsString(this.bookList);
        fr.write(jString);
        fr.close();
    }

    public void readJSON(String jsonFileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBookArray = "";
        Scanner sc = new Scanner(new FileReader(jsonFileName));
        while (sc.hasNextLine()){
            jsonBookArray += sc.nextLine();
        }
        List<Book> list = objectMapper.readValue(jsonBookArray, new TypeReference<List<Book>>(){});
        this.bookList = new ArrayList<Book>(list);
    }
    public void showAll(){
        bookList.stream().forEach(System.out::println);
    }

    public void sort(Comparator<Book> compere) {
        bookList.sort(compere);
    }

    public Book searchByName(String name) {

        int firstIndex = 0;
        int lastIndex = bookList.size() - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (name.equals(bookList.get(middleIndex).getName()))
                return bookList.get(middleIndex);
            else if (name.compareTo(bookList.get(middleIndex).getName()) > 0)
                firstIndex = middleIndex + 1;
            else if (name.compareTo(bookList.get(middleIndex).getName()) < 0)
                lastIndex = middleIndex - 1;

        }
        return null;
    }

    public List<Book> authorList(String _a)
    {
        return bookList.stream().filter(author -> _a.equals(author.getAuthor())).collect(Collectors.toList());
    }
    public Map<String, List<Book>> group(){
        Map<String,List<Book>> grouped = new HashMap<>();
        for(Book i : bookList){
            List<Book> tmp = grouped.get(i.getAuthor());
            if(tmp == null)
                tmp = new ArrayList<>();
            tmp.add(i);
            grouped.put(i.getAuthor(),tmp);
        }
        return grouped;
    }

}

