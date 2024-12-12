package menu.domain.coach;

import java.util.List;
import menu.domain.recommendation.RecommendedMenu;

public class Coach {

    private final String name;
    private ForbiddenMenu forbiddenMenu;
    private final RecommendedMenu recommendedMenu;

    public Coach(String name) {
        validateLength(name);
        this.name = name;
        this.recommendedMenu = new RecommendedMenu();
    }

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }

    public List<String> getRecommendedMenu() {
        return recommendedMenu.getRecommendedMenus();
    }

    public String getName() {
        return name;
    }

    public void createForbiddenMenu(List<String> menus) {
        this.forbiddenMenu = new ForbiddenMenu(menus);
    }

    public boolean isRecommendable(String menu) {
        return !forbiddenMenu.isIn(menu) && !recommendedMenu.isIn(menu);
    }

    public void addRecommendMenu(String menu) {
        recommendedMenu.add(menu);
    }
}
