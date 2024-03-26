package com.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RealtimeOrderReq {

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
