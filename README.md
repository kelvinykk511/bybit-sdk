This is a customized Bybit SDK that calling Bybit V5 API using okhttp3.

<h1>Installation Guide</h1>

To add dependency using maven, use the following:
```
<dependency>
    <groupId>io.github.kelvinykk511</groupId>
    <artifactId>bybit-sdk</artifactId>
    <version>1.0</version>
</dependency>
```

<h1>Sample Code</h1>

```
// initialise the Bybit Client
BybitClient bybitClient = new BybitClient(YOUR_API_KEY, YOUR_SECRET_KEY, IS_MAINNET);

// construct the request dto
GetMarketKlineReq getMarketKlineReq = GetMarketKlineReq.builder()
    .category(CategoryEnum.LINEAR.getValue())
    .symbol(symbolEnum.getValue())
    .interval(IntervalEnum.FIFTEEN_MINUTES.getValue())
    .start(start.intValue())
    .end(end.intValue())
    .limit(150)
    .build();

// call the function
CommonResp<GetMarketKlineResp> result = bybitClient.getMarketKline(getMarketKlineReq);
```
