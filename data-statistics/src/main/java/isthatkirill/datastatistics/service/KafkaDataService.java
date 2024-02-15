package isthatkirill.datastatistics.service;

import isthatkirill.datastatistics.model.Data;

/**
 * @author Kirill Emelyanov
 */

public interface KafkaDataService {

    void handle(Data data);

}
