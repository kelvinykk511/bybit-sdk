package io.github.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetSpotMarginLeverageReq {

    private String leverage;
}
