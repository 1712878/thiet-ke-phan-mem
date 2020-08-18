package DTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "READER_TYPES", schema = "QuanLyThuVien")
public class ReaderTypes implements DTO{
    private int id;
    private String name;
    private Collection<Readers> readersById;

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
        ReaderTypes that = (ReaderTypes) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "readerTypesByType")
    public Collection<Readers> getReadersById() {
        return readersById;
    }

    public void setReadersById(Collection<Readers> readersById) {
        this.readersById = readersById;
    }
}
