package io.github.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class CreateOrderReq {
    @NotNull
    private String category;
    @NotNull
    private String symbol;
    private Integer isLeverage;
    @NotNull
    private String side;
    @NotNull
    private String orderType;
    @NotNull
    private String qty;
    private String marketUnit;
    private String price;
    private Integer triggerDirection;
    private String orderFilter;
    private String triggerPrice;
    private String triggerBy;
    private String orderIv;
    private String timeInForce;
    private Integer positionIdx;
    private String orderLinkId;
    private String takeProfit;
    private String stopLoss;
    private String tpTriggerBy;
    private String slTriggerBy;
    private Boolean reduceOnly;
    private Boolean closeOnTrigger;
    private String smpType;
    private Boolean mmp;
    private String tpslMode;
    private String tpLimitPrice;
    private String slLimitPrice;
    private String tpOrderType;
    private String slOrderType;
}
