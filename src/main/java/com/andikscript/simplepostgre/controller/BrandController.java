package com.andikscript.simplepostgre.controller;

import com.andikscript.simplepostgre.model.Brand;
import com.andikscript.simplepostgre.repository.BrandRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/brand")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addBrand(@RequestBody Brand brand) {
        brandRepository.save(brand);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("create");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllBrand() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandRepository.findAll());
    }
}
