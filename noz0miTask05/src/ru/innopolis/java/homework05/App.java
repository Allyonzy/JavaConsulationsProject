package ru.innopolis.java.homework05;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите максимальную громкость телевизора: ");
        final int maxVolume = scan.nextInt();
        TV [] tvs = new TV [10];
        for (int i = 0; i < 10; i++) {
            TV tv = new TV();
            System.out.println("Введите название телевизора: ");
            String name = scan.next();
            tv.setName(name);
            System.out.println("Введите номер включенного канала: ");
            int current = scan.nextInt();
            tv.setCurrentChannel(current);
            System.out.println("Включён ли телевизор, введите true или false: ");
            boolean state = scan.nextBoolean();
            tv.setState(state);
            System.out.println("Введите значение громкости телевизора: ");
            int volume = scan.nextInt();
            tv.setVolume(volume);
            tvs[i] = tv;
        }

        for (TV tv:tvs) {
            if (tv.isState() && tv.getVolume() <= maxVolume)
                System.out.println(tv);
        }
        sort(tvs);

        //выбор канала телевизора
        TV channelChangeTV = tvs[3];
        chooseChannel(channelChangeTV, scan);
    }

    public static void chooseChannel(TV tv, Scanner scan) {
        int channel = -1;
        String channelChooseState = "ON";

        while(channelChooseState.equals("OFF")) {
            try {
                System.out.println("Введите номер канала в пределах " + tv.getChannels());
                channel = scan.nextInt();
                tv.chooseChannel(channel);
                System.out.println("Выбран канал номер " + tv.getCurrentChannel());
            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
            } finally {
                scan.nextLine();
                System.out.println("Продолжаем выбирать каналы? ON - да, OFF - нет");
                channelChooseState = scan.nextLine();
            }
        }
    }

    public static void sort (TV [] tvs) {
        for (TV tv:tvs) {
            System.out.println(tv);
        }
        for (int i = 0; i < 10; i++) {
            TV currentTV = tvs[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (currentTV.getCurrentChannel() < tvs[i].getCurrentChannel())
                    tvs[i+1] = tvs[i];
                else {
                    break;
                }
            }
        tvs[i+1] = currentTV;
        }
        for (TV tv:tvs) {
            System.out.println(tv);
        }
    }
}
