package com.Radhe.DosaGuy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@ManyToOne
@JsonIgnore
private Cart cart;

@ManyToOne
private Food food;

private int quantity;
private long totalprice;
}
