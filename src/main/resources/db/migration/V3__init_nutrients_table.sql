CREATE TABLE IF NOT EXISTS `kitchen_assistant`.`nutrients`(
    id int primary key auto_increment,
    energy int,
    fat decimal(3,2),
    saturated_fat decimal(3,2),
    carbohydrates decimal(3,2),
    sugars decimal(3,2),
    proteins decimal(3,2),
    fiber decimal(3,2),
    nutrition_grades varchar(1)
)

