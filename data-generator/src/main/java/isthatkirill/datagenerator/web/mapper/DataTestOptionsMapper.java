package isthatkirill.datagenerator.web.mapper;

import isthatkirill.datagenerator.model.test.DataTestOptions;
import isthatkirill.datagenerator.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

/**
 * @author Kirill Emelyanov
 */

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
