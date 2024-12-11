package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("랜덤 메뉴를 가져온다.")
    @Test
    void MenuTest() {
        String category1 = Menu.getCategory(0);

        Assertions.assertThat(category1).isEqualTo("일식");
    }
}
