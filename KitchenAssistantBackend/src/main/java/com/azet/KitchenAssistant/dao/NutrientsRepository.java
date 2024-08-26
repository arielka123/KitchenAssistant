package com.azet.KitchenAssistant.dao;

import com.azet.KitchenAssistant.Entity.Nutrients;
import com.azet.KitchenAssistant.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface NutrientsRepository extends JpaRepository<Nutrients ,Integer> {

    Nutrients save(Nutrients entity);

    Page<Nutrients> findAll(Pageable page);

    Optional<Nutrients> findByProduct_Id(Integer id);
}
