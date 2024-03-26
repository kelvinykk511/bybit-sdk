package org.kelvinykk511.bybitsdk.dto.req;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class GetMarketKlineReq {

    private String category;
    @NotNull
    private String symbol;
    @NotNull
    private String interval;
    private Integer start;
    private Integer end;
    private Integer limit;

}
