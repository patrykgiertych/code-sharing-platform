package codesharing.Code;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "snippets")
public class Code {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Id
    private String id;
    private String code;
    private String date;
//    private boolean isPublic;
//    private User author;
//    private List<User> userList;   list of users allowed to see and edit the snippet, will be implemented later

    public Code() {}

    public Code(CodeDto code) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.code = code.getCode();
        this.date = LocalDateTime.now().format(formatter);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
}
