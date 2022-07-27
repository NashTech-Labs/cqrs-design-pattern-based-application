This is a sample example of CQRS design pattern based application with axon server. Any suggestions, new
features or corrections are welcome!

# System requirements

    Open JDK 11
    Maven
    Docker
# Clone Project
```
Clone git@github.com:knoldus/restAPI-using-webflux.git and import project
mvn clean install
docker-compose up --build
```

# Test API from swagger UI
```
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/#
```
# To verify mongodb collection
```
sudo su 
mongo
show dbs
use axon_schema
db.user.find()
```