package DTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "USER_RESPONSES", schema = "QuanLyThuVien", catalog = "")
public class UserResponses implements DTO{
    private int id;
    private Integer accountid;
    private String content;
    private Timestamp createtime;
    private Accounts accountsByAccountid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCOUNTID")
    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "CREATETIME")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponses that = (UserResponses) o;
        return id == that.id &&
                Objects.equals(accountid, that.accountid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountid, content, createtime);
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ID", insertable = false, updatable = false)
    public Accounts getAccountsByAccountid() {
        return accountsByAccountid;
    }

    public void setAccountsByAccountid(Accounts accountsByAccountid) {
        this.accountsByAccountid = accountsByAccountid;
    }
}
