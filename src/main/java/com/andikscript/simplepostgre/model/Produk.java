package com.andikscript.simplepostgre.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "produk")
public class Produk {
    @Id
    @Column(name = "id_produk", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "stok", nullable = false)
    private Short stok;

    @Column(name = "harga", nullable = false)
    private Long harga;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    @JoinTable(name = "brand_produk",
            joinColumns = @JoinColumn(name = "id_produk"),
            inverseJoinColumns = @JoinColumn(name = "id_brand"))
    private Set<Brand> brands = new LinkedHashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Short getStok() {
        return stok;
    }

    public void setStok(Short stok) {
        this.stok = stok;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

}