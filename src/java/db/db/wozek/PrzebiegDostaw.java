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
@Table(name = "przebieg_dostaw")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrzebiegDostaw.findAll", query = "SELECT p FROM PrzebiegDostaw p")
    , @NamedQuery(name = "PrzebiegDostaw.findById", query = "SELECT p FROM PrzebiegDostaw p WHERE p.id = :id")
    , @NamedQuery(name = "PrzebiegDostaw.findByScheduleZamowienie", query = "SELECT p FROM PrzebiegDostaw p WHERE p.scheduleZamowienie = :scheduleZamowienie")
    , @NamedQuery(name = "PrzebiegDostaw.findByScheduleTyp", query = "SELECT p FROM PrzebiegDostaw p WHERE p.scheduleTyp = :scheduleTyp")})
public class PrzebiegDostaw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "schedule_zamowienie")
    private Integer scheduleZamowienie;
    @Size(max = 60)
    @Column(name = "schedule_typ")
    private String scheduleTyp;

    public PrzebiegDostaw() {
    }

    public PrzebiegDostaw(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleZamowienie() {
        return scheduleZamowienie;
    }

    public void setScheduleZamowienie(Integer scheduleZamowienie) {
        this.scheduleZamowienie = scheduleZamowienie;
    }

    public String getScheduleTyp() {
        return scheduleTyp;
    }

    public void setScheduleTyp(String scheduleTyp) {
        this.scheduleTyp = scheduleTyp;
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
        if (!(object instanceof PrzebiegDostaw)) {
            return false;
        }
        PrzebiegDostaw other = (PrzebiegDostaw) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.PrzebiegDostaw[ id=" + id + " ]";
    }
    
}
