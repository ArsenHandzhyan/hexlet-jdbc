package hexlet.code;

public class User {
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    private Long id;
    private final String name;
    private final String phone;
}
