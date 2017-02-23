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
@Table(name = "produkty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkty.findAll", query = "SELECT p FROM Produkty p")
    , @NamedQuery(name = "Produkty.findById", query = "SELECT p FROM Produkty p WHERE p.id = :id")
    , @NamedQuery(name = "Produkty.findByProduktKategoriaKodu", query = "SELECT p FROM Produkty p WHERE p.produktKategoriaKodu = :produktKategoriaKodu")
    , @NamedQuery(name = "Produkty.findByProduktKod", query = "SELECT p FROM Produkty p WHERE p.produktKod = :produktKod")
    , @NamedQuery(name = "Produkty.findByProduktShortDesc", query = "SELECT p FROM Produkty p WHERE p.produktShortDesc = :produktShortDesc")
    , @NamedQuery(name = "Produkty.findByProduktLongDesc", query = "SELECT p FROM Produkty p WHERE p.produktLongDesc = :produktLongDesc")
    , @NamedQuery(name = "Produkty.findByProduktZdjecie", query = "SELECT p FROM Produkty p WHERE p.produktZdjecie = :produktZdjecie")
    , @NamedQuery(name = "Produkty.findByProduktKolor", query = "SELECT p FROM Produkty p WHERE p.produktKolor = :produktKolor")
    , @NamedQuery(name = "Produkty.findByProduktGwarancja", query = "SELECT p FROM Produkty p WHERE p.produktGwarancja = :produktGwarancja")
    , @NamedQuery(name = "Produkty.findByProduktRozmiar", query = "SELECT p FROM Produkty p WHERE p.produktRozmiar = :produktRozmiar")
    , @NamedQuery(name = "Produkty.findByProduktWartosc", query = "SELECT p FROM Produkty p WHERE p.produktWartosc = :produktWartosc")
    , @NamedQuery(name = "Produkty.findByProduktDniDostaw", query = "SELECT p FROM Produkty p WHERE p.produktDniDostaw = :produktDniDostaw")})
public class Produkty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "produkt_kategoria_kodu")
    private String produktKategoriaKodu;
    @Size(max = 60)
    @Column(name = "produkt_kod")
    private String produktKod;
    @Size(max = 25)
    @Column(name = "produkt_short_desc")
    private String produktShortDesc;
    @Size(max = 50)
    @Column(name = "produkt_long_desc")
    private String produktLongDesc;
    @Size(max = 100)
    @Column(name = "produkt_zdjecie")
    private String produktZdjecie;
    @Size(max = 10)
    @Column(name = "produkt_kolor")
    private String produktKolor;
    @Column(name = "produkt_gwarancja")
    private Integer produktGwarancja;
    @Size(max = 10)
    @Column(name = "produkt_rozmiar")
    private String produktRozmiar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produkt_wartosc")
    private Double produktWartosc;
    @Column(name = "produkt_dni_dostaw")
    private Integer produktDniDostaw;

    public Produkty() {
    }

    public Produkty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduktKategoriaKodu() {
        return produktKategoriaKodu;
    }

    public void setProduktKategoriaKodu(String produktKategoriaKodu) {
        this.produktKategoriaKodu = produktKategoriaKodu;
    }

    public String getProduktKod() {
        return produktKod;
    }

    public void setProduktKod(String produktKod) {
        this.produktKod = produktKod;
    }

    public String getProduktShortDesc() {
        return produktShortDesc;
    }

    public void setProduktShortDesc(String produktShortDesc) {
        this.produktShortDesc = produktShortDesc;
    }

    public String getProduktLongDesc() {
        return produktLongDesc;
    }

    public void setProduktLongDesc(String produktLongDesc) {
        this.produktLongDesc = produktLongDesc;
    }

    public String getProduktZdjecie() {
        return produktZdjecie;
    }

    public void setProduktZdjecie(String produktZdjecie) {
        this.produktZdjecie = produktZdjecie;
    }

    public String getProduktKolor() {
        return produktKolor;
    }

    public void setProduktKolor(String produktKolor) {
        this.produktKolor = produktKolor;
    }

    public Integer getProduktGwarancja() {
        return produktGwarancja;
    }

    public void setProduktGwarancja(Integer produktGwarancja) {
        this.produktGwarancja = produktGwarancja;
    }

    public String getProduktRozmiar() {
        return produktRozmiar;
    }

    public void setProduktRozmiar(String produktRozmiar) {
        this.produktRozmiar = produktRozmiar;
    }

    public Double getProduktWartosc() {
        return produktWartosc;
    }

    public void setProduktWartosc(Double produktWartosc) {
        this.produktWartosc = produktWartosc;
    }

    public Integer getProduktDniDostaw() {
        return produktDniDostaw;
    }

    public void setProduktDniDostaw(Integer produktDniDostaw) {
        this.produktDniDostaw = produktDniDostaw;
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
        if (!(object instanceof Produkty)) {
            return false;
        }
        Produkty other = (Produkty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Produkty[ id=" + id + " ]";
    }
    
}
