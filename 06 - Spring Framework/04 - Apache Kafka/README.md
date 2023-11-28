- Kafka - [Confluent](https://developer.confluent.io/what-is-apache-kafka/)
- Kafka - [Apache](https://kafka.apache.org/)
- Tutorial used for learning - [YT](https://youtu.be/ei6fK9StzMM?si=BfAGDuTIQPRxDFu1)
- Apache Kafka is an <strong>open-source distributed event streaming platform</strong> used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.
- Apache Kafka is like a communication system (messaging system) that helps different parts of a computer system exchange data by publishing and subscribing to topics (pub-sub model).
  - Apache Kafka is a MQ system that uses pub-sub model.
  - Sender publishes the data in Apache Kafka, so it is the publisher.
  - The Receivers that have subscribed, are the only receives the receive the data and are the consumers.
  - Multiple receivers can subscribe to a single topic and consume the same data.
  - The flow of data is called flow of stream.
  - ![](imgs/kafka1.PNG)
- For storing data we use DB (less throughput) but for communication, we use MQs (e.g. Apache Kafkam, RabbitMQ, etc.) (more throughput).
- Kafka is a distributed system.
- We use Kafka for the below reasongs:
  - High throughput (high read-write)
  - Fault Tolerance (Replication. As Kafka is a distributed system, the data is stored replicated and stored in multiple nodes.)
  - Durable (As Kafka is a distributed system, so the data is stored in multiple nodes and that increases the durability)
  - Scalable
- Kafka Architecture:
  - ![](/imgs/kafka2.PNG)
  - Components:
    - Producer: This is the component that publishes/produces/sends/writes the message/data in the Kafka.
    - Consumer: This is the component that consumes/receives the data only if it has subscribed to the topic. Multiple consumers can subscribe to a single topic and consume messages from there.
    - Kafka Ecsystem: 
      - Kafka Cluster: This contains Kafka Brokers/Kafka Servers. 
        - Brokers: As Kafka is a distributed system, it can have multiple brokers. And as it's distributed, so it's nodes can be distributed multiple systems easily. Brokers have one/multiple Topics in them.
          - Topics: Topics are the ones that store the messages/data. Just like we create tables inside databases to handle the data, similarly we have topics to handle data inside the brokers.Topics helps in storing and <em>categorizing</em> the data. For example, if some information regarding a User, Order and Logging is coming, then Kafka will categorize them and store thme inside User Topic, Order Topic and Logging Topic respectively. A Topic can have multple same category of messages. To manage them, we use Partitions inside Topics.
            - Partition: Partition stores the message/data inside a Topic with the help of offsets.
      - Zookeeper: This manages (the state of) Kafka Brokers inside the Kafka Cluster.
- Commands:
  - Start zookeeper:
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
  - Start Kafka server:
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\kafka-server-start.bat config\server.properties
  - Create new topic (user-topic) with kafka-topics
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\kafka-topics.bat --create --topic user-topic --bootstrap-server localhost:9092
  - All the options that kafka-topics provide:
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\kafka-topics.bat --help
  - Produce message with kafka-console-producer
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\kafka-console-producer.bat --topic user-topic --bootstrap-server localhost:9092
  - Consume message with kafka-console-consumer
    >C:\kafka\kafka_2.13-3.6.0>bin\windows\kafka-console-consumer.bat --topic user-topic --from-beginning --bootstrap-server localhost:9092
- Block Diagram of the demo app:
  - ![](/imgs/kafka3.PNG)
  - There are two Microservices
    - Delivery App Service (Producer)
    - End User App Service (Consumer)