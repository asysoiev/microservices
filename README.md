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
2. Start services:  
    docker compose up -d