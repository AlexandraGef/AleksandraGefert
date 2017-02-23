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
@Table(name = "system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "System.findAll", query = "SELECT s FROM System s")
    , @NamedQuery(name = "System.findById", query = "SELECT s FROM System s WHERE s.id = :id")
    , @NamedQuery(name = "System.findByCompanyName", query = "SELECT s FROM System s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "System.findByAdd1", query = "SELECT s FROM System s WHERE s.add1 = :add1")
    , @NamedQuery(name = "System.findByAdd3", query = "SELECT s FROM System s WHERE s.add3 = :add3")
    , @NamedQuery(name = "System.findByBottomMessage", query = "SELECT s FROM System s WHERE s.bottomMessage = :bottomMessage")})
public class System implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 25)
    @Column(name = "add1")
    private String add1;
    @Size(max = 25)
    @Column(name = "add3")
    private String add3;
    @Size(max = 25)
    @Column(name = "bottom_message")
    private String bottomMessage;

    public System() {
    }

    public System(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getBottomMessage() {
        return bottomMessage;
    }

    public void setBottomMessage(String bottomMessage) {
        this.bottomMessage = bottomMessage;
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
        if (!(object instanceof System)) {
            return false;
        }
        System other = (System) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.System[ id=" + id + " ]";
    }
    
}
