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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id")
    , @NamedQuery(name = "Schedule.findByUserkod", query = "SELECT s FROM Schedule s WHERE s.userkod = :userkod")
    , @NamedQuery(name = "Schedule.findByKlient", query = "SELECT s FROM Schedule s WHERE s.klient = :klient")
    , @NamedQuery(name = "Schedule.findByProduktKod", query = "SELECT s FROM Schedule s WHERE s.produktKod = :produktKod")
    , @NamedQuery(name = "Schedule.findByPlanZamowienia", query = "SELECT s FROM Schedule s WHERE s.planZamowienia = :planZamowienia")
    , @NamedQuery(name = "Schedule.findByPlanTyp", query = "SELECT s FROM Schedule s WHERE s.planTyp = :planTyp")
    , @NamedQuery(name = "Schedule.findByPlanData", query = "SELECT s FROM Schedule s WHERE s.planData = :planData")})
public class Schedule implements Serializable {

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
    @Column(name = "plan_zamowienia")
    private Integer planZamowienia;
    @Size(max = 60)
    @Column(name = "plan_typ")
    private String planTyp;
    @Column(name = "plan_data")
    @Temporal(TemporalType.DATE)
    private Date planData;

    public Schedule() {
    }

    public Schedule(Integer id) {
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

    public Integer getPlanZamowienia() {
        return planZamowienia;
    }

    public void setPlanZamowienia(Integer planZamowienia) {
        this.planZamowienia = planZamowienia;
    }

    public String getPlanTyp() {
        return planTyp;
    }

    public void setPlanTyp(String planTyp) {
        this.planTyp = planTyp;
    }

    public Date getPlanData() {
        return planData;
    }

    public void setPlanData(Date planData) {
        this.planData = planData;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Schedule[ id=" + id + " ]";
    }
    
}
