package com.yupi.project.model.vo;

import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 黄昊
 * @version 1.0
 * 接口信息封装视图
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class InterfaceInfoVO extends InterfaceInfo {
    private Integer totalNum;
}
