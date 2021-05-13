package miniproject.book_management.dto;

import java.sql.Date;

public class MemberDto {
    private Long id;
    private String name;
    private String username;

    // form 에서 넘겨서 param.checkpw 로 받아오기.
    // 저장할 필요 없이 체크하고 버리면 됨.
    // 할거면 boolean checkPw(String otherPw) 같은 메소드로 만들기.
    private String checkpw;
    private String password;
    private Date birthday;

    public MemberDto() {
    }

    public MemberDto(String name, String username, String password, Date birthday) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public void setBirthdayFromString(String year, String month, String day) {
        this.birthday = Date.valueOf(year + "-" + month + "-" + day);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckpw() {
        return checkpw;
    }

    public void setCheckpw(String checkpw) {
        this.checkpw = checkpw;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
