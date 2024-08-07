docker container rm $(docker container ls -a -q)
docker image rmi $(docker image ls -a -q)
docker volume prune
