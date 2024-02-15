package isthatkirill.datagenerator.web.controller;

import isthatkirill.datagenerator.model.Data;
import isthatkirill.datagenerator.model.test.DataTestOptions;
import isthatkirill.datagenerator.service.KafkaDataService;
import isthatkirill.datagenerator.service.TestDataService;
import isthatkirill.datagenerator.web.dto.DataDto;
import isthatkirill.datagenerator.web.dto.DataTestOptionsDto;
import isthatkirill.datagenerator.web.mapper.DataMapper;
import isthatkirill.datagenerator.web.mapper.DataTestOptionsMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data")
public class DataController {

    private final DataMapper dataMapper;
    private final TestDataService testDataService;
    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final KafkaDataService kafkaDataService;

    @PostMapping("/send")
    public ResponseEntity<?> send(@Valid @RequestBody DataDto dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test/send")
    public ResponseEntity<?> testSend(@Valid @RequestBody DataTestOptionsDto dataTestOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(dataTestOptionsDto);
        testDataService.sendMessages(testOptions);
        return ResponseEntity.ok().build();
    }


}
