package isthatkirill.datastoremicroservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Summary {

    Long bankId;
    Map<CurrencyType, List<SummaryEntry>> values;

    public Summary () {
        this.values = new HashMap<>();
    }

    public void addValues(CurrencyType type, SummaryEntry entry) {
        if (values.containsKey(type)) {
            List<SummaryEntry> entries = new ArrayList<>(values.get(type));
            entries.add(entry);
            values.put(type, entries);
        }
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class SummaryEntry {

        private SummaryType type;
        private Double values;

    }

}
