package com.linglan.syt.dto.hosp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HospitalSetQueryDto {

    @ApiModelProperty(value = "医院名称")
    private String hosname;

    @ApiModelProperty(value = "医院编号")
    private String hoscode;
}
