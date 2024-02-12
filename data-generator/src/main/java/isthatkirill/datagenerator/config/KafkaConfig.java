package isthatkirill.datagenerator.config;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    private final XML settings;

    @Bean
    public NewTopic rubTopic() {
        return TopicBuilder.name("data-rub")
                .partitions(5)
                .replicas(1)
                .config(
                        TopicConfig.RETENTION_MS_CONFIG,
                        String.valueOf(Duration.ofDays(7).toMillis())
                ).build();
    }

    @Bean
    public NewTopic usdTopic() {
        return TopicBuilder.name("data-usd")
                .partitions(5)
                .replicas(1)
                .config(
                        TopicConfig.RETENTION_MS_CONFIG,
                        String.valueOf(Duration.ofDays(7).toMillis())
                ).build();
    }

    @Bean
    public NewTopic eurTopic() {
        return TopicBuilder.name("data-eur")
                .partitions(5)
                .replicas(1)
                .config(
                        TopicConfig.RETENTION_MS_CONFIG,
                        String.valueOf(Duration.ofDays(7).toMillis())
                ).build();
    }

    @Bean
    public SenderOptions<String, Object> senderOptions() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                new TextXPath(this.settings, "//keySerializer").toString());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                new TextXPath(this.settings, "//valueSerializer").toString());
        return SenderOptions.create(props);
    }

    @Bean
    public KafkaSender<String, Object> sender() {
        return KafkaSender.create(senderOptions());
    }

}
