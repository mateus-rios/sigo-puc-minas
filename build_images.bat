echo "building gestao-normas"
cd gestao-normas
docker build -t gestao_normas .

cd ..
echo "building simple-consumer"
cd simple-consumer
docker build -t simple_consumer .