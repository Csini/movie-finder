build:
	mvn clean install -B -U
start-mysql:
	docker-compose -f docker-compose-mysql.yml up -d
stop-mysql:
	docker-compose -f docker-compose-mysql.yml down --remove-orphans
restart-mysql:
	make stop-mysql
	make start-mysql