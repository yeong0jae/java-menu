package menu.domain.coach;

import java.util.List;

public class ForbiddenMenu {

    private final List<String> forbiddens;

    public ForbiddenMenu(List<String> forbiddens) {
        validateLength(forbiddens);
        this.forbiddens = forbiddens;
    }

    private void validateLength(List<String> forbiddens) {
        if (forbiddens.size() > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개입니다.");
        }
    }

    public List<String> getForbiddens() {
        return forbiddens;
    }

    public boolean isIn(String menu) {
        return forbiddens.stream()
                .anyMatch(forbidden -> forbidden.equals(menu));
    }
}
