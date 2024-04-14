package com.yupi.project.model.dto.interfaceInfo;

import lombok.Data;

/**
 * @author 黄昊
 * @version 1.0
 * 接口调用请求
 **/
@Data
public class InterfaceInfoInvokeRequest {
    private Long id;

    private String userRequestParams;

}
