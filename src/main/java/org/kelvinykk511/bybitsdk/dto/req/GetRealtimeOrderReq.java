package org.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class GetRealtimeOrderReq {

    @NotNull
    private String category;
    private String symbol;
    private String baseCoin;
    private String settleCoin;
    private String orderId;
    private String orderLinkId;
    private Integer openOnly;
    private String orderFilter;
    private Integer limit;
    private String cursor;

}
