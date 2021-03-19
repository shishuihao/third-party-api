#!/usr/bin/env sh
version=0.0.1
. ./.env
docker build -t third-party-api:$version -f Dockerfile --build-arg VERSION=$version .
docker push third-party-api:$version
