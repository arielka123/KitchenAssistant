ALTER TABLE `kitchen_assistant`.`nutrients`
	RENAME COLUMN carbohydrates TO carbohydrate,
	RENAME COLUMN sugars TO sugar,
	RENAME COLUMN proteins TO protein,
	RENAME COLUMN nutrition_grades TO nutrition_grade;