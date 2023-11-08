package com.geekOfcode.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekOfcode.demo.model.*;
public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
