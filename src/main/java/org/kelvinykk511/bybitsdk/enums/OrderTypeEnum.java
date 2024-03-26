package org.kelvinykk511.bybitsdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderTypeEnum {

    MARKET("Market"),
    LIMIT("Limit");

    private final String value;

}
