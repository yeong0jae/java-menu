package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    JAPANESE("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String category;
    private final List<String> menus;

    Menu(String category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public static String getCategory(int i) {
        return Arrays.stream(values())
                .filter(menu -> menu.ordinal() == i - 1)
                .findFirst()
                .get()
                .getCategory();
    }

    public static List<String> getMenusByCategory(String category) {
        return Arrays.stream(values())
                .filter(menu -> category.equals(menu.getCategory()))
                .findFirst()
                .get()
                .getMenus();
    }

    public static void isIn(List<String> forbids) {
        List<String> allMenus = new ArrayList<>();
        Arrays.stream(Menu.values())
                .forEach(menu -> {
                    allMenus.addAll(menu.getMenus());
                });

        for (String forbid : forbids) {
            if (allMenus.stream()
                    .noneMatch(menu -> menu.equals(forbid))) {
                throw new IllegalArgumentException("없는 메뉴입니다.");
            }
        }
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getCategory() {
        return category;
    }
}
