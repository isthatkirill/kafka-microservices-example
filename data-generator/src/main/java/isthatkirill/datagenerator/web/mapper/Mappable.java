package isthatkirill.datagenerator.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Kirill Emelyanov
 */

public interface Mappable<E, D> {

    E toEntity(D d);

    D toDto(E e);

}
