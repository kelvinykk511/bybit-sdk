package io.github.kelvinykk511.bybitsdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IntervalEnum {

    ONE_MINUTE("1"),
    THREE_MINUTES("3"),
    FIVE_MINUTES("5"),
    FIFTEEN_MINUTES("15"),
    THIRTY_MINUTES("30"),
    SIXTY_MINUTES("60"),
    ONE_HUNDRED_TWENTY_MINUTES("120"),
    TWO_HUNDRED_FORTY_MINUTES("240"),
    THREE_HUNDRED_SIXTY_MINUTES("360"),
    SEVEN_HUNDRED_TWENTY_MINUTES("720"),
    ONE_DAY("D"),
    ONE_WEEK("W"),
    ONE_MONTH("M"),
    ;

    private final String value;
}
