package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> forbiddens = new ArrayList<>();

    public Coach(String name) {
        validateLength(name);
        this.name = name;
    }

    public void addForbidden(String menu) {
        forbiddens.add(menu);
    }

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }
}
