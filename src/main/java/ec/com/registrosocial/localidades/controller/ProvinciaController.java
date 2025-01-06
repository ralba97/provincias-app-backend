package ec.com.registrosocial.localidades.controller;

import ec.com.registrosocial.localidades.services.IProvinciaService;
import ec.com.registrosocial.localidades.vo.RespuestaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase para administrar apis de tipo localidad (provincia, canton, parroquia).
 * @author Richard Alba;
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProvinciaController {

    @Lazy
    @Autowired
    private final IProvinciaService provinciaService;

    public ProvinciaController(IProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    /**
     * Servicio para obtener un listado de provincias.
     * @return {@link ResponseEntity< RespuestaVo >}.
     */
    @GetMapping("/provincias")
    public ResponseEntity<RespuestaVo> getProvinciasIdNombre() {
        try {
            return ResponseEntity.ok(RespuestaVo.builder().data(provinciaService.obtenerProvincias()).codigo(HttpStatus.OK.value()).build());
        }catch (Exception exception){
            return ResponseEntity.ok(RespuestaVo.builder().mensaje(exception.getMessage()).codigo(HttpStatus.OK.value()).build());
        }
    }

    /**
     * Servicio para obtener un listado de cantones por provincia.
     * @return {@link ResponseEntity<RespuestaVo>}.
     */
    @GetMapping("/cantones")
    public ResponseEntity<RespuestaVo> obtenerCantonesPorProvincia(@RequestParam String provincia) {
        try {
            return ResponseEntity.ok(RespuestaVo.builder()
                    .data(provinciaService.obtenerCantonesPorProvincia(provincia)).codigo(HttpStatus.OK.value()).build());
        }catch (Exception exception){
            return ResponseEntity.ok(RespuestaVo.builder().mensaje(exception.getMessage()).codigo(HttpStatus.OK.value()).build());
        }
    }

    /**
     * Servicio para obtener un listado de parroquias por canton.
     * @return {@link ResponseEntity<RespuestaVo>}.
     */
    @GetMapping("/parroquias")
    public ResponseEntity<RespuestaVo> obtenerParroquiasPorCanton(@RequestParam String canton) {
        try {
            return ResponseEntity.ok(RespuestaVo.builder()
                    .data(provinciaService.obtenerParroquiasPorCanton(canton)).codigo(HttpStatus.OK.value()).build());
        }catch (Exception exception){
            return ResponseEntity.ok(RespuestaVo.builder().mensaje(exception.getMessage()).codigo(HttpStatus.OK.value()).build());
        }
    }
}
