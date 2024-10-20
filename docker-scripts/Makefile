build:
	mvn clean install -B -U
start-mysql:
	docker-compose -f docker-compose-mysql.yml up -d
stop-mysql:
	docker-compose -f docker-compose-mysql.yml down --remove-orphans
restart-mysql:
	make stop-mysql
	make start-mysql
start-redis:
	docker-compose -f docker-compose-redis.yml up -d
stop-redis:
	docker-compose -f docker-compose-redis.yml down --remove-orphans
restart-redis:
	make stop-redis
	make start-redis