package menu.domain;

public enum Day {
    MON("월요일", 0),
    TUE("화요일", 1),
    WEN("수요일", 2),
    THU("목요일", 3),
    FRI("금요일", 4);

    private final String day;
    private final int index;

    Day(String day, int index) {
        this.day = day;
        this.index = index;
    }
}
