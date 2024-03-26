package org.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class GetSpotBorrowCheckReq {
    @NotNull
    private String category = "spot";
    @NotNull
    private String symbol;
    @NotNull
    private String side;
}
