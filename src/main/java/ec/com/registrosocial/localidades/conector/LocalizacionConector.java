package ec.com.registrosocial.localidades.conector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.registrosocial.localidades.vo.ProvinciaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Clase para implementar la llamada a apis externas al proyecto.
 * @author Richard Alba;
 */
@Service
public class LocalizacionConector implements ILocalizacionConector {
    @Autowired
    private final RestTemplate restTemplate;

    private static final String API_URL = "https://gist.githubusercontent.com/emamut/6626d3dff58598b624a1/raw/166183f4520c4603987c55498df8d2983703c316/provincias.json";

    public LocalizacionConector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, ProvinciaVo> getProvinciasData() {
        try {
            String response = restTemplate.getForObject(API_URL, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(response, new TypeReference<Map<String, ProvinciaVo>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al procesar la respuesta de la API externa.", e);
        }
    }
}
