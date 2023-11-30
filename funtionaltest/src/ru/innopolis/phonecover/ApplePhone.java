package ru.innopolis.phonecover;

import java.time.LocalDateTime;

public class ApplePhone implements PhoneSystemLogger<ApplePhone, Long, LocalDateTime> {
    // TODO дополнить полями, конструкторами и т.д.
    private static final String PHONE_NAME = "телефон iPhone";
    public String callText() {
        return PHONE_NAME + " звонит!";
    }
    public String callPhotoText() {
        return PHONE_NAME + " фотографирует!";
    }

    @Override
    public String log(ApplePhone phone, Long keyAuth, LocalDateTime localDateTime) {
        return new StringBuilder().append(PHONE_NAME)
                .append(": система загружена с ключом ")
                .append(keyAuth).append(" и номер дня недели ")
                .append(localDateTime.now()).toString();
    }
}
