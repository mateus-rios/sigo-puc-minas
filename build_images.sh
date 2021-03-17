#!/bin/bash


echo "building gestao-normas"
cd gestao-normas
exec docker build -t gestao_normas .

cd ..
echo "building simple-consumer"
cd simple-consumer
exec docker build -t simple_consumer .