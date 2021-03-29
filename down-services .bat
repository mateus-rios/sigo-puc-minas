echo "downing simple-consumer (Like a BI listener)"
docker-compose -f .\services-consumer\docker-compose.yml down

echo "downing services (kafka)"
docker-compose -f .\services-kafka\docker-compose.yaml down