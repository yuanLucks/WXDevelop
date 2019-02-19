package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:XieYuanYang
 * @Description:  点击推事件
 * @Date: Created in 19:52 2019/2/19 0019
 */
@Data
@NoArgsConstructor
public class ClickButton extends AbstractButton {

    private String type = "click";
    private String key;

    public ClickButton(String name,String key){
        super(name);
        this.key = key;
    }
}
