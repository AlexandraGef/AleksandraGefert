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
@Table(name = "platnosci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platnosci.findAll", query = "SELECT p FROM Platnosci p")
    , @NamedQuery(name = "Platnosci.findById", query = "SELECT p FROM Platnosci p WHERE p.id = :id")
    , @NamedQuery(name = "Platnosci.findByUserkod", query = "SELECT p FROM Platnosci p WHERE p.userkod = :userkod")
    , @NamedQuery(name = "Platnosci.findByKlient", query = "SELECT p FROM Platnosci p WHERE p.klient = :klient")
    , @NamedQuery(name = "Platnosci.findByProduktKod", query = "SELECT p FROM Platnosci p WHERE p.produktKod = :produktKod")
    , @NamedQuery(name = "Platnosci.findByPlatnosciOpcje", query = "SELECT p FROM Platnosci p WHERE p.platnosciOpcje = :platnosciOpcje")
    , @NamedQuery(name = "Platnosci.findByPlatnosciData", query = "SELECT p FROM Platnosci p WHERE p.platnosciData = :platnosciData")
    , @NamedQuery(name = "Platnosci.findByPlatnosciStatus", query = "SELECT p FROM Platnosci p WHERE p.platnosciStatus = :platnosciStatus")})
public class Platnosci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 8)
    @Column(name = "userkod")
    private String userkod;
    @Size(max = 8)
    @Column(name = "klient")
    private String klient;
    @Size(max = 60)
    @Column(name = "produkt_kod")
    private String produktKod;
    @Size(max = 10)
    @Column(name = "platnosci_opcje")
    private String platnosciOpcje;
    @Column(name = "platnosci_data")
    @Temporal(TemporalType.DATE)
    private Date platnosciData;
    @Size(max = 8)
    @Column(name = "platnosci_status")
    private String platnosciStatus;

    public Platnosci() {
    }

    public Platnosci(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserkod() {
        return userkod;
    }

    public void setUserkod(String userkod) {
        this.userkod = userkod;
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

    public String getPlatnosciOpcje() {
        return platnosciOpcje;
    }

    public void setPlatnosciOpcje(String platnosciOpcje) {
        this.platnosciOpcje = platnosciOpcje;
    }

    public Date getPlatnosciData() {
        return platnosciData;
    }

    public void setPlatnosciData(Date platnosciData) {
        this.platnosciData = platnosciData;
    }

    public String getPlatnosciStatus() {
        return platnosciStatus;
    }

    public void setPlatnosciStatus(String platnosciStatus) {
        this.platnosciStatus = platnosciStatus;
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
        if (!(object instanceof Platnosci)) {
            return false;
        }
        Platnosci other = (Platnosci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Platnosci[ id=" + id + " ]";
    }
    
}
