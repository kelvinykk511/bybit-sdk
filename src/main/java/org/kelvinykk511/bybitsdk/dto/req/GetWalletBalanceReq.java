package org.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class GetWalletBalanceReq {
    @NotNull
    private String accountType;
    private String coin;
}
