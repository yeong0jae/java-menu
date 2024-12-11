package menu.domain;

import java.util.List;

public class RecommendedMenu {

    private List<String> recommendedMenus;
    
    public RecommendedMenu(List<String> recommendedMenus) {
        this.recommendedMenus = recommendedMenus;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public boolean isIn(String menu) {
        return recommendedMenus.stream()
                .anyMatch(recommendedMenu -> recommendedMenu.equals(menu));
    }

    public void add(String menu) {
        recommendedMenus.add(menu);
    }
}
