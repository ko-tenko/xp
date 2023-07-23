package commonapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
