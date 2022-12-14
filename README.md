# food-ordering-system

This project aims to provide an application utilizing following concepts and technologies:

**Microservices, Clean & Hexagonal Architectures, DDD, SAGA, Outbox, Kafka and K8s.**

Project architecture overview:
![](/resources/overview.png)

Modules dependency schema:
![](/resources/dependency-graph.png)

## Running on local environment

### Create Zookeeper
Run the below command so that Zookeeper can be created:

```docker-compose -f infrastructure/docker-compose/common.yml -f infrastructure/docker-compose/zookeeper.yml up```

Check if everything is up with command:

```echo ruok | nc localhost 2181```

The output has to be ```imok```.

### Create Kafka
Run the below command so that Kafka can be created:

```docker-compose -f infrastructure/docker-compose/common.yml  -f infrastructure/docker-compose/kafka_cluster.yml up```

### Run Kafka
To run Kafka just execute the following command:

```docker-compose -f infrastructure/docker-compose/common.yml -f infrastructure/docker-compose/init_kafka.yml up```

Go to ```localhost:9000``` on your browser and check if Kafka's page is loading - it should be.
If this is your first time loading Kafka for this project, you need to add the cluster manually.

**Remember that when you are using volume mappings you should first start Zookeeper and then the Kafka cluster. The cluster always checks the health of Zookeeper at startup time, and it fails if it is unhealthy.**