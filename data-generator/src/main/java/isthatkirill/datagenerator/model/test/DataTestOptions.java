package isthatkirill.datagenerator.model.test;

import isthatkirill.datagenerator.model.CurrencyType;
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
public class DataTestOptions {

    Integer delay;
    CurrencyType[] currencyTypes;

}
