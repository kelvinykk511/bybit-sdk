[![Latest release](https://img.shields.io/github/release/kelvinykk511/bybit-sdk.svg)](https://github.com/kelvinykk511/bybit-sdk/releases/latest)

This is a customized Bybit SDK that calling Bybit V5 API using okhttp3.

<h1>Installation Guide</h1>

To add dependency using maven, use the following:
```
<dependency>
    <groupId>io.github.kelvinykk511</groupId>
    <artifactId>bybit-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

<h1>Sample Code</h1>

```
// initialise the Bybit Client
BybitClient bybitClient = new BybitClient(YOUR_API_KEY, YOUR_SECRET_KEY, IS_MAINNET);

// construct the request dto
GetMarketKlineReq getMarketKlineReq = GetMarketKlineReq.builder()
    .category(CategoryEnum.LINEAR.getValue())
    .symbol("BTCUSDT")
    .interval(IntervalEnum.FIFTEEN_MINUTES.getValue())
    .start(0L)
    .end(System.currentTimeMillis())
    .limit(150)
    .build();

// call the function
CommonResp<GetMarketKlineResp> result = bybitClient.getMarketKline(getMarketKlineReq);
```
