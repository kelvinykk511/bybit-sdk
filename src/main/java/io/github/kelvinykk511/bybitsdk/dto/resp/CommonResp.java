package io.github.kelvinykk511.bybitsdk.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {

    private Integer retCode;
    private String retMsg;
    private T result;
    private Long time;
    private Object retExtInfo;

}
