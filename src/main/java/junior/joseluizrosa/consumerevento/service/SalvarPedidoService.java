package junior.joseluizrosa.consumerevento.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junior.joseluizrosa.consumerevento.data.PedidoData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SalvarPedidoService {

    @KafkaListener(topics = "salvar-pedido", groupId = "microservice-consumer")
    private void executar(ConsumerRecord<String, String> record) {
        log.info("key = {}", record.key());
        log.info("headers = {}", record.headers());
        log.info("partition = {}", record.partition());

        String dados = record.value();
        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedido;

        try {
            pedido = mapper.readValue(dados, PedidoData.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter evento [event={}]", dados, ex);
            return;
        }
        log.info("Evento recebido: {}", pedido);
    }
}
