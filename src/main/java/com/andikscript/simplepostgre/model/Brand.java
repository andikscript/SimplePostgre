package com.andikscript.simplepostgre.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "id_brand", nullable = false)
    private String id;

    @Column(name = "nama_brand", nullable = false, length = 512)
    private String namaBrand;

    @Column(name = "kategori", nullable = false, length = 512)
    private String kategori;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "brand_produk",
            joinColumns = @JoinColumn(name = "id_brand"),
            inverseJoinColumns = @JoinColumn(name = "id_produk"))
    private Set<Produk> produks = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBrand() {
        return namaBrand;
    }

    public void setNamaBrand(String namaBrand) {
        this.namaBrand = namaBrand;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Set<Produk> getProduks() {
        return produks;
    }

    public void setProduks(Set<Produk> produks) {
        this.produks = produks;
    }

}