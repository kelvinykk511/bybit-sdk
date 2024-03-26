package com.kelvinykk511.bybitsdk;

import com.kelvinykk511.bybitsdk.dto.req.RealtimeOrderReq;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

public class BybitClientTest {


    @Test
    public void test() throws IOException {
        String apiKey = "1XD0jf0MXPUq5WgYDm";
        String secret = "DmzflkK41KlxxBWksedPH3tZYv5PTi2VhzfK";

        BybitClient bybitClient = new BybitClient(apiKey, secret, true);
        RealtimeOrderReq req = RealtimeOrderReq.builder()
                .category("spot")
                .build();
        Response realtimeOrder = bybitClient.getRealtimeOrder(req);
        System.out.println(realtimeOrder.code());
        System.out.println(realtimeOrder.body().string());
    }
}
