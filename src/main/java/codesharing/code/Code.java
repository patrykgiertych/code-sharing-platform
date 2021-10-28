package codesharing.code;

import codesharing.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "snippets")
@NoArgsConstructor
@Getter
@Setter
public class Code {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String date;

    @JsonIgnore
    @ManyToMany(mappedBy = "codeList")
    private List<User> allowedUsers;

    public Code(CodeDto code) {
        this.code = code.getCode();
        this.date = LocalDateTime.now().format(formatter);
    }
}
