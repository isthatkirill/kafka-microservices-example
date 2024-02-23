package isthatkirill.datastoremicroservice.service;

import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;
import isthatkirill.datastoremicroservice.model.exception.BankNotFoundException;
import isthatkirill.datastoremicroservice.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(Long bankId, Set<CurrencyType> currencyTypes, Set<SummaryType> summaryTypes) {
        return summaryRepository.findByBankId(
                bankId,
                currencyTypes == null ? Set.of(CurrencyType.values()) : currencyTypes,
                summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes
        ).orElseThrow(BankNotFoundException::new);
    }

}
