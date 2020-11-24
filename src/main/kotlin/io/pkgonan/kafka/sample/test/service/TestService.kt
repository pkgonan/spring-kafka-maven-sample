package io.pkgonan.kafka.sample.test.service

import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class TestService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @KafkaListener(topics = ["test-topic"])
    fun handle(record: ConsumerRecord<GenericRecord, GenericRecord>) {
        val value = record.value()!!
        val jsonFormattedValue = value.toString()

        logger.info("Record : $record")
        logger.info("Json Formatted Value : $jsonFormattedValue")
    }
}