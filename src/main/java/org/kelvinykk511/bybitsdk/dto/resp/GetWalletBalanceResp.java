package org.kelvinykk511.bybitsdk.dto.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Getter
@AllArgsConstructor
public class GetWalletBalanceResp {


    private List<ListDTO> list;

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        private String totalEquity;
        private String accountIMRate;
        private String totalMarginBalance;
        private String totalInitialMargin;
        private String accountType;
        private String totalAvailableBalance;
        private String accountMMRate;
        private String totalPerpUPL;
        private String totalWalletBalance;
        private String accountLTV;
        private String totalMaintenanceMargin;
        private List<CoinDTO> coin;

    }

    @NoArgsConstructor
    @Data
    public static class CoinDTO {
        private String availableToBorrow;
        private String bonus;
        private String accruedInterest;
        private String availableToWithdraw;
        private String totalOrderIM;
        private String equity;
        private String totalPositionMM;
        private String usdValue;
        private String spotHedgingQty;
        private String unrealisedPnl;
        private Boolean collateralSwitch;
        private String borrowAmount;
        private String totalPositionIM;
        private String walletBalance;
        private String cumRealisedPnl;
        private String locked;
        private Boolean marginCollateral;
        private String coin;
    }
}
