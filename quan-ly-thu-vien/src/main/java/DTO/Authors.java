package DTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Authors implements DTO {
    private int id;
    private String name;
    private String description;
    private Collection<AuthorBook> authorBooksById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return id == authors.id &&
                Objects.equals(name, authors.name) &&
                Objects.equals(description, authors.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "authorsByIdauthor")
    public Collection<AuthorBook> getAuthorBooksById() {
        return authorBooksById;
    }

    public void setAuthorBooksById(Collection<AuthorBook> authorBooksById) {
        this.authorBooksById = authorBooksById;
    }
}
