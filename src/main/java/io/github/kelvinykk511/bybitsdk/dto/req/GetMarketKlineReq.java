package io.github.kelvinykk511.bybitsdk.dto.req;

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
    private Long start;
    private Long end;
    private Integer limit;

}
