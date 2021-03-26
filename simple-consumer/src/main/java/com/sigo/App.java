package com.sigo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		var consumer = new KafkaConsumer<String, String>(properties());
	    consumer.subscribe(Collections.singletonList("gestao_normas"));
	    System.out.println("Aguardando registros");
	    while (true) {
	        var records = consumer.poll(Duration.ofMillis(100));
	        for (ConsumerRecord<String, String> registro : records) {
	            System.out.println("------------------------------------------");
	            System.out.println("Recebendo novo registro");
	            System.out.println(registro.key());
	            System.out.println(registro.value());

	            System.out.println("Registro processado.");
	        }
	    }
	} 
	
	private static Properties properties() {
	    final Properties properties = new Properties();
	    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
	    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, LocalDateTime.now().toLocalTime().toString());
	    return properties;
	}
}
