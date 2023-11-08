package com.geekOfcode.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.geekOfcode.demo.Repository.ProduitRepository;
import com.geekOfcode.demo.model.Produit;
import com.geekOfcode.demo.service.ProduitService;
import lombok.AllArgsConstructor;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	private  ProduitRepository produitRepos;
	
	@Override
	public ResponseEntity<Produit> creer(Produit produit) {
		
		Produit NouveauProduit = produitRepos.save(produit);
		return new ResponseEntity<>(NouveauProduit, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<List<Produit>> lire(){
		List<Produit>  produitAll = produitRepos.findAll();
		return new ResponseEntity<>(produitAll, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Produit> modifier(Long id, Produit produit) {
        Optional<Produit> produitOptional = produitRepos.findById(id);
		 if (produitOptional.isPresent()) {
	            Produit existant = produitOptional.get();
	            existant.setPrix(produit.getPrix());
	            existant.setNom(produit.getNom());
	            existant.setDescription(produit.getDescription());
	            produitRepos.save(existant);
	            return new ResponseEntity<>(existant, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	@Override
	 public ResponseEntity<String> supprimer(Long id) {
        if (produitRepos.existsById(id)) {
            produitRepos.deleteById(id);
            return new ResponseEntity<>("Produit supprimé avec succès.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produit non trouvé avec l'ID : " + id, HttpStatus.NOT_FOUND);
        }
    }
}
