CREATE TABLE IF NOT EXISTS `kitchen_assistant`.`categories`(
    id int primary key auto_increment,
    name varchar(100) not null,
    description varchar(255)
)