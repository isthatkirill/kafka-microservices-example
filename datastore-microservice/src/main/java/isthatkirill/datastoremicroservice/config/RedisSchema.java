package isthatkirill.datastoremicroservice.config;

import isthatkirill.datastoremicroservice.model.CurrencyType;

/**
 * @author Kirill Emelyanov
 */

public class RedisSchema {

    public static String bankKeys() {
        return KeyHelper.getKey("banks");
    }

    public static String summaryKey(Long bankId, CurrencyType currencyType) {
        return KeyHelper.getKey("banks:" + bankId + ":" + currencyType.name().toLowerCase());
    }


}
