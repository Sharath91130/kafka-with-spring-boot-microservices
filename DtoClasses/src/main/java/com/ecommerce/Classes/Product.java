package com.ecommerce.Classes;

import lombok.Data;

@Data
public class Product {
   private Integer id;
   
   private String description;
   
   private Double price;
   
   private Integer stocks;
}
