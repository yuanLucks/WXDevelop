package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description: 子菜单
 * @Date: Created in 19:57 2019/2/19 0019
 */
@Data
@NoArgsConstructor
public class SubButton extends AbstractButton {

    private List<AbstractButton> sub_button = new ArrayList<AbstractButton>();

    public SubButton(String name){
        super(name);
    }

}
