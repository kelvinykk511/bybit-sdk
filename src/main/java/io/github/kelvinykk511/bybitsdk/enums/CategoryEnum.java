package io.github.kelvinykk511.bybitsdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryEnum {

    SPOT("spot"),
    LINEAR("linear"),
    INVERSE("inverse"),
    OPTION("option");

    private final String value;
}
