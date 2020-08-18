package DTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONSTANTS", schema = "QuanLyThuVien")
public class Constants implements DTO{
    private int id;
    private String k;
    private String val;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "K")
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Basic
    @Column(name = "VAL")
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constants constants = (Constants) o;
        return id == constants.id &&
                Objects.equals(k, constants.k) &&
                Objects.equals(val, constants.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, k, val);
    }
}
