# Java-ecommerce-Kafka

Comandos Básicos do Kafka:

#start zookeeper

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#start kafka

.\bin\windows\kafka-server-start.bat .\config\server.properties

#create topic

.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic

#create producer

.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic

#create consumer for listing from-beginning

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning

#Criar mais partições.

kafka-topics --alter --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --partitions 3

#Ver partições

kafka-topics --bootstrap-server localhost:9092 --describe

#Lista Groups e partições

kafka-consumer-groups --all-groups --bootstrap-server localhost:9092 --describe
