package isthatkirill.datagenerator.web.mapper;

/**
 * @author Kirill Emelyanov
 */

public interface Mappable<E, D> {

    E toEntity(D d);

    D toDto(E e);

}
