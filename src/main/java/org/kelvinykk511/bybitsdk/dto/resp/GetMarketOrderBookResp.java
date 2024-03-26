package org.kelvinykk511.bybitsdk.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetMarketOrderBookResp {

    private String s;
    private List<List<String>> b;
    private List<List<String>> a;
    private Long ts;
    private Integer u;
    private Long seq;
}
