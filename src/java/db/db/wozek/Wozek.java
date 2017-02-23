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
import javax.persistence.EntityManager;
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
@Table(name = "wozek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wozek.findAll", query = "SELECT w FROM Wozek w")
    , @NamedQuery(name = "Wozek.findById", query = "SELECT w FROM Wozek w WHERE w.id = :id")
    , @NamedQuery(name = "Wozek.findByIlosc", query = "SELECT w FROM Wozek w WHERE w.ilosc = :ilosc")
    , @NamedQuery(name = "Wozek.findByKlient", query = "SELECT w FROM Wozek w WHERE w.klient = :klient")
    , @NamedQuery(name = "Wozek.findByProduktKod", query = "SELECT w FROM Wozek w WHERE w.produktKod = :produktKod")
    , @NamedQuery(name = "Wozek.findByProduktWartosc", query = "SELECT w FROM Wozek w WHERE w.produktWartosc = :produktWartosc")
    , @NamedQuery(name = "Wozek.findByWozekData", query = "SELECT w FROM Wozek w WHERE w.wozekData = :wozekData")})
public class Wozek implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ilosc")
    private Integer ilosc;
    @Size(max = 8)
    @Column(name = "klient")
    private String klient;
    @Size(max = 60)
    @Column(name = "produkt_kod")
    private String produktKod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produkt_wartosc")
    private Double produktWartosc;
    @Column(name = "wozek_data")
    @Temporal(TemporalType.DATE)
    private Date wozekData;

    public Wozek() {
    }

    public Wozek(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public String getProduktKod() {
        return produktKod;
    }

    public void setProduktKod(String produktKod) {
        this.produktKod = produktKod;
    }

    public Double getProduktWartosc() {
        return produktWartosc;
    }

    public void setProduktWartosc(Double produktWartosc) {
        this.produktWartosc = produktWartosc;
    }

    public Date getWozekData() {
        return wozekData;
    }

    public void setWozekData(Date wozekData) {
        this.wozekData = wozekData;
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
        if (!(object instanceof Wozek)) {
            return false;
        }
        Wozek other = (Wozek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Wozek[ id=" + id + " ]";
    }

}
