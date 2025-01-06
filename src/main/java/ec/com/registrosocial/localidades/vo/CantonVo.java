package ec.com.registrosocial.localidades.vo;

import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CantonVo {
    private String canton;
    private Map<String, String> parroquias;

    @Override
    public String toString() {
        return "CantonVo{" +
                "canton='" + canton + '\'' +
                ", parroquias=" + parroquias +
                '}';
    }
}
