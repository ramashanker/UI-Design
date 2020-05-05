## Running

The application can be start is either locally using maven or start in docker container.

### Running the application in docker container

For that we need to create the docker image first and then we can either use docker-compose-mongo.yml or using docker run command.
Start with docker compose please 

```bash
$ docker-compose  pull
$ docker-compose  up
```
### Running the application using Kubernetes.

```
kubectl create -f security-application.yml
kubectl get pods
kubectl get deployment
kubectl describe deployments security-deployment
docker ps
kubectl expose deployment security-deployment --type=LoadBalancer --name=rama-service
kubectl get services rama-service
kubectl describe services rama-service
```

## Testing

http://localhost:4040/
enter unsername 
enter password