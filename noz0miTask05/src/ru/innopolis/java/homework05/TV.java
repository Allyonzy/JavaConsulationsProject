package ru.innopolis.java.homework05;

import java.util.Objects;

public class TV {
    private String name;
    private int channels;
    private double screen_size;
    private int id;
    private boolean state;
    private int currentChannel;
    private int volume;

    //конструктор
    public TV() {

    }

    //геттеры и сеттеры
    public String getName() { return name;}
    public void setName(String name) {this.name = name;}
    public int getChannels() { return channels;}

    public void setChannels(int channels) { this.channels = channels;}

    public double getScreen_size() { return screen_size;}

    public void setScreen_size(double screen_size) { this.screen_size = screen_size;}

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}
    public void setState (boolean state) {this.state = state;}
    public boolean isState() {
        return state;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Меняет состояние телевизора со включенного на выключенный и наоборот
    public boolean changeState(boolean state) {
        if (this.state == state) {
            this.state = !state;
        }
        System.out.println("Состояние телевизора " + this.name + " на данный момент: " + this.state);
        return this.state;
    }

    // Включает выбранный канал
    public void chooseChannel(int channel) throws RuntimeException {
        if (!this.state) {
            changeState(this.state);
            throw new RuntimeException("Телевизор выключен, нужно сначала включить, чтобы выбрать канал, включаю телевизор...");
        }
        if (channel > this.channels || channel < 1) {
            throw new RuntimeException("Такого канала нет, выберите другой");
        } else {
            this.setCurrentChannel(channel);
        }
    }

    @Override
    public String toString() {
        return "Телевизор с параметрами:\n" +
                this.name + " - Наименование\n" +
                this.channels + " - Количество каналов\n" +
                this.screen_size + " - Диагональ экрана\n" +
                this.id + " - Серийный номер\n" +
                this.state + " - Состояние (включён - true, выключен - false) \n" +
                this.volume + " - Громкость телевизора \n" +
                this.currentChannel + " - Включенный канал";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return channels == tv.channels && Double.compare(tv.screen_size, screen_size) == 0 &&
                id == tv.id && state == tv.state && currentChannel == tv.currentChannel &&
                volume == tv.volume && Objects.equals(name, tv.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, channels, screen_size, id, state, currentChannel, volume);
    }
}
