package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description: 弹出拍照或者相册发图用户
 * @Date: Created in 20:02 2019/2/19 0019
 */
@Data
@NoArgsConstructor
public class PhotoOrAlbumButton extends AbstractButton {

    private String type = "pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button = new ArrayList<>();

   public PhotoOrAlbumButton(String name,String key){
       super(name);
       this.key = key;
   }
}
