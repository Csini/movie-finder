start-movie-finder:
	docker-compose -f docker-compose.yml up -d
stop-movie-finder:
	docker-compose -f docker-compose.yml down --remove-orphans
restart-movie-finder:
	make stop-finder
	make start-finder