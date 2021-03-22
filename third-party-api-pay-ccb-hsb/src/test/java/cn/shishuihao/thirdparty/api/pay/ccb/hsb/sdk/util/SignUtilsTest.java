package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class SignUtilsTest {

    @Test
    void createSign() {
        String json = "{\"Vno\":\"3\",\"Prjlist\":[{\"Prj_Id\":\"1\",\"Prj_Nm\":\"红包\",\"Pjcy_Tp\":\"2\",\"Amt\":\"1\"},{\"Prj_Id\":\"2\",\"Prj_Nm\":\"会员打折\",\"Pjcy_Tp\":\"2\",\"Amt\":\"1\"}]}";
        Assertions.assertEquals("Amt=1&Pjcy_Tp=2&Prj_Id=1&Prj_Nm=红包&Amt=1&Pjcy_Tp=2&Prj_Id=2&Prj_Nm=会员打折&Vno=3",
                SignUtils.createSign(json));
    }
}