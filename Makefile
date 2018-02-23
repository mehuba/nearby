install:
	mvn clean install -U -DskipTests -DskipDocker

run:
	nohup java -jar target/api.jar > target/stdout.log 2>&1 &
	tail -f target/stdout.log

tag:
	$(eval commit := $(shell git rev-parse --short HEAD))
	$(eval tag := $(shell mvn help:evaluate -Dexpression=project.version | grep -v "^\[" | sed 's/-SNAPSHOT/-$(commit)/'))
	git tag -a $(tag) -m "Branch: `git branch | grep \* | awk '{print $2}'`"
	git push origin refs/tags/$(tag)

release:
	rm -f release.properties pom.xml.releaseBackup
	mvn release:prepare -B
	rm -f release.properties pom.xml.releaseBackup