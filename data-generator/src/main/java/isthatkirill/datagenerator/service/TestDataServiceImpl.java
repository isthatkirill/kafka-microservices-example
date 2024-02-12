package isthatkirill.datagenerator.service;

import isthatkirill.datagenerator.model.CurrencyType;
import isthatkirill.datagenerator.model.Data;
import isthatkirill.datagenerator.model.test.DataTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.getCurrencyTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = Data.builder()
                                .bankId(getRandomInteger(1L, 10L))
                                .amount(getRandomDecimal(1.0, 1000.0))
                                .currencyType(getRandomCurrencyType(testOptions.getCurrencyTypes()))
                                .from(getRandomInteger(1000_0000_0000_0000L, 9999_9999_9999_9999L))
                                .to(getRandomInteger(1000_0000_0000_0000L, 9999_9999_9999_9999L))
                                .timestamp(LocalDateTime.now())
                                .build();
                        
                        kafkaDataService.send(data);
                    },
                    0,
                    testOptions.getDelay(),
                    TimeUnit.SECONDS
                    );
        }
    }

    private CurrencyType getRandomCurrencyType(CurrencyType[] currencyTypes) {
        int randomIndex = (int) (Math.random() * currencyTypes.length);
        return currencyTypes[randomIndex];
    }

    private Long getRandomInteger(Long min, Long max) {
        return Math.round(getRandomDecimal(Double.valueOf(min), Double.valueOf(max)));
    }

    private Double getRandomDecimal(Double min, Double max) {
        return (Math.random() * (max - min)) + min;
    }

}
