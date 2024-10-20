# movie-finder
small dockerized spring-boot REST webservice with redis-cache and mysql db, calling omdb and tmdb

# how to install and start
- checkout the git repository

## start in a docker container e.g. PRODUCTION
- in the root from the git repository call `make start-movie-finder` (you should have make and docker) or just call `docker-compose -f docker-compose.yml up -d` if you don't have make
- configurations you can change in docker-compose.yml

## start in developer mode
- you should have a mysql on port 3306 and a redis on port 6379 before you start the spring-boot app or you can start them in docker container using the docker-spript in the folder `docker-scripts`
- in the root from the git repository call `mvn clean package` then `cd movie-business` then `spring-boot:run`

# API
- port is 8080
- you can see the openapi description from movie-business under http://localhost:8080 if the webservice is running or you find it in `movie-api/doc/index.html` or `movie-api/src/main/resources/openapi.yaml` too