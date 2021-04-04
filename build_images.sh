#!/bin/bash

echo "building gestao-normas"
cd gestao-normas
docker build -t gestao_normas .

cd ..
echo "building repositorio-normas"
cd repositorio-normas
docker build -t repositorio_normas .

cd ..
echo "building simple-consumer"
cd simple-consumer
docker build -t simple_consumer .

cd ..
echo "building sigo-interface"
cd simple-consumer
docker build -t sigo_interface .