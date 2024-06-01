package ggong_ggong.ridingbud.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SearchKey {
    RATE("RATE"), RECOMMENDATION("RECOMMENDATION");

    private final String key;

    public static SearchKey getInstance(String key) {
        for (SearchKey k : SearchKey.values()) {
            if (k.key.equals(key)) {
                return k;
            }
        }
        return null;
    }
}
