package isthatkirill.datastoremicroservice.config;

import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author Kirill Emelyanov
 */

public class KeyHelper {

    private static final String defaultPrefix = "app";
    private static String prefix = null;

    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }

    public static String getKey(String key) {
        return getPrefix() + ":" + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(prefix, defaultPrefix);
    }

}
