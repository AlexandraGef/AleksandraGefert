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
@Table(name = "opinie_produktu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpinieProduktu.findAll", query = "SELECT o FROM OpinieProduktu o")
    , @NamedQuery(name = "OpinieProduktu.findById", query = "SELECT o FROM OpinieProduktu o WHERE o.id = :id")
    , @NamedQuery(name = "OpinieProduktu.findByProduktKod", query = "SELECT o FROM OpinieProduktu o WHERE o.produktKod = :produktKod")
    , @NamedQuery(name = "OpinieProduktu.findByOpinie", query = "SELECT o FROM OpinieProduktu o WHERE o.opinie = :opinie")
    , @NamedQuery(name = "OpinieProduktu.findByKlientKod", query = "SELECT o FROM OpinieProduktu o WHERE o.klientKod = :klientKod")
    , @NamedQuery(name = "OpinieProduktu.findByDated", query = "SELECT o FROM OpinieProduktu o WHERE o.dated = :dated")})
public class OpinieProduktu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "produkt_kod")
    private String produktKod;
    @Size(max = 50)
    @Column(name = "opinie")
    private String opinie;
    @Size(max = 10)
    @Column(name = "klient_kod")
    private String klientKod;
    @Column(name = "dated")
    @Temporal(TemporalType.DATE)
    private Date dated;

    public OpinieProduktu() {
    }

    public OpinieProduktu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduktKod() {
        return produktKod;
    }

    public void setProduktKod(String produktKod) {
        this.produktKod = produktKod;
    }

    public String getOpinie() {
        return opinie;
    }

    public void setOpinie(String opinie) {
        this.opinie = opinie;
    }

    public String getKlientKod() {
        return klientKod;
    }

    public void setKlientKod(String klientKod) {
        this.klientKod = klientKod;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
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
        if (!(object instanceof OpinieProduktu)) {
            return false;
        }
        OpinieProduktu other = (OpinieProduktu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.OpinieProduktu[ id=" + id + " ]";
    }
    
}
