package com.kelvinykk511.bybitsdk;

import com.kelvinykk511.bybitsdk.constants.Constants;
import com.kelvinykk511.bybitsdk.constants.UrlConstants;
import com.kelvinykk511.bybitsdk.dto.req.RealtimeOrderReq;
import com.kelvinykk511.bybitsdk.util.QueryStringUtil;
import com.kelvinykk511.bybitsdk.util.SignUtil;
import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Data
public class BybitClient {

    public BybitClient(String apiKey, String apiSecret, Boolean isMainnet) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.baseUrl = isMainnet ? UrlConstants.MAINNET_URL : UrlConstants.TESTNET_URL;
    }

    private final String apiKey;
    private final String apiSecret;
    private final String baseUrl;

    private OkHttpClient httpClient = new OkHttpClient();

    @SneakyThrows
    public Response getRealtimeOrder(RealtimeOrderReq req) {
        String url = baseUrl + UrlConstants.REALTIME_ORDER;
        System.out.println(url);
        // SIGN
        Long current = System.currentTimeMillis();
        // Generate query string
        String queryStr = QueryStringUtil.generateQueryString(req);
        System.out.println(queryStr);
        String sign = SignUtil.generateSign(current, queryStr, apiKey, apiSecret, Constants.RECV_WINDOW);
        // Call Api
        Request request = new Request.Builder()
                .url(url + "?" + queryStr)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-BAPI-TIMESTAMP", current.toString())
                .addHeader("X-BAPI-RECV-WINDOW", Constants.RECV_WINDOW)
                .addHeader("X-BAPI-SIGN", sign)
                .addHeader("X-BAPI-API-KEY", apiKey)
                .build();
        return httpClient.newCall(request).execute();
    }
}
