package com.wxdevelop.wxdevelop.pojo.templace;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description: 模板详情
 * @Date: Created in 13:05 2019/2/20 0020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemCreate {

    private String touser;
    @JsonProperty("template_id")
    @JsonAlias("template_id")
    private String template_id;
    private String url;
    private TemData data;

    public TemCreate(TemData data) {
        this.touser = "o9Wg254yENSp_sn3jCAfvbIXk3MQ";
        this.template_id = "aLodHm2fj09TRNYApzkdEQ7sOhrYZ9IgrCMeTKfv1bo";
        this.url = "http://weixin.qq.com/download";
        this.data = data;
    }
}
