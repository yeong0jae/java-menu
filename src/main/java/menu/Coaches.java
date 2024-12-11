package menu;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private List<Coach> coaches;

    public Coaches(List<String> coaches) {
        validateSize(coaches);
        this.coaches = coaches.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private void validateSize(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 한다.");
        }
    }

    public int getSize() {
        return coaches.size();
    }

    public void addForbiddenMenu(int i, ForbiddenMenu forbiddenMenu) {
        forbiddenMenu.getForbiddens().forEach(
                inputForbidden -> coaches.get(i).addForbidden(inputForbidden)
        );
    }

    public String getCoachName(int i) {
        return coaches.get(i).getName();
    }
}
