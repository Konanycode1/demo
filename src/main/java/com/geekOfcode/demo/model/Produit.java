package com.geekOfcode.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity
@Table(name="PRODUIT")
@Getter
@Setter
@NoArgsConstructor
public class Produit {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50)
	private String nom ;
	
	@Column(length=150)
	private String description;
	
	private Integer prix;
}
