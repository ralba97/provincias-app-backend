package ec.com.registrosocial.localidades.vo;

import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProvinciaVo {
    private String provincia;
    private Map<String, CantonVo> cantones;

    @Override
    public String toString() {
        return "ProvinciaVo{" +
                "provincia='" + provincia + '\'' +
                ", cantones=" + cantones +
                '}';
    }
}
