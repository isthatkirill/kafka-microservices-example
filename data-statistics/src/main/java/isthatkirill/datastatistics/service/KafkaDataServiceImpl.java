package isthatkirill.datastatistics.service;

import isthatkirill.datastatistics.model.Data;
import isthatkirill.datastatistics.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final DataRepository dataRepository;

    @Override
    public void handle(Data data) {
        log.info("Data received --> {}", data);
        dataRepository.save(data);
    }

}
