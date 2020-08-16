package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Books {
    private int id;
    private String title;
    private Integer publisherid;
    private String isbn;
    private Integer categoryid;
    private Double fine;
    private Collection<AuthorBook> authorBooksById;
    private Publishers publishersByPublisherid;
    private Categories categoriesByCategoryid;
    private Collection<BookItems> bookItemsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    @Basic
    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "CATEGORYID")
    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "FINE")
    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return id == books.id &&
                Objects.equals(title, books.title) &&
                Objects.equals(publisherid, books.publisherid) &&
                Objects.equals(isbn, books.isbn) &&
                Objects.equals(categoryid, books.categoryid) &&
                Objects.equals(fine, books.fine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publisherid, isbn, categoryid, fine);
    }

    @OneToMany(mappedBy = "booksByIdbook")
    public Collection<AuthorBook> getAuthorBooksById() {
        return authorBooksById;
    }

    public void setAuthorBooksById(Collection<AuthorBook> authorBooksById) {
        this.authorBooksById = authorBooksById;
    }

    @ManyToOne
    @JoinColumn(name = "PUBLISHERID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Publishers getPublishersByPublisherid() {
        return publishersByPublisherid;
    }

    public void setPublishersByPublisherid(Publishers publishersByPublisherid) {
        this.publishersByPublisherid = publishersByPublisherid;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Categories getCategoriesByCategoryid() {
        return categoriesByCategoryid;
    }

    public void setCategoriesByCategoryid(Categories categoriesByCategoryid) {
        this.categoriesByCategoryid = categoriesByCategoryid;
    }

    @OneToMany(mappedBy = "booksByBookid")
    public Collection<BookItems> getBookItemsById() {
        return bookItemsById;
    }

    public void setBookItemsById(Collection<BookItems> bookItemsById) {
        this.bookItemsById = bookItemsById;
    }
}
