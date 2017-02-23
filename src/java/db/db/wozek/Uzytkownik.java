/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.db.wozek;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ola
 */
@Entity
@Table(name = "uzytkownik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzytkownik.findAll", query = "SELECT u FROM Uzytkownik u")
    , @NamedQuery(name = "Uzytkownik.findById", query = "SELECT u FROM Uzytkownik u WHERE u.id = :id")
    , @NamedQuery(name = "Uzytkownik.findByUser", query = "SELECT u FROM Uzytkownik u WHERE u.user = :user")
    , @NamedQuery(name = "Uzytkownik.findByPassword", query = "SELECT u FROM Uzytkownik u WHERE u.password = :password")
    , @NamedQuery(name = "Uzytkownik.findByRole", query = "SELECT u FROM Uzytkownik u WHERE u.role = :role")
    , @NamedQuery(name = "Uzytkownik.findByCreateDate", query = "SELECT u FROM Uzytkownik u WHERE u.createDate = :createDate")
    , @NamedQuery(name = "Uzytkownik.findByHint", query = "SELECT u FROM Uzytkownik u WHERE u.hint = :hint")
    , @NamedQuery(name = "Uzytkownik.findByHintAns", query = "SELECT u FROM Uzytkownik u WHERE u.hintAns = :hintAns")
    , @NamedQuery(name = "Uzytkownik.findByUserName", query = "SELECT u FROM Uzytkownik u WHERE u.userName = :userName")
    , @NamedQuery(name = "Uzytkownik.findByUserEmail", query = "SELECT u FROM Uzytkownik u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "Uzytkownik.findByPlec", query = "SELECT u FROM Uzytkownik u WHERE u.plec = :plec")
    , @NamedQuery(name = "Uzytkownik.findByDob", query = "SELECT u FROM Uzytkownik u WHERE u.dob = :dob")
    , @NamedQuery(name = "Uzytkownik.findByTelefon", query = "SELECT u FROM Uzytkownik u WHERE u.telefon = :telefon")
    , @NamedQuery(name = "Uzytkownik.findByAdres", query = "SELECT u FROM Uzytkownik u WHERE u.adres = :adres")})
public class Uzytkownik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 8)
    @Column(name = "user")
    private String user;
    @Size(max = 8)
    @Column(name = "password")
    private String password;
    @Size(max = 15)
    @Column(name = "role")
    private String role;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Size(max = 50)
    @Column(name = "hint")
    private String hint;
    @Size(max = 15)
    @Column(name = "hint_ans")
    private String hintAns;
    @Size(max = 25)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 50)
    @Column(name = "user_email")
    private String userEmail;
    @Size(max = 1)
    @Column(name = "plec")
    private String plec;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "telefon")
    private Integer telefon;
    @Size(max = 100)
    @Column(name = "adres")
    private String adres;

    public Uzytkownik() {
    }

    public Uzytkownik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHintAns() {
        return hintAns;
    }

    public void setHintAns(String hintAns) {
        this.hintAns = hintAns;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Uzytkownik[ id=" + id + " ]";
    }
    
}
