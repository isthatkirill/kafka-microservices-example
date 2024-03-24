package isthatkirill.datastoremicroservice.service;

import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;

import java.util.Set;

/**
 * @author Kirill Emelyanov
 */

public interface SummaryService {

    Summary get(Long bankId, Set<CurrencyType> currencyTypes, Set<SummaryType> summaryTypes);

}
