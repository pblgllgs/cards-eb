# cards

## build with buildpacks

## generate jar file
```$bash
mvn clean install
```

## build image
```$bash
mvn spring-boot:build-image
```

## push image
```$bash
docker push pblgllgs/cards-eb:latest
```