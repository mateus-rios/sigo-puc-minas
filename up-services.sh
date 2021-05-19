#!/bin/bash

echo "setting up services (kafka)"
docker-compose -f services-kafka/docker-compose.yaml up -d

echo "creating topic"
docker-compose -f services-kafka/docker-compose.yaml exec kafka kafka-topics --create --topic gestao_normas --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:32181