package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description: 弹出系统拍照发图用户
 * @Date: Created in 21:19 2019/2/19 0019
 */
@Data
@NoArgsConstructor
public class Photograph extends AbstractButton {

    private String type = "pic_sysphoto";
    private String key;

    private List<AbstractButton> sub_button = new ArrayList<AbstractButton>();

    public Photograph(String name,String key){
        super(name);
        this.key = key;
    }

}
