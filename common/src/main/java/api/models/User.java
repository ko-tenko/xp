package api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
