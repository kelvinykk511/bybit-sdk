package org.kelvinykk511.bybitsdk.dto.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateOrderResp {

    private String orderId;
    private String orderLinkId;
}
