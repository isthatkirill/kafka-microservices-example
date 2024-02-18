package isthatkirill.datastatistics.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @author Kirill Emelyanov
 */

@Getter
@Setter
@Entity
@Table(name = "data")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long bankId;

    @Column(name = "ts_timestamp")
    LocalDateTime timestamp;

    @Column(name = "from_address")
    Long from;

    @Column(name = "to_address")
    Long to;
    Double amount;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    CurrencyType currencyType;

}
