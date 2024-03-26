package com.kelvinykk511.bybitsdk;

import com.kelvinykk511.bybitsdk.constants.Constants;
import com.kelvinykk511.bybitsdk.constants.UrlConstants;
import com.kelvinykk511.bybitsdk.dto.req.GetRealtimeOrderReq;
import com.kelvinykk511.bybitsdk.dto.resp.CommonResp;
import com.kelvinykk511.bybitsdk.dto.resp.GetRealtimeOrderResp;
import com.kelvinykk511.bybitsdk.util.JsonUtil;
import com.kelvinykk511.bybitsdk.util.QueryStringUtil;
import com.kelvinykk511.bybitsdk.util.SignUtil;
import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/*
 * Bybit Client
 * used to interact with Bybit API
 *
 * params:
 * apiKey: String
 * apiSecret: String
 * isMainnet: Boolean
 */
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
    public CommonResp<GetRealtimeOrderResp> getRealtimeOrder(GetRealtimeOrderReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.REALTIME_ORDER;
        Response response = get(req, url);
        CommonResp<GetRealtimeOrderResp> result = JsonUtil.toObject(response.body().string(), CommonResp.class);
        return result;
    }

    @NotNull
    @SneakyThrows
    private Response get(GetRealtimeOrderReq req, String url) {
        // SIGN
        Long current = System.currentTimeMillis();
        // Generate query string
        String queryStr = QueryStringUtil.generateQueryString(req);
        // Sign
        String sign = SignUtil.generateSign(current, queryStr, apiKey, apiSecret, Constants.RECV_WINDOW);
        // Generate Request
        Request request = new Request.Builder()
                .url(url + "?" + queryStr)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-BAPI-TIMESTAMP", current.toString())
                .addHeader("X-BAPI-RECV-WINDOW", Constants.RECV_WINDOW)
                .addHeader("X-BAPI-SIGN", sign)
                .addHeader("X-BAPI-API-KEY", apiKey)
                .build();
        Response response = httpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Request failed: " + response.body().string() + "code: " + response.code());
        }
        return response;
    }
}
