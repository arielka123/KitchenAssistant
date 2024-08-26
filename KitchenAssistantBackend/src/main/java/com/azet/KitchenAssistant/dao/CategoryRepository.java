package com.azet.KitchenAssistant.dao;

import com.azet.KitchenAssistant.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();

    Optional<Category> findById(int id);

    Category save(Category entity);

    Boolean existsById(int id);
}
