package menu.view;

import java.util.List;
import menu.domain.coach.Coach;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(List<Coach> coaches, List<String> recommendedCategory) {
        printDays();
        printCategoriesResult(recommendedCategory);
        printCoachesResult(coaches);
        printEndMessage();
    }

    private void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    private void printCategoriesResult(List<String> recommendedCategory) {
        System.out.print("[ 카테고리 ");
        for (int i = 0; i < 5; i++) {
            System.out.print("| " + recommendedCategory.get(i) + " ");
        }
        System.out.println("]");
    }

    private void printCoachesResult(List<Coach> coaches) {
        coaches.forEach(coach -> {
            System.out.print("[ " + coach.getName() + " ");
            coach.getRecommendedMenu().forEach(menu -> {
                System.out.print("| " + menu + " ");
            });
            System.out.println("]");
        });
    }

    private void printDays() {
        System.out.println("[ 구분 | " + "월요일" + " | " + "화요일" + " | " + "수요일" + " | " + "목요일" + " | " + "금요일" + " ]");
    }
}
