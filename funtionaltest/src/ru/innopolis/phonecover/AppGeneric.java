package ru.innopolis.phonecover;

public class AppGeneric {
    public static void main(String[] args) {
        CoverByGeneric<Nokia3310> nokia3310CoverByGeneric = new CoverByGeneric<>();
        CoverByGeneric<ApplePhone> applePhoneCoverByGeneric = new CoverByGeneric<>();

        Nokia3310 nokia3310 = new Nokia3310();
        ApplePhone applePhone = new ApplePhone();

        nokia3310CoverByGeneric.setPhone(nokia3310);
        applePhoneCoverByGeneric.setPhone(applePhone);

        Nokia3310 nokiaFromCover = nokia3310CoverByGeneric.getPhone();
        System.out.println(nokiaFromCover.callText());

        ApplePhone applePhoneFromCover = applePhoneCoverByGeneric.getPhone();

        System.out.println(applePhoneFromCover.callPhotoText());
    }
}
