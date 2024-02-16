package ru.innopolis.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private String id;
    private LocalDateTime dateAdded;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User() {
    }

    public User(String id, LocalDateTime dateAdded, String login, String password,
                String confirmPassword, String lastName, String firstName,
                String patronymic, Integer age, boolean isWorker) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = patronymic;
        this.age = age;
        this.isWorker = isWorker;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isWorker() == user.isWorker() && Objects.equals(getId(), user.getId()) && Objects.equals(getDateAdded(), user.getDateAdded()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getConfirmPassword(), user.getConfirmPassword()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getMiddleName(), user.getMiddleName()) && Objects.equals(getAge(), user.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateAdded(), getLogin(), getPassword(), getConfirmPassword(), getLastName(), getFirstName(), getMiddleName(), getAge(), isWorker());
    }

    @Override
    public String toString() {
        return "Пользователь{" +
                "id='" + id + '\'' +
                ", дата добавления=" + dateAdded +
                ", логин='" + login + '\'' +
                ", пароль='" + password + '\'' +
                ", подтверждение пароля='" + confirmPassword + '\'' +
                ", фамилия='" + lastName + '\'' +
                ", имя='" + firstName + '\'' +
                ", отчество='" + middleName + '\'' +
                ", возраст=" + age +
                ", сотрудник предприятия=" + isWorker +
                '}';
    }
}
