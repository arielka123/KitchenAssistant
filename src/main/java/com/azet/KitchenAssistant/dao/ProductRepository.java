package com.azet.KitchenAssistant.dao;

import com.azet.KitchenAssistant.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Page<Product> findAll(Pageable page);

    Page<Product> findByCategoryId(Long id, Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    Product save(Product entity);
}
