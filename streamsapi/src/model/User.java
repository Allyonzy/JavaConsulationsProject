package model;

import java.util.Objects;
import java.util.StringJoiner;

public class User {
    private Integer id;
    private String logName;
    private String avatarColor;
    private Integer age;
    private Boolean isActive;

    public User() {
    }

    public User(Integer id, String logName, String avatarColor, Integer age, Boolean isActive) {
        this.id = id;
        this.logName = logName;
        this.avatarColor = avatarColor;
        this.age = age;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(String avatarColor) {
        this.avatarColor = avatarColor;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getLogName(), user.getLogName()) && Objects.equals(getAvatarColor(), user.getAvatarColor()) && Objects.equals(getAge(), user.getAge()) && Objects.equals(isActive, user.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogName(), getAvatarColor(), getAge(), isActive);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("logName='" + logName + "'")
                .add("avatarColor='" + avatarColor + "'")
                .add("age=" + age)
                .add("isActive=" + isActive)
                .toString();
    }
}
