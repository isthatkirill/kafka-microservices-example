package isthatkirill.datastatistics.service;

import isthatkirill.datastatistics.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
public class KafkaDataServiceImpl implements KafkaDataService {

    @Override
    public void handle(Data data) {
        log.info("Data received --> {}", data.toString());
    }

}
