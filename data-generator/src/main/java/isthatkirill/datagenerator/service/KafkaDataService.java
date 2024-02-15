package isthatkirill.datagenerator.service;

import isthatkirill.datagenerator.model.Data;

/**
 * @author Kirill Emelyanov
 */

public interface KafkaDataService {

    void send(Data data);

}
