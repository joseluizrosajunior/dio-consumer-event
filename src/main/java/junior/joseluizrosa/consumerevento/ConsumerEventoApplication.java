package junior.joseluizrosa.consumerevento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerEventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerEventoApplication.class, args);
	}

}
