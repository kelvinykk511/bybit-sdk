package io.github.kelvinykk511.bybitsdk.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateOrderBatchResp {


    private List<CreateOrderBatchRespDTO> list;

    @Data
    @Builder
    public static class CreateOrderBatchRespDTO {
        private String category;
        private String symbol;
        private String orderId;
        private String orderLinkId;
        private String createAt;
    }
}
