package com.andikscript.simplepostgre.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BrandProdukId implements Serializable {

    private static final long serialVersionUID = 5996111848077488786L;

    @Column(name = "id_brand", nullable = false)
    private Integer brandId;

    @Column(name = "id_produk", nullable = false)
    private Integer produkId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getProdukId() {
        return produkId;
    }

    public void setProdukId(Integer produkId) {
        this.produkId = produkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BrandProdukId entity = (BrandProdukId) o;
        return Objects.equals(this.brandId, entity.brandId) && Objects.equals(this.produkId, entity.produkId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, produkId);
    }
}
