package ggong_ggong.ridingbud.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ReviewSortKey {
    TIME("TIME"), RECOMMENDATION("RECOMMENDATION");

    private final String key;

    public static ReviewSortKey getInstance(String key) {
        for (ReviewSortKey k : ReviewSortKey.values()) {
            if (k.key.equals(key)) {
                return k;
            }
        }
        return null;
    }
}
