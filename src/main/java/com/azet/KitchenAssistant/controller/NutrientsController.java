package com.azet.KitchenAssistant.controller;

import com.azet.KitchenAssistant.Entity.Nutrients;
import com.azet.KitchenAssistant.dao.NutrientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/nutrients")
class NutrientsController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    public final NutrientsRepository nutrientsRepository;

    NutrientsController(final NutrientsRepository nutrientsRepository) {
        this.nutrientsRepository = nutrientsRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Nutrients>> readAllNutrients(Pageable page){

        logger.info("custom pageable for all nutrients");
        return ResponseEntity.ok(nutrientsRepository.findAll(page).getContent());
        //http://localhost:8080/nutrients?page=0&size=10
    }
}
