package com.example.gagooda_project.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommonCodeDto {
    private String mstCode; // mst_code | 마스터 코드 | NN | PK
    private String detCode; // det_code | 상세코드 | NN | PK
    private String mstName; // mst_name | 마스터코드명 | NN
    private String detName; // det_name | 상세코드명 | NN
    private int seq;        // 순서 NN
    private boolean userYn; // user_yn | 사용여부 NN
    private Date regDt;     // reg_dt | 등록일 | NN | current timestamp
    private Date modDt;     // mod_dt | 수정일 | NN | current timestamp
}
