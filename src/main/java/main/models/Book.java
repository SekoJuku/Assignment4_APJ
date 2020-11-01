package main.models;

public class Book {
    public int book_id;
    public String book_isbn;
    public String book_name;
    public int book_pages;
    public String book_author;
    public String book_url_image;
    public int book_quantity;

    public Book(int book_id, String book_isbn, String book_name, int book_pages, String book_author, String book_url_image, int book_quantity) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_isbn = book_isbn;
        this.book_pages = book_pages;
        this.book_url_image = book_url_image;
        this.book_quantity = book_quantity;
    }

    public int getId() {
        return book_id;
    }

    public String getIsbn() {
        return book_isbn;
    }

    public String getName() {
        return book_name;
    }

    public int getPages() {
        return book_pages;
    }

    public String getAuthor() {
        return book_author;
    }

    public String getUrl_image() { return book_url_image; }

    public int getQuantity() {
        return book_quantity;
    }
}
