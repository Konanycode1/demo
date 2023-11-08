package com.geekOfcode.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekOfcode.demo.model.Produit;
import com.geekOfcode.demo.service.ProduitServiceImpl;

import lombok.AllArgsConstructor;

@RestController	
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {

	@Autowired
	private final ProduitServiceImpl service;
	
	@PostMapping("/create")
	public ResponseEntity<Produit> create(@RequestBody Produit produit) {
		return service.creer(produit);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Produit>> read(){
		return service.lire();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Produit> update(@PathVariable Long id,@RequestBody Produit produit) {
		return service.modifier(id, produit);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return service.supprimer(id);
	}
}
