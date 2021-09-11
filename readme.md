Welcome pangeae notifiction service

This service run on rabbitmq

To start rabbitmq server before starting the project, run the docker compose file

```docker-compose up -d```
This will start the rabbitmq server

To start the project , use the maven command on different terminal

```mvn spring-boot:run```

##Publisher
To publish message to the queue: we have two queue defined on this project with different binder

To publish to different queue using different routing key
``test1`` and ```test2```

```localhost:8080/pangaea/publish/test1``` on Post method

Request body
```
{
    "message":"test rabbit"
}
```
This will publish to queue1

```localhost:8080/pangaea/publish/test2``` on Post method
Request body
```
{
    "message":"test rabbit"
}
```
publish to queue2

##Subscriber

There is two listener for each queue declare on the project

The response from the log will display the message from the queue

