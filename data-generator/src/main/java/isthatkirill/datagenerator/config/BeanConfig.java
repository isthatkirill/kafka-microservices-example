package isthatkirill.datagenerator.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author Kirill Emelyanov
 */

@Configuration
public class BeanConfig {

    @Bean
    @SneakyThrows
    public XML producerXML() {
        return new XMLDocument(
                getClass().getResourceAsStream("/kafka/producer.xml")
                        .readAllBytes()
        );
    }


}
