package com.andikscript.simplepostgre.repository;

import com.andikscript.simplepostgre.model.Produk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Integer> {
}
