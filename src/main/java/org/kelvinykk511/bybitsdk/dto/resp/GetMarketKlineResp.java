package org.kelvinykk511.bybitsdk.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetMarketKlineResp {


    private String symbol;
    private String category;
    private List<List<String>> list;

}
