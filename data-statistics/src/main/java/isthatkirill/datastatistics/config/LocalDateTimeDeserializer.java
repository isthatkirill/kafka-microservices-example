package isthatkirill.datastatistics.config;

import com.google.gson.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type,
                                     JsonDeserializationContext jsonDeserializationContext) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        return LocalDateTime.of(
                jsonArray.get(0).getAsInt(),
                jsonArray.get(1).getAsInt(),
                jsonArray.get(2).getAsInt(),
                jsonArray.get(3).getAsInt(),
                jsonArray.get(4).getAsInt(),
                jsonArray.get(5).getAsInt());
    }

}
