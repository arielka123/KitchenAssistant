ALTER TABLE `kitchen_assistant`.`nutrient`
    CHANGE energy energy int COMMENT 'kcal',
    CHANGE fat fat decimal(4,2) COMMENT 'g',
    CHANGE saturated_fat saturated_fat decimal(4,2) COMMENT 'g',
    CHANGE carbohydrate carbohydrate decimal(4,2) COMMENT 'g',
    CHANGE sugar sugar decimal(4,2) COMMENT 'g',
    CHANGE protein protein decimal(4,2) COMMENT 'g',
    CHANGE fiber fiber decimal(4,2) COMMENT 'g';