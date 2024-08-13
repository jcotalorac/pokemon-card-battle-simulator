docker rm -f pokemon-battle-simulator
docker build --tag pokemon-battle-simulator-img .
docker run -p 8080:8080 --name pokemon-battle-simulator pokemon-battle-simulator-img
