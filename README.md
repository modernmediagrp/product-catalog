# product-catalog

Steps to run 
1. Download or checkout the repository
2. Extract and import the project as a maven project to your IDE (Intellij or Eclipse)
3. Find the "ProductCatalogApplication.java" class in the "com.sandaradura.productcatalog" package under the "src" folder.
4. Run it as a Java application.
5. After the application started you can call the APIs.
  http://localhost:8080 >>>>
	  /product-catalog/categories - GET
    /product-catalog/categories/201 - GET
    /product-catalog/categories - POST
    /product-catalog/categories/202 - DELETE
    /product-catalog/categories/202 - PUT
    /product-catalog/products - POST
	  /product-catalog/products/101	- DELETE
	  /product-catalog/products/101 - PUT
    
 6. Basic Authentication needs to be provided for in memeory authentication 
    username  | password  | Role
    user      | password  | USER (cannot do the CRUD operations)
    manager   | password  | ADMIN (Can do all the operation)
    
 7. both the XML and JSON supported in header need to set application/json or application/xml
 
 8. example product request object
    
     {
        "id": 102,
        "description": "Product2",
        "quantity": 100,
        "createdOrModifiedDate": "2019-08-11T18:30:00.000+0000",
        "createdOrModifiedBy": "sandaradura"
     }
     
 9. Example Category Object.
    {
        "id": 201,     
        "description": "Produc1",
        "createdOrModifiedDate": "2019-08-11T18:30:00.000+0000",
        "createdOrModifiedBy": "thisara"
    }
  
  10. When the application started up sample data is inserted in memory H2 database(can be found in data.sql).
  
  11. H2 database console can be found in (http://localhost:8080/h2-console)
      Username is "sa" password is "" (blank)
      Driver class is "org.h2.Driver"
      Jdbc URL is "jdbc:h2:mem:testdb"
      
  
  
 
