package com.andikscript.simplepostgre.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "brand_produk")
public class BrandProduk {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private BrandProdukId id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @MapsId("produkId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_produk", nullable = false)
    private Produk idProduk;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @MapsId("brandId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand idBrand;

    public Produk getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(Produk idProduk) {
        this.idProduk = idProduk;
    }

    public Brand getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Brand idBrand) {
        this.idBrand = idBrand;
    }

}