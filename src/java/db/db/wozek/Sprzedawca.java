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
@Table(name = "sprzedawca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprzedawca.findAll", query = "SELECT s FROM Sprzedawca s")
    , @NamedQuery(name = "Sprzedawca.findById", query = "SELECT s FROM Sprzedawca s WHERE s.id = :id")
    , @NamedQuery(name = "Sprzedawca.findBySprzedawcaKod", query = "SELECT s FROM Sprzedawca s WHERE s.sprzedawcaKod = :sprzedawcaKod")
    , @NamedQuery(name = "Sprzedawca.findBySprzedawcaImie", query = "SELECT s FROM Sprzedawca s WHERE s.sprzedawcaImie = :sprzedawcaImie")
    , @NamedQuery(name = "Sprzedawca.findBySprzedawcaNazwisko", query = "SELECT s FROM Sprzedawca s WHERE s.sprzedawcaNazwisko = :sprzedawcaNazwisko")
    , @NamedQuery(name = "Sprzedawca.findBySellerAdres", query = "SELECT s FROM Sprzedawca s WHERE s.sellerAdres = :sellerAdres")
    , @NamedQuery(name = "Sprzedawca.findBySellerTelefon", query = "SELECT s FROM Sprzedawca s WHERE s.sellerTelefon = :sellerTelefon")
    , @NamedQuery(name = "Sprzedawca.findByProduktKod", query = "SELECT s FROM Sprzedawca s WHERE s.produktKod = :produktKod")
    , @NamedQuery(name = "Sprzedawca.findByProduktWartosc", query = "SELECT s FROM Sprzedawca s WHERE s.produktWartosc = :produktWartosc")})
public class Sprzedawca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "sprzedawca_kod")
    private String sprzedawcaKod;
    @Size(max = 30)
    @Column(name = "sprzedawca_imie")
    private String sprzedawcaImie;
    @Size(max = 30)
    @Column(name = "sprzedawca_nazwisko")
    private String sprzedawcaNazwisko;
    @Size(max = 100)
    @Column(name = "seller_adres")
    private String sellerAdres;
    @Column(name = "seller_telefon")
    private Integer sellerTelefon;
    @Size(max = 10)
    @Column(name = "produkt_kod")
    private String produktKod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produkt_wartosc")
    private Double produktWartosc;

    public Sprzedawca() {
    }

    public Sprzedawca(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSprzedawcaKod() {
        return sprzedawcaKod;
    }

    public void setSprzedawcaKod(String sprzedawcaKod) {
        this.sprzedawcaKod = sprzedawcaKod;
    }

    public String getSprzedawcaImie() {
        return sprzedawcaImie;
    }

    public void setSprzedawcaImie(String sprzedawcaImie) {
        this.sprzedawcaImie = sprzedawcaImie;
    }

    public String getSprzedawcaNazwisko() {
        return sprzedawcaNazwisko;
    }

    public void setSprzedawcaNazwisko(String sprzedawcaNazwisko) {
        this.sprzedawcaNazwisko = sprzedawcaNazwisko;
    }

    public String getSellerAdres() {
        return sellerAdres;
    }

    public void setSellerAdres(String sellerAdres) {
        this.sellerAdres = sellerAdres;
    }

    public Integer getSellerTelefon() {
        return sellerTelefon;
    }

    public void setSellerTelefon(Integer sellerTelefon) {
        this.sellerTelefon = sellerTelefon;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprzedawca)) {
            return false;
        }
        Sprzedawca other = (Sprzedawca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.db.wozek.Sprzedawca[ id=" + id + " ]";
    }
    
}
