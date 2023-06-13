# perigea
This is a Data Extractor service. 
This was one of my first application service I realised.
I used Spring Boot: the Core starts letting the Rest Controller call the /dataExtractor, whose request is to run the service.
The only task this service does is deserializing external API's object and serializing into Java objects.
Then, JPA maps this objects and Hibernate manages datas' perstistence in a relational database.
