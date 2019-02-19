package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description:  子菜单
 * @Date: Created in 13:53 2019/2/19 0019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Button {

    private List<AbstractButton> button = new ArrayList<AbstractButton>();

}
