package ru.innopolis.phonecover;

public class App {

    public static void main(String[] args) {
        CoverByObject cover = new CoverByObject();
        Nokia3310 nokia3310 = new Nokia3310();
        ApplePhone applePhone = new ApplePhone();

        cover.setPhone(nokia3310);
        cover.setPhone(applePhone);

        cover.setPhone(nokia3310);

        Nokia3310 nokiaFromCover = (Nokia3310) cover.getPhone();
        System.out.println(nokiaFromCover.callText());
        nokiaFromCover.callText();

        cover.setPhone(applePhone);

        ApplePhone applePhoneFromCover = (ApplePhone) cover.getPhone();

        System.out.println(applePhoneFromCover.callPhotoText());
    }
}
