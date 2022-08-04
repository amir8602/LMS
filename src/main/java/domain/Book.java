package domain;

public class Book {

    private Long id;
    private String name;
    private String author;
    private Status status;


    public enum Status {
        BORROWED
        , RETURNED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Book() {
    }

    public Book(String name, String author, Status status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public Book(Long id, String name, String author, Status status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
