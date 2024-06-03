CREATE TABLE IF NOT EXISTS `kitchen_assistant`.`nutrients`(
    id int primary key auto_increment,
    energy int,
    fat decimal(4,2),
    saturated_fat decimal(4,2),
    carbohydrates decimal(4,2),
    sugars decimal(4,2),
    proteins decimal(4,2),
    fiber decimal(4,2),
    nutrition_grades varchar(1)
)

