package isthatkirill.datastoremicroservice.repository;

import isthatkirill.datastoremicroservice.config.RedisSchema;
import isthatkirill.datastoremicroservice.model.CurrencyType;
import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.model.SummaryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;
import java.util.Set;

/**
 * @author Kirill Emelyanov
 */

@Repository
@RequiredArgsConstructor
public class SummaryRepositoryImpl implements SummaryRepository {

    private final JedisPool jedisPool;

    @Override
    public Optional<Summary> findByBankId(Long bankId, Set<CurrencyType> currencyTypes, Set<SummaryType> summaryTypes) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!jedis.sismember(RedisSchema.bankKeys(), String.valueOf(bankId))) {
                return Optional.empty();
            }
            if (currencyTypes.isEmpty() && !summaryTypes.isEmpty()) {
                return getSummary(bankId, Set.of(CurrencyType.values()), summaryTypes, jedis);
            } else if (!currencyTypes.isEmpty() && summaryTypes.isEmpty()) {
                return getSummary(bankId, currencyTypes, Set.of(SummaryType.values()), jedis);
            } else {
                return getSummary(bankId, currencyTypes, summaryTypes, jedis);
            }
        }
    }

    private Optional<Summary> getSummary(Long bankId, Set<CurrencyType> currencyTypes,
                                         Set<SummaryType> summaryTypes, Jedis jedis) {
        Summary summary = new Summary();
        summary.setBankId(bankId);
        for (CurrencyType cType : currencyTypes) {
            for (SummaryType sType: summaryTypes) {
                Summary.SummaryEntry entry = new Summary.SummaryEntry();
                entry.setType(sType);
                String value = jedis.hget(RedisSchema.summaryKey(bankId, cType), sType.name().toLowerCase());
                if (value != null) {
                    entry.setValue(Double.parseDouble(value));
                }
                summary.addValue(cType, entry);
            }
        }
        return Optional.of(summary);
    }

}
