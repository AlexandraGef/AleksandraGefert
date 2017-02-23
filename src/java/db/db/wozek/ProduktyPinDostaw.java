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
@Table(name = "produkty_pin_dostaw")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduktyPinDostaw.findAll", query = "SELECT p FROM ProduktyPinDostaw p")
    , @NamedQuery(name = "ProduktyPinDostaw.findById", query = "SELECT p FROM ProduktyPinDostaw p WHERE p.id = :id")
    , @NamedQuery(name = "ProduktyPinDostaw.findByProduktKod", query = "SELECT p FROM ProduktyPinDostaw p WHERE p.produktKod = :produktKod")
    , @NamedQuery(name = "ProduktyPinDostaw.findByPin", query = "SELECT p FROM ProduktyPinDostaw p WHERE p.pin = :pin")})
public class ProduktyPinDostaw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "produkt_kod")
    private String produktKod;
    @Size(max = 10)
    @Column(name = "pin")
    private String pin;

    public ProduktyPinDostaw() {
    }

    public ProduktyPinDostaw(Integer id) {
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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
        if (!(object instanceof ProduktyPinDostaw)) {
            return false;
        }
        ProduktyPinDostaw other = (ProduktyPinDostaw) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.ProduktyPinDostaw[ id=" + id + " ]";
    }
    
}
