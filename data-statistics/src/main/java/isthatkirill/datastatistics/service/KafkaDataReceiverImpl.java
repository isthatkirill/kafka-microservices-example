package isthatkirill.datastatistics.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import isthatkirill.datastatistics.config.LocalDateTimeDeserializer;
import isthatkirill.datastatistics.model.Data;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer deserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, deserializer)
                .create();

        receiver.receive()
                .subscribe(rec -> {
                    Data data = gson.fromJson(rec.value().toString(), Data.class);
                    kafkaDataService.handle(data);
                    rec.receiverOffset().acknowledge();
                });
    }

}
