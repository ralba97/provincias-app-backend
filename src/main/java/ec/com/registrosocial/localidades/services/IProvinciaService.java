package ec.com.registrosocial.localidades.services;

import ec.com.registrosocial.localidades.vo.LocalidadVo;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Interface para administrar servicios de tipo localidad (provincia, canton, parroquia).
 * @author Richard Alba;
 */
@Service
public interface IProvinciaService {

    /**
     * Obtiene un listado de provincias.
     * @return {@link List<LocalidadVo>}.
     */
    List<LocalidadVo> obtenerProvincias() ;

    /**
     * Obtiene un listado de cantones por provincia.
     * @return {@link List<LocalidadVo>}.
     */
    List<LocalidadVo> obtenerCantonesPorProvincia(String provincia) ;

    /**
     * Obtiene un listado de parroquias por canton.
     * @return {@link List<LocalidadVo>}.
     */
    // Método para obtener parroquias por cantón
    List<LocalidadVo> obtenerParroquiasPorCanton(String canton);
}
