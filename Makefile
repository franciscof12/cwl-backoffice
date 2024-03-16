.PHONY: build clean test assemble check jar javadoc run

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