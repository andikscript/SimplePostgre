package com.andikscript.simplepostgre.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProdukCreate {
    private Short stok;

    private Long harga;

    private String brand;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
