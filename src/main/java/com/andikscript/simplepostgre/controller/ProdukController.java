package com.andikscript.simplepostgre.controller;

import com.andikscript.simplepostgre.model.Brand;
import com.andikscript.simplepostgre.model.Produk;
import com.andikscript.simplepostgre.model.ProdukCreate;
import com.andikscript.simplepostgre.repository.BrandRepository;
import com.andikscript.simplepostgre.repository.ProdukRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/produk")
public class ProdukController {

    private final ProdukRepository produkRepository;

    private final BrandRepository brandRepository;

    public ProdukController(ProdukRepository produkRepository, BrandRepository brandRepository) {
        this.produkRepository = produkRepository;
        this.brandRepository = brandRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addProduk(@RequestBody ProdukCreate produkCreate) {
        Brand getBrand = brandRepository.findById(produkCreate.getBrand()).get();
        Produk p = new Produk();
        p.setHarga(produkCreate.getHarga());
        p.setStok(produkCreate.getStok());
        p.getBrands().add(getBrand);

        produkRepository.save(p);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("create");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllBrand() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produkRepository.findAll());
    }
}
