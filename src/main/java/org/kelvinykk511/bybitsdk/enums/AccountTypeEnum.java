package org.kelvinykk511.bybitsdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {

    UNIFIED("UNIFIED"),
    CONTRACT("CONTRACT"),
    ;

    private final String value;
}
