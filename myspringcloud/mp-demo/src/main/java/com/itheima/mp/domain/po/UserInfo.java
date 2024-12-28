package com.itheima.mp.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author JianZJ
 * @Date 2024/12/28 14:35
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserInfo {

    private Integer age;
    private String intro;
    private String gender;

}
