package isthatkirill.datagenerator.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import isthatkirill.datagenerator.model.CurrencyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
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
    private CurrencyType currencyType;

}
