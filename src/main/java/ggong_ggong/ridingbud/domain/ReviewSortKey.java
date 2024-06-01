package ggong_ggong.ridingbud.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ReviewSortKey {
    TIME("TIME"), RECOMMENDATION("RECOMMENDATION");

    private final String key;

    public static ReviewSortKey getKey(String key) {
        for (ReviewSortKey k : ReviewSortKey.values()) {
            if (k.getKey().equals(key)) {
                return k;
            }
        }
        return null;
    }
}
