echo "building gestao-normas"
cd gestao-normas
docker build -t gestao_normas .

cd ..
echo "building repositorio-normas"
cd repositorio-normas
docker build -t repositorio_normas .

cd ..
echo "building interface"
cd sigo-interface
docker build -t sigo_interface .