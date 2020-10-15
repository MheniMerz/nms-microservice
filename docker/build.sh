#!/usr/bin/env bash

set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

docker build -t "nms/api-gateway" -f $DIR/../api-gateway/Dockerfile $DIR/../
docker build -t "nms/telemetry-microservice" -f $DIR/../telemetry-microservice/Dockerfile $DIR/../
docker build -t "nms/topology-microservice" -f $DIR/../topology-microservice/Dockerfile $DIR/../
docker build -t "nms/notification-microservice" -f $DIR/../notification-microservice/Dockerfile $DIR/../
docker build -t "nms/configuration-microservice" -f $DIR/../configuration-microservice/Dockerfile $DIR/../
docker build -t "nms/account-microservice" -f $DIR/../account-microservice/Dockerfile $DIR/../
