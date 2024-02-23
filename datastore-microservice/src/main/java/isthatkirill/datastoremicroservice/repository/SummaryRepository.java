package isthatkirill.datastoremicroservice.repository;

import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;

import java.util.Optional;
import java.util.Set;

/**
 * @author Kirill Emelyanov
 */

public interface SummaryRepository {

    Optional<Summary> findByBankId(Long bankId, Set<CurrencyType> currencyTypes, Set<SummaryType> summaryTypes);

}
