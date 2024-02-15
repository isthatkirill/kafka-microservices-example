package isthatkirill.datagenerator.service;

import isthatkirill.datagenerator.model.test.DataTestOptions;

/**
 * @author Kirill Emelyanov
 */

public interface TestDataService {

    void sendMessages(DataTestOptions testOptions);

}
