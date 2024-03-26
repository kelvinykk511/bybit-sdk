package org.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class GetMarketOrderBookReq {
    @NotNull
    private String category;
    @NotNull
    private String symbol;
    private Integer limit;
}
