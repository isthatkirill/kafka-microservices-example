package isthatkirill.datagenerator.web.controller;

import isthatkirill.datagenerator.model.Data;
import isthatkirill.datagenerator.service.KafkaDataService;
import isthatkirill.datagenerator.web.dto.DataDto;
import isthatkirill.datagenerator.web.mapper.DataMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kirill Emelyanov
 */

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

    private final DataMapper dataMapper;
    private final KafkaDataService kafkaDataService;

    @PostMapping("/send")
    public ResponseEntity<?> send(@Valid @RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
        return ResponseEntity.ok().build();
    }


}
