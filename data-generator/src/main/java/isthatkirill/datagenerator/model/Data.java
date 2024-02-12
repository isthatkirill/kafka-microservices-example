package isthatkirill.datagenerator.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Data {

    private Long bankId;
    private LocalDateTime timestamp;
    private Long from;
    private Long to;
    private Double amount;
    private CurrencyType currencyType;

}
