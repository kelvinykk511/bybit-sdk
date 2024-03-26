package com.kelvinykk511.bybitsdk;

import com.kelvinykk511.bybitsdk.dto.req.GetRealtimeOrderReq;
import com.kelvinykk511.bybitsdk.dto.resp.CommonResp;
import com.kelvinykk511.bybitsdk.dto.resp.GetRealtimeOrderResp;
import org.junit.Test;

import java.io.IOException;

public class BybitClientTest {

    String apiKey = "1";
    String secret = "1";

    @Test
    public void test() throws IOException {

        BybitClient bybitClient = new BybitClient(apiKey, secret, true);
        GetRealtimeOrderReq req = GetRealtimeOrderReq.builder()
                .category("spot")
                .build();
        CommonResp<GetRealtimeOrderResp> realtimeOrder = bybitClient.getRealtimeOrder(req);
        System.out.println(realtimeOrder);
    }
}
