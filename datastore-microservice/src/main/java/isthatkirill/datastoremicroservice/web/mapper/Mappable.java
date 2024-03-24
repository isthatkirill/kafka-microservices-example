package isthatkirill.datastoremicroservice.web.mapper;

import java.util.List;

/**
 * @author Kirill Emelyanov
 */

public interface Mappable<E, D> {

    E toEntity(D d);

    List<E> toEntity(List<D> d);

    D toDto(E e);

    List<D> toDto(List<E> e);

}
