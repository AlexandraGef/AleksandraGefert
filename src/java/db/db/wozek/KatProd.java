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
@Table(name = "kat_prod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatProd.findAll", query = "SELECT k FROM KatProd k")
    , @NamedQuery(name = "KatProd.findById", query = "SELECT k FROM KatProd k WHERE k.id = :id")
    , @NamedQuery(name = "KatProd.findByKatKod", query = "SELECT k FROM KatProd k WHERE k.katKod = :katKod")
    , @NamedQuery(name = "KatProd.findByKatSchematZnizek", query = "SELECT k FROM KatProd k WHERE k.katSchematZnizek = :katSchematZnizek")})
public class KatProd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "kat_kod")
    private String katKod;
    @Size(max = 10)
    @Column(name = "kat_schemat_znizek")
    private String katSchematZnizek;

    public KatProd() {
    }

    public KatProd(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKatKod() {
        return katKod;
    }

    public void setKatKod(String katKod) {
        this.katKod = katKod;
    }

    public String getKatSchematZnizek() {
        return katSchematZnizek;
    }

    public void setKatSchematZnizek(String katSchematZnizek) {
        this.katSchematZnizek = katSchematZnizek;
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
        if (!(object instanceof KatProd)) {
            return false;
        }
        KatProd other = (KatProd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.KatProd[ id=" + id + " ]";
    }
    
}
