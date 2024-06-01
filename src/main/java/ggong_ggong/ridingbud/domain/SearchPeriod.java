package ggong_ggong.ridingbud.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SearchPeriod {
    WEEK("WEEK"), MONTH("MONTH");

    private final String period;

    public static SearchPeriod getInstance(String period) {
        for (SearchPeriod p : SearchPeriod.values()) {
            if (p.period.equals(period)) {
                return p;
            }
        }
        return null;
    }
}
