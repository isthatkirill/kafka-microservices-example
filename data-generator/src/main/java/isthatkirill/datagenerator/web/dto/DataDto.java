package isthatkirill.datagenerator.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import isthatkirill.datagenerator.model.CurrencyType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataDto {

    @NotNull
    private Long bankId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private Long from;

    @NotNull
    private Long to;

    @Positive
    private Double amount;

    @NotNull
    //TODO VALID ENUM
    private CurrencyType currencyType;

}
