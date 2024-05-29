CREATE TABLE IF NOT EXISTS `kitchen_assistant`.`products`(
    id int primary key auto_increment,
    name varchar(100) not null,
    image varchar(255),
    category_id int not null,
    foreign key (category_id) references categories (id)
)