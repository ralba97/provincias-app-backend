package ec.com.registrosocial.localidades.vo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespuestaVo<T> {
    private Integer codigo;
    private String mensaje;
    private T data;

}
