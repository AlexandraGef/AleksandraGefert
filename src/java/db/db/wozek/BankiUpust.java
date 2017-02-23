/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.db.wozek;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ola
 */
@Entity
@Table(name = "banki_upust")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankiUpust.findAll", query = "SELECT b FROM BankiUpust b")
    , @NamedQuery(name = "BankiUpust.findById", query = "SELECT b FROM BankiUpust b WHERE b.id = :id")
    , @NamedQuery(name = "BankiUpust.findByZnizkiDostawcyNazwa", query = "SELECT b FROM BankiUpust b WHERE b.znizkiDostawcyNazwa = :znizkiDostawcyNazwa")
    , @NamedQuery(name = "BankiUpust.findByZnizkiDetale", query = "SELECT b FROM BankiUpust b WHERE b.znizkiDetale = :znizkiDetale")
    , @NamedQuery(name = "BankiUpust.findByZnizkiWartosc", query = "SELECT b FROM BankiUpust b WHERE b.znizkiWartosc = :znizkiWartosc")
    , @NamedQuery(name = "BankiUpust.findByZnizkiOsoby", query = "SELECT b FROM BankiUpust b WHERE b.znizkiOsoby = :znizkiOsoby")})
public class BankiUpust implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "znizki_dostawcy_nazwa")
    private String znizkiDostawcyNazwa;
    @Size(max = 50)
    @Column(name = "znizki_detale")
    private String znizkiDetale;
    @Column(name = "znizki_wartosc")
    private Integer znizkiWartosc;
    @Column(name = "znizki_osoby")
    private Integer znizkiOsoby;

    public BankiUpust() {
    }

    public BankiUpust(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZnizkiDostawcyNazwa() {
        return znizkiDostawcyNazwa;
    }

    public void setZnizkiDostawcyNazwa(String znizkiDostawcyNazwa) {
        this.znizkiDostawcyNazwa = znizkiDostawcyNazwa;
    }

    public String getZnizkiDetale() {
        return znizkiDetale;
    }

    public void setZnizkiDetale(String znizkiDetale) {
        this.znizkiDetale = znizkiDetale;
    }

    public Integer getZnizkiWartosc() {
        return znizkiWartosc;
    }

    public void setZnizkiWartosc(Integer znizkiWartosc) {
        this.znizkiWartosc = znizkiWartosc;
    }

    public Integer getZnizkiOsoby() {
        return znizkiOsoby;
    }

    public void setZnizkiOsoby(Integer znizkiOsoby) {
        this.znizkiOsoby = znizkiOsoby;
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
        if (!(object instanceof BankiUpust)) {
            return false;
        }
        BankiUpust other = (BankiUpust) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.BankiUpust[ id=" + id + " ]";
    }
    
}
