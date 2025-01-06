package ec.com.registrosocial.localidades.vo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParroquiaVo {
    private String codigo;
    private String nombre;

    @Override
    public String toString() {
        return "ParroquiaVo{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
