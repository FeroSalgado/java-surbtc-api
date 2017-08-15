# Java SurBTC Api

### Important !
  - This software is under development
  - You must compile it yourself via maven
  - This software will undergo major changes in structure, but not in the way it is used
  
### How to compile it
    mvn clean install

### Installation

Include the following in your pom.xml
```
<dependency>
    <groupId>com.ferosalgado</groupId>
    <artifactId>java-surbtc-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
### How use
```
ClientAuth clientAuth = new ClientAuth(ApiKey,ApiSecret);
Ticker ticker = clientAuth.ticker("BTC-CLP");
```
### Developed functions
ticker(String market)

orderBook(String market)
 
markets()

marketDetail(String market)

balances()

balanceDetail(String currency)

orders(String market)

simulateWithdrawal(String currency, float amount)