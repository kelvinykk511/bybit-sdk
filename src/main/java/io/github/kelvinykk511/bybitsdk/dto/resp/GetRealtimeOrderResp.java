package io.github.kelvinykk511.bybitsdk.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetRealtimeOrderResp {


    private List<ListDTO> list;
    private String nextPageCursor;
    private String category;

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        private String orderId;
        private String orderLinkId;
        private String blockTradeId;
        private String symbol;
        private String price;
        private String qty;
        private String side;
        private String isLeverage;
        private Integer positionIdx;
        private String orderStatus;
        private String cancelType;
        private String rejectReason;
        private String avgPrice;
        private String leavesQty;
        private String leavesValue;
        private String cumExecQty;
        private String cumExecValue;
        private String cumExecFee;
        private String timeInForce;
        private String orderType;
        private String stopOrderType;
        private String orderIv;
        private String triggerPrice;
        private String takeProfit;
        private String stopLoss;
        private String tpTriggerBy;
        private String slTriggerBy;
        private Integer triggerDirection;
        private String triggerBy;
        private String lastPriceOnCreated;
        private Boolean reduceOnly;
        private Boolean closeOnTrigger;
        private String smpType;
        private Integer smpGroup;
        private String smpOrderId;
        private String tpslMode;
        private String tpLimitPrice;
        private String slLimitPrice;
        private String placeType;
        private String createdTime;
        private String updatedTime;
    }
}
