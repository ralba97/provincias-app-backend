package ec.com.registrosocial.localidades.conector;

import ec.com.registrosocial.localidades.vo.ProvinciaVo;
import org.springframework.stereotype.Service;

/**
 * Interfaz para hacer llamada a apis externas al proyecto.
 * @author Richard Alba;
 */
import java.util.Map;

@Service
public interface ILocalizacionConector {

    /**
     * Metodo para obtener la data de una localidad (provincia, canton, parroquia).
     * @return
     */
    Map<String, ProvinciaVo> getProvinciasData();
}
