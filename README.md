# Spring Kafka Maven Sample
- Schema Registry
    - Avro

## How to use ?
- First, Change topic name
    ```
    @KafkaListener(topics = ["test-topic"])
    ```
    ```
    <subjectPatterns>
        <param>^test-topic-(key|value)$</param>
    </subjectPatterns>
    ```

- Second, Change schema registry url
    ```
    <schemaRegistryUrl>http://localhost:8081</schemaRegistryUrl>
    ```

- Third, Download schema and generate java code using maven build
    ```
    mvn package
    ```

- Fourth, Change ConsumerRecord key & value class to generated java class
    ```
    fun handle(record: ConsumerRecord<Any, Any>)
    ```