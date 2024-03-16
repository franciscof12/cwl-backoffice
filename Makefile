.PHONY: build clean test assemble check jar javadoc run docker-build docker-up docker-down docker-clean

build:
	./gradlew build

clean:
	./gradlew clean

test:
	./gradlew test

assemble:
	./gradlew assemble

check:
	./gradlew check

jar:
	./gradlew jar

javadoc:
	./gradlew javadoc

run:
	./gradlew run

build:
	docker-compose build

up:
	docker-compose up -d

down:
	docker-compose down

clean:
	docker system prune -af
	docker volume prune -f
