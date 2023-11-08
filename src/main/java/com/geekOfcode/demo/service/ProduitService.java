package com.geekOfcode.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.geekOfcode.demo.model.*;
public interface ProduitService {
	
	ResponseEntity<Produit> creer(Produit produit);
	ResponseEntity<List<Produit>> lire();
	ResponseEntity<Produit> modifier(Long id, Produit produit);
	ResponseEntity<String> supprimer(Long id);
}
