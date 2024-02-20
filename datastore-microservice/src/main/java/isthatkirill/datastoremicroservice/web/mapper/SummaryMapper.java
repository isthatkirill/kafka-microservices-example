package isthatkirill.datastoremicroservice.web.mapper;

import isthatkirill.datastoremicroservice.model.Summary;
import isthatkirill.datastoremicroservice.web.dto.SummaryDto;
import org.mapstruct.Mapper;

/**
 * @author Kirill Emelyanov
 */

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {

}
