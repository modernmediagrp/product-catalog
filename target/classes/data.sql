insert into product (id, description, quantity, created_or_modified_date, created_or_modified_by) values (101, 'Product1', 90, sysdate(), 'thisara');
insert into product (id, description, quantity, created_or_modified_date, created_or_modified_by) values (102, 'Product2', 100, sysdate(), 'sandaradura');
insert into product (id, description, quantity, created_or_modified_date, created_or_modified_by) values (103, 'Product3', 110, sysdate(), 'lakmal');

insert into category (id, description, created_or_modified_date, created_or_modified_by) values (201, 'Produc1', sysdate(), 'thisara');
insert into category (id, description, created_or_modified_date, created_or_modified_by) values (202, 'Produc2', sysdate(), 'sandaradura');

insert into category_products (category_id,product_id) values (201, 101);
insert into category_products (category_id,product_id) values (201, 102);
insert into category_products (category_id,product_id) values (202, 103);
