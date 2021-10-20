package codesharing.code;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @SequenceGenerator(
            name = "code_sequence",
            sequenceName = "code_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "code_sequence"
    )
    private Long id;
    private String code;
    private String date;
//    private boolean isPublic;
//    private User author;
//    private List<User> userList;   list of users allowed to see and edit the snippet, will be implemented later

    public Code(CodeDto code) {

        this.code = code.getCode();
        this.date = LocalDateTime.now().format(formatter);
    }

}
