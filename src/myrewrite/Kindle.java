package myrewrite;

import java.util.ArrayList;
import java.util.List;

public class Kindle {
    private List<Book> books;
    private EBookReaderFactory readerFactory;

    public Kindle() {
        this.books = new ArrayList<Book>();
        this.readerFactory = new EBookReaderFactory();
    }
    public String readBook(Book b){
        var reader= readerFactory.createReader(b);
        return reader.readBook();
    }

    public void uBook(Book b){
        books.add(b);
    }
    public void doBook(Book b){
        books.add(b);
    }
    public void deBook(Book b){
        books.remove(b);
    }

}

class Test {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        var k= new Kindle();
//        var pdf = new Format()
        var b = new Book(Format.PDF);
        System.out.println(k.readBook(b));

//        System.out.println(t.show());


    }
}

abstract class EBookReader{
    public EBookReader(Book book) {
        this.book = book;
    }

    protected Book book;

    public abstract String readBook();
    public abstract String displayReaderType();

}

class EpubReader extends EBookReader{
    public EpubReader(Book b) {
        super(b);
    }

    public String displayReaderType(){
        return "type is:"+ book.getFormat();
    }
    public String readBook(){

        return "content is " +book.getFormat().getContent();
    }

}

class PdfReader extends EBookReader{
    public PdfReader(Book b) {
        super(b);
    }

    public String displayReaderType(){
        return "type is:"+ book.getFormat();
    }
    public String readBook(){

        return "content is " +book.getFormat().getContent();
    }

}

class EBookReaderFactory{


    public EBookReader createReader(Book book){
        if(book.getFormat() == Format.EPUB){
            return new EpubReader(book);
        }else if(book.getFormat() == Format.PDF){
            return new PdfReader((book));
        }else{
            return null;
        }

    }

}


class Book{
    public Format getFormat() {
        return format;
    }

    public Book(Format format) {
        this.format = format;
    }

    private Format format;

}

enum Format {
    EPUB("epub"), PDF("pdf"), MOBI("mobi");

    private String content;

    Format(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
