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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id")
    , @NamedQuery(name = "Menu.findByMenucode", query = "SELECT m FROM Menu m WHERE m.menucode = :menucode")
    , @NamedQuery(name = "Menu.findByMenuShortName", query = "SELECT m FROM Menu m WHERE m.menuShortName = :menuShortName")
    , @NamedQuery(name = "Menu.findByMenuLongName", query = "SELECT m FROM Menu m WHERE m.menuLongName = :menuLongName")
    , @NamedQuery(name = "Menu.findByMenuRunOption", query = "SELECT m FROM Menu m WHERE m.menuRunOption = :menuRunOption")
    , @NamedQuery(name = "Menu.findByMenuOrder", query = "SELECT m FROM Menu m WHERE m.menuOrder = :menuOrder")
    , @NamedQuery(name = "Menu.findByRole", query = "SELECT m FROM Menu m WHERE m.role = :role")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 5)
    @Column(name = "menucode")
    private String menucode;
    @Size(max = 10)
    @Column(name = "menu_short_name")
    private String menuShortName;
    @Size(max = 20)
    @Column(name = "menu_long_name")
    private String menuLongName;
    @Size(max = 50)
    @Column(name = "menu_run_option")
    private String menuRunOption;
    @Column(name = "menu_order")
    private Integer menuOrder;
    @Size(max = 15)
    @Column(name = "role")
    private String role;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenuShortName() {
        return menuShortName;
    }

    public void setMenuShortName(String menuShortName) {
        this.menuShortName = menuShortName;
    }

    public String getMenuLongName() {
        return menuLongName;
    }

    public void setMenuLongName(String menuLongName) {
        this.menuLongName = menuLongName;
    }

    public String getMenuRunOption() {
        return menuRunOption;
    }

    public void setMenuRunOption(String menuRunOption) {
        this.menuRunOption = menuRunOption;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Menu[ id=" + id + " ]";
    }
    
}
