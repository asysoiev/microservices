# microservices
Sandbox for Spring microservices 

## Support services
- config-server
- netflix-eureka-naming-server
- zuul-gateway-server
- rabitmq

## Busines services:
- limits-service
- currency-exchange-service
- currency-conversion-service

## How to start
1. Create a network in docker:  
    docker network create microservices-network
2. Install RabitMQ service for Zipkin distributed tracing server 
3. Start services:  
    docker compose up -d
   
## Endpoints
Direct:
- http://localhost:8000/currency-exchange/from/USD/to/UAH
- http://localhost:8100/currency-conversion/from/USD/to/UAH/quantity/10
Netflix Zuul Server:  
- http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/UAH  
- http://localhost:8765/limits-service/limits
- http://localhost:8765/currency-conversion-service/currency-conversion/from/USD/to/UAH/quantity/10  
Zipkin traces:  
- http://localhost:9411/zipkin/