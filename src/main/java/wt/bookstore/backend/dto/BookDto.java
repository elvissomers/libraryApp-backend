package wt.bookstore.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Book} class that is sent to the frontend. The
 * fields in this class contain the information of a book object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class BookDto {

    private long id;

    private long isbn;

    private String title;

    private String author;

    private String description;

    private boolean archived;

    private String language;

    private List<String> keywords;
    

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
