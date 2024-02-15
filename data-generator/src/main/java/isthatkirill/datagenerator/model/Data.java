package isthatkirill.datagenerator.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Data {

    Long bankId;
    LocalDateTime timestamp;
    Long from;
    Long to;
    Double amount;
    CurrencyType currencyType;

}
