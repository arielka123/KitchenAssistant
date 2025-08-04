package com.azet.KitchenAssistant.dao;

import com.azet.KitchenAssistant.Entity.Nutrient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutrientsRepository extends JpaRepository<Nutrient,Integer> {

    Nutrient save(Nutrient entity);

    Page<Nutrient> findAll(Pageable page);

    Optional<Nutrient> findByProduct_Id(Integer id);
}
