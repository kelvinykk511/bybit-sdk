package io.github.kelvinykk511.bybitsdk;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.kelvinykk511.bybitsdk.constants.Constants;
import io.github.kelvinykk511.bybitsdk.constants.UrlConstants;
import io.github.kelvinykk511.bybitsdk.dto.req.*;
import io.github.kelvinykk511.bybitsdk.dto.resp.*;
import io.github.kelvinykk511.bybitsdk.util.JsonUtil;
import io.github.kelvinykk511.bybitsdk.util.QueryStringUtil;
import io.github.kelvinykk511.bybitsdk.util.SignUtil;
import lombok.SneakyThrows;
import okhttp3.*;
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
public class BybitClient {

    public BybitClient(String apiKey, String apiSecret, Boolean isMainnet) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.baseUrl = isMainnet ? UrlConstants.MAINNET_URL : UrlConstants.TESTNET_URL;
    }

    private final String apiKey;
    private final String apiSecret;
    private final String baseUrl;

    private final OkHttpClient httpClient = new OkHttpClient();

    @SneakyThrows
    public CommonResp<GetRealtimeOrderResp> getRealtimeOrder(GetRealtimeOrderReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.REALTIME_ORDER;
        Response response = get(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<GetRealtimeOrderResp>>() {});
    }

    @SneakyThrows
    public CommonResp<CreateOrderResp> createOrder(CreateOrderReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.CREATE_ORDER;
        Response response = post(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<CreateOrderResp>>() {});
    }

    @SneakyThrows
    public CommonResp<GetWalletBalanceResp> getWalletBalance(GetWalletBalanceReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.WALLET_BALANCE;
        Response response = get(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<GetWalletBalanceResp>>() {});
    }

    @SneakyThrows
    public CommonResp<GetMarketKlineResp> getMarketKline(GetMarketKlineReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.MARKET_KLINE;
        Response response = get(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<GetMarketKlineResp>>() {});
    }

    @SneakyThrows
    public CommonResp<Object> setSpotMarginLeverage(SetSpotMarginLeverageReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.SET_SPOT_MARGIN_LEVERAGE;
        Response response = post(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<Object>>() {});
    }

    @SneakyThrows
    public CommonResp<GetSpotBorrowCheckResp> getSpotBorrowCheck(GetSpotBorrowCheckReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.GET_SPOT_BORROW_CHECK;
        Response response = get(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<GetSpotBorrowCheckResp>>() {});
    }

    @SneakyThrows
    public CommonResp<GetMarketOrderBookResp> getMarketOrderBook(GetMarketOrderBookReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.GET_MARKET_ORDER_BOOK;
        Response response = get(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<GetMarketOrderBookResp>>() {});
    }

    @SneakyThrows
    public CommonResp<AmendOrderResp> amendOrder(AmendOrderReq req) {
        // Generate URL
        String url = baseUrl + UrlConstants.AMEND_ORDER;
        Response response = post(req, url);
        return JsonUtil.toObject(response.body().string(), new TypeReference<CommonResp<AmendOrderResp>>() {});
    }

    /**
     * Generic Method to Send POST request
     * @param req
     * @param url
     * @return
     */
    @NotNull
    @SneakyThrows
    private <T> Response post(T req, String url) {

        // GET CURRENT TIME
        Long current = System.currentTimeMillis();
        // GENERATE JSON BODY
        String jsonBody = JsonUtil.toJson(req);
        // SIGN
        String sign = SignUtil.generateSign(current, jsonBody, apiKey, apiSecret, Constants.RECV_WINDOW);
        RequestBody body = RequestBody.create(jsonBody, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
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


    /**
     * Generic Method to Send GET request
     * @param req
     * @param url
     * @return
     * @param <T>
     */
    @NotNull
    @SneakyThrows
    private <T> Response get(T req, String url) {
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
