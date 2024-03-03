package ru.innopolis.phonecover;

public class Nokia3310 implements PhoneSystemLogger<Nokia3310, String, Number> {
    // TODO дополнить полями, конструкторами и т.д.
    private static final String PHONE_NAME = "телефон Nokia3310";
    public String callText() {
        return PHONE_NAME + " звонит!";
    }

    //return PHONE_NAME + ": система загружена";

    /**
     * @param phone
     * @return
     */
    @Override
    public String log(Nokia3310 phone, String keyAuth, Number dayNumber) {
        return new StringBuilder().append(PHONE_NAME)
                .append(": система загружена с ключом ")
                .append(keyAuth).append(" и номер дня недели ")
                .append(dayNumber).toString();
    }
}
