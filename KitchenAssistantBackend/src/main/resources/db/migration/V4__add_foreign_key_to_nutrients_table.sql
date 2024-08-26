alter table `kitchen_assistant`.`nutrients`
add column product_id int;

alter table `kitchen_assistant`.`nutrients`
add foreign key (product_id) references products (id);

