package com.springboot_crud_example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor

@Entity
@Table(name = "product_tbl")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int quantity;
    private double price;


}
