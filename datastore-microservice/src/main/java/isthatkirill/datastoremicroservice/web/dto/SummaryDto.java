package isthatkirill.datastoremicroservice.web.dto;

import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class SummaryDto {

    Long bankId;
    Map<CurrencyType, List<Summary.SummaryEntry>> values;



}
