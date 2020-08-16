package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AUTHOR_BOOK", schema = "QuanLyThuVien", catalog = "")
public class AuthorBook {
    private int id;
    private Integer idauthor;
    private Integer idbook;
    private Authors authorsByIdauthor;
    private Books booksByIdbook;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IDAUTHOR")
    public Integer getIdauthor() {
        return idauthor;
    }

    public void setIdauthor(Integer idauthor) {
        this.idauthor = idauthor;
    }

    @Basic
    @Column(name = "IDBOOK")
    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return id == that.id &&
                Objects.equals(idauthor, that.idauthor) &&
                Objects.equals(idbook, that.idbook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idauthor, idbook);
    }

    @ManyToOne
    @JoinColumn(name = "IDAUTHOR", referencedColumnName = "ID", insertable = false, updatable = false)
    public Authors getAuthorsByIdauthor() {
        return authorsByIdauthor;
    }

    public void setAuthorsByIdauthor(Authors authorsByIdauthor) {
        this.authorsByIdauthor = authorsByIdauthor;
    }

    @ManyToOne
    @JoinColumn(name = "IDBOOK", referencedColumnName = "ID", insertable = false, updatable = false)
    public Books getBooksByIdbook() {
        return booksByIdbook;
    }

    public void setBooksByIdbook(Books booksByIdbook) {
        this.booksByIdbook = booksByIdbook;
    }
}
