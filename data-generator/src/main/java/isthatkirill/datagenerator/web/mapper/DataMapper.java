package isthatkirill.datagenerator.web.mapper;

import isthatkirill.datagenerator.model.Data;
import isthatkirill.datagenerator.web.dto.DataDto;
import org.mapstruct.Mapper;

/**
 * @author Kirill Emelyanov
 */

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
