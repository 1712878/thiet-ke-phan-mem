package DTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cards {
    private int id;
    private String barcode;
    private Integer readerid;
    private Readers readersByReaderid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BARCODE")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "READERID")
    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return id == cards.id &&
                Objects.equals(barcode, cards.barcode) &&
                Objects.equals(readerid, cards.readerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, readerid);
    }

    @ManyToOne
    @JoinColumn(name = "READERID", referencedColumnName = "PERSONID", insertable = false, updatable = false)
    public Readers getReadersByReaderid() {
        return readersByReaderid;
    }

    public void setReadersByReaderid(Readers readersByReaderid) {
        this.readersByReaderid = readersByReaderid;
    }
}
