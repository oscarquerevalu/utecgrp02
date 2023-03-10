# utecgrp02

# Maven
mvn clean install

# Docker
docker build -t utecgrp02.azurecr.io/ms-utec-gr02:latest .
docker run -d -p 8080:8080 -t utecgrp02.azurecr.io/ms-utec-gr02
winpty docker login utecgrp02.azurecr.io
docker push utecgrp02.azurecr.io/ms-utec-gr02:latest

