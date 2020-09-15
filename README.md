# Payment-Gateway

I have used spring boot and mysql to build this application.Change the database properties in application.properties file as per your db credentials.
Just run mvn clean spring-boot:run to run the project
You can just request post method with url: http://localhost:8080/api/doPayment with following request body to test the api..

{
    "amount":"230",
    "currency":"USD",
    "type":"credit card",
    "card":{
      "number":"121212121212",
      "cvv":"113",
      "expirationMonth":12,
      "expirationYear":"2020"
    }
}
