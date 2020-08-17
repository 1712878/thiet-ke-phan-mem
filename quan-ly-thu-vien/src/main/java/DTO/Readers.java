package DTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Readers  implements DTO {
    private int personid;
    private String name;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;
    private String gender;
    private Integer type;
    private Collection<Accounts> accountsByPersonid;
    private Collection<Cards> cardsByPersonid;
    private ReaderTypes readerTypesByType;

    public Readers() {
    }

    public Readers(String name, LocalDate dob, String address, String email, String phone, Integer type) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONID")
    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
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
    @Column(name = "DOB")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Readers readers = (Readers) o;
        return personid == readers.personid &&
                Objects.equals(name, readers.name) &&
                Objects.equals(dob, readers.dob) &&
                Objects.equals(address, readers.address) &&
                Objects.equals(email, readers.email) &&
                Objects.equals(phone, readers.phone) &&
                Objects.equals(type, readers.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personid, name, dob, address, email, phone, type);
    }

    @OneToMany(mappedBy = "readersByUserid")
    public Collection<Accounts> getAccountsByPersonid() {
        return accountsByPersonid;
    }

    public void setAccountsByPersonid(Collection<Accounts> accountsByPersonid) {
        this.accountsByPersonid = accountsByPersonid;
    }

    @OneToMany(mappedBy = "readersByReaderid")
    public Collection<Cards> getCardsByPersonid() {
        return cardsByPersonid;
    }

    public void setCardsByPersonid(Collection<Cards> cardsByPersonid) {
        this.cardsByPersonid = cardsByPersonid;
    }

    @ManyToOne
    @JoinColumn(name = "TYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    public ReaderTypes getReaderTypesByType() {
        return readerTypesByType;
    }

    public void setReaderTypesByType(ReaderTypes readerTypesByType) {
        this.readerTypesByType = readerTypesByType;
    }
}
