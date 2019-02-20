package com.wxdevelop.wxdevelop.pojo.templace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 13:12 2019/2/20 0020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemData {
    private First first;
    private Company Company;
    private Time Time;
    private Remark Remark;
    private Result Result;
}
