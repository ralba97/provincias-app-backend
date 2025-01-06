package ec.com.registrosocial.localidades.services;

import ec.com.registrosocial.localidades.conector.LocalizacionConector;
import ec.com.registrosocial.localidades.vo.CantonVo;
import ec.com.registrosocial.localidades.vo.LocalidadVo;
import ec.com.registrosocial.localidades.vo.ProvinciaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase para implementar servicios de tipo localidad (provincia, canton, parroquia).
 * @author Richard Alba;
 */
@Service
public class ProvinciaService implements  IProvinciaService {
    @Autowired
    private final LocalizacionConector localizacionConector;

    public ProvinciaService(LocalizacionConector localizacionConector) {
        this.localizacionConector = localizacionConector;
    }

    /**
     * {@inheritDoc}
     */
    public List<LocalidadVo> obtenerProvincias() {
        try {
            Map<String, ProvinciaVo> dataMap = localizacionConector.getProvinciasData();
            // Transformar el mapa en una lista
            List<LocalidadVo> provincias = dataMap.entrySet().stream()
                    .map(entry -> new LocalidadVo(entry.getKey(), entry.getValue().getProvincia()))
                    .collect(Collectors.toList());
            return provincias.stream().filter(obj-> obj.getNombre() != null).collect(Collectors.toList());
        }catch (Exception exception){
            throw new RuntimeException("Error al obtener el listado de provincias.");
        }

    }

    /**
     * {@inheritDoc}
     */
    public List<LocalidadVo> obtenerCantonesPorProvincia(String provincia) {
        try {
            Map<String, ProvinciaVo> dataMap = localizacionConector.getProvinciasData();
            if(dataMap.isEmpty()){
                return new ArrayList<>();
            }
            List<LocalidadVo> cantonList = new ArrayList<>();
            for(Map.Entry<String, CantonVo> entry: dataMap.get(provincia).getCantones().entrySet()){
                LocalidadVo canton = LocalidadVo.builder().build();
                canton.setId(entry.getKey());
                canton.setNombre(entry.getValue().getCanton());
                cantonList.add(canton);
            }
            return cantonList;
        }catch (Exception exception){
            throw new RuntimeException("Error al obtener los cantones de la provincia seleccionada.");
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<LocalidadVo> obtenerParroquiasPorCanton(String canton) {
         try {
            Map<String, ProvinciaVo> dataMap = localizacionConector.getProvinciasData();
            if(dataMap.isEmpty()){
                return new ArrayList<>();
            }
            List<LocalidadVo> parroquiaList = new ArrayList<>();
            for (ProvinciaVo provincia : dataMap.values()) {
                if (provincia.getCantones().containsKey(canton)) {
                    for(Map.Entry<String, String> entry: provincia.getCantones().get(canton).getParroquias().entrySet()){
                        LocalidadVo parroquia = LocalidadVo.builder().build();
                        parroquia.setId(entry.getKey());
                        parroquia.setNombre(entry.getValue());
                        parroquiaList.add(parroquia);
                    }
                }
            }
            return parroquiaList;
        }catch (Exception exception){
            throw new RuntimeException("Error al obtener las parroquias del caton seleccionado.");
        }
    }
}
