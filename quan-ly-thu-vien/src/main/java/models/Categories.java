package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categories {
    private int id;
    private String name;
    private Collection<Books> booksById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "categoriesByCategoryid")
    public Collection<Books> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Books> booksById) {
        this.booksById = booksById;
    }
}
