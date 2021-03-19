#!/bin/bash

echo "building gestao-normas"
cd gestao-normas
exec docker build -t gestao_normas .

cd ..
echo "building repositorio-normas"
cd repositorio-normas
exec docker build -t repositorio_normas .

cd ..
echo "building simple-consumer"
cd simple-consumer
exec docker build -t simple_consumer .

cd ..
echo "building sigo-interface"
cd simple-consumer
exec docker build -t sigo_interface .