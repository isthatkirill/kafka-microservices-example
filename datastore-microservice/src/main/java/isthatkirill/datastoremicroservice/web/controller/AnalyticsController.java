package isthatkirill.datastoremicroservice.web.controller;

import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;
import isthatkirill.datastoremicroservice.service.SummaryService;
import isthatkirill.datastoremicroservice.web.dto.SummaryDto;
import isthatkirill.datastoremicroservice.web.mapper.SummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Kirill Emelyanov
 */

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final SummaryService summaryService;
    private final SummaryMapper summaryMapper;


    @GetMapping("/summary/{bankId}")
    public SummaryDto getSummary(@PathVariable Long bankId,
                                 @RequestParam(value = "ct", required = false) Set<CurrencyType> currencyTypes,
                                 @RequestParam(value = "st", required = false) Set<SummaryType> summaryTypes) {
        Summary summary = summaryService.get(bankId, currencyTypes, summaryTypes);
        return summaryMapper.toDto(summary);
    }

}
