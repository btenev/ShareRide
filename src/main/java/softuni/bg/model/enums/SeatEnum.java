package softuni.bg.model.enums;

public enum SeatEnum {
    Zero(0),
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8);
    final int value;
    SeatEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
