echo "setting up services (kafka)"
docker-compose -f .\services-kafka\docker-compose.yaml up -d

echo "waiting all services ready"
TIMEOUT /T 20 /NOBREAK

echo "creating topic"
docker-compose -f .\services-kafka\docker-compose.yaml exec kafka kafka-topics --create --topic gestao_normas --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:32181

echo "waiting topic creation"
TIMEOUT /T 20 /NOBREAK

echo "setting up simple-consumer (Like a BI listener)"
docker-compose -f .\services-consumer\docker-compose.yml up -d
