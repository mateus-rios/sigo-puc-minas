#!/bin/bash

echo "setting up services (kafka)"
exec docker-compose -f services-kafka/docker-compose.yaml up -d

echo "creating topic"
exec docker-compose exec kafka kafka-topics --create --topic gestao_normas --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:32181

echo "setting up simple-consumer (Like a BI listener)"
exec docker-compose -f services-consumer/docker-compose.yml up -d