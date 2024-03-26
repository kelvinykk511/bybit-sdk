package org.kelvinykk511.bybitsdk.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GetSpotBorrowCheckResp {

    private String symbol;
    private String maxTradeQty;
    private String side;
    private String spotMaxTradeAmount;
    private String maxTradeAmount;
    private String borrowCoin;
    private String spotMaxTradeQty;
}
