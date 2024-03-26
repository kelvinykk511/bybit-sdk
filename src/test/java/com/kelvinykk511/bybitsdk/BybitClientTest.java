package com.kelvinykk511.bybitsdk;

import com.kelvinykk511.bybitsdk.dto.req.RealtimeOrderReq;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

public class BybitClientTest {


    @Test
    public void test() throws IOException {
        String apiKey = "1";
        String secret = "1";

        BybitClient bybitClient = new BybitClient(apiKey, secret, true);
        RealtimeOrderReq req = RealtimeOrderReq.builder()
                .category("spot")
                .build();
        Response realtimeOrder = bybitClient.getRealtimeOrder(req);
        System.out.println(realtimeOrder.code());
        System.out.println(realtimeOrder.body().string());
    }
}
