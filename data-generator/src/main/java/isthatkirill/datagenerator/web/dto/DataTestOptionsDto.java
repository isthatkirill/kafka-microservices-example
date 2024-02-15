package isthatkirill.datagenerator.web.dto;

import isthatkirill.datagenerator.model.CurrencyType;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author Kirill Emelyanov
 */

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataTestOptionsDto {

    @Positive
    Integer delay;
    CurrencyType[] currencyTypes;

}
