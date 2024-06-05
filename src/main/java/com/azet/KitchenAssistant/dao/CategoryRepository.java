package com.azet.KitchenAssistant.dao;

import com.azet.KitchenAssistant.Entity.Category;
import com.azet.KitchenAssistant.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();

    Category save(Category entity);
}
