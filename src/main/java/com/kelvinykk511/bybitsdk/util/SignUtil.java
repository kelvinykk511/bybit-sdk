package com.kelvinykk511.bybitsdk.util;

import lombok.SneakyThrows;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;

public class SignUtil {

    public static String generateSign(Long current, String queryStr, String apiKey, String apiSecret, String recvWindow) {
        String paramStr = current + apiKey + recvWindow + queryStr;
        return SignUtil.calculateHmacSha256(apiSecret, paramStr);
    }

    @SneakyThrows
    public static String calculateHmacSha256(String key, String data) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(data.getBytes());
        return bytesToHex(rawHmac);
    }

    private static String bytesToHex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

}
