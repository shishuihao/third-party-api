package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay100RequestTest {
    final String host = "https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY";
    final String url = host +
            "?MERCHANTID=105421097080009" +
            "&POSID=902807340" +
            "&BRANCHID=360000000" +
            "&ccbParam=269dE0huScAzmN8oe9dIAaB2El1h1JpjPQ69oH6QPQnQBf%2FM%2CSFeJ5OK0h8ZAl1c0uguePLVn30c%0D%0AnPsPJg18SjTwBf71A2mG4YNeuyhIuwVV3Bd2ZkvHo8SmLHyng9UpwVVPyu0kWurf19P3ntAVLAkx%0D%0AXh74tqOM4tdcsEUl1sZ1mfWZt%2Cp6nOB0rU7rKHiDJdUo8tLrhSAMVfEHZTuhFAkxXh74tqOMCTFe%0D%0AHvi2o4wJMV4e%2CLajjCWE9uiApnxX%2Ceb1QztAAluENmjo6LRR4QkxXh74tqOMwek2m6Y6pm1BxI8b%0D%0ABuNp2Bt04il3fUxqw1rE8Zn4Lsr2jZ%2CcRr1Q2NCRzGlMxgqtzN%2FDn1iOUe43s6TCZh9XnfeRUaNu%0D%0AoeYQsPxgTGppeKYqTG%2CP06UaUL64E%2F8RlUu4%2CCqDU2bhryFmKkCnjXIqBTezpMJmH1edQX5hyzZv%0D%0A5Ocql1NhkXu0wkLg4KTcB%2CX4SKv7f9b3%2FQt7bRhSJeGKSxqBxM8mZQw%2CM5sKBMK%2CPCYIvLdYWhNu%0D%0AX8WrsG5eqWNI%2Cl3jwmpJ7zresUlIIpxkOW1tdKQ6Tjs6UvPQCeSkVhkcjV%2FoFjOHX%2FqWfJ0az8ai%0D%0AZgz0E2KKADYrJ2jwAVgKYOTa41hfkl3bHY7FCXb9BSDb0pqVnZlqD3pmLUMAaynIeTA%2F4IkJIvwt%0D%0A5GhAF1V9cJfUc6Hof0r5DgFtng6SF5sSLyKTHVISCSacJOQRa901l9Rzoeh%2FSvnNLUvZB7ivtxIv%0D%0AIpMdUhIJsZMm9rUnT0GHraQjVdniWpPQXx8O3tZnLda%2Frvi2QWf4US661VWsA%2F5pefLEonirpRD3%0D%0Amqrz9k4%2FfVyyP%2FGi3sk7yiLyggT5yXcj%2FMx4O0WuKitx1639IvhRLrrVVawD%2Fml58sSieKulEPea%0D%0AqvP2Tj99XLI%2F8aLeAnhR8K2gos0JyRI7gLvHPEhP5MRFq5egh62kI1XZ4lpVhB62hDgVSvQ4rohk%0D%0AvAleQ6EBXvYMEcpFKx4Y08ePehSj0205zYDr48qhspKsFm6NTQm7zc58UFpaGJJBQm3C5L1mNSYT%0D%0ALAtDoQFe9gwRykUrHhjTx496FKPTbTnNgOtVdj1o6eq5botgdQ8qfuKpwuj56E8IWQDjlnJZUEiW%0D%0AkDGBpbYNSW3kGZMEQj7QEzfZexDXsP70f4PdY2%2C9nRyD3topWcChiI31Qtb5s8khBCuhCPLMYmQj%0D%0AImPJUG%2CQOm8rxUns4JEw9Bphd1RQQCn%2FP31csj%2Fxot4JMV4e%2CLajjAkxXh74tqOMCTFeHvi2o4wJ%0D%0AMV4e%2CLajjKfZ2NEHiVoC6RYcqEi5DT5%2FiGmofVPwXyxDYWyjRimDIyGLb%2FV76jodmboIiXmnCx6i%0D%0Aj6JMoosC0TEs%2F4FBgzxePPWGt0RcgAkxXh74tqOMCTFeHvi2o4wJMV4e%2CLajjAkxXh74tqOMfbPv%0D%0Atwu%2C5hJO54W4DPNP70LGv6S8OeiEZRsQk6C2yzyhYVrW2D8Ei4iKr7EQGbFBWxw6v4UJsk%2FxrRWY%0D%0AJ%2FGO5VonW1c%2Clq5JwnxxyFOhzj7vy0Xw7FcptmA0zkF2Uk3%2CYcHANADTc%2FkcTdI5QP05bANgGuOV%0D%0AT5ld9546JH3oUgjwEcE%2CodzHhdZQ2auZFJ9%2FotLGoaSQmBXPbkZ4E2AAm7364D4%2C4xgq20CnIRmE%0D%0ARbTXksInrKA4HLgES%2FvxhLFjO0RhPvm8Sia9%2CuA%2CPuMYKgZjSwwOeu6bUSlJg5HsPuZjabHfJaKR%0D%0A%2FV83NDEDILt1%2FQn2hCS0GLb5s5CV5eEKFQR%2C6uNJRR1oRBXIhkOS5ua09WnqPXF3NSvjbwsFkZ0a%0D%0AVMuxdzCXyBBDA4N6dYykeQBdCXLUn8knjzJVpdiTODvwEcE%2CodzHhSbKT6bSfhM6C39ue3TTCST1%0D%0AKuwgfLee9A%3D%3D";
    /**
     * demo 完整公钥
     */
    final String publicKey = "30819d300d06092a864886f70d010101050003818b0030818702818100a32fb2d51dda418f65ca456431bd2f4173e41a82bb75c2338a6f649f8e9216204838d42e2a028c79cee19144a72b5b46fe6a498367bf41" +
            "43f959e4f73c9c4f499f68831f8663d6b946ae9fa31c74c9332bebf3cba1a98481533a37ffad944823bd46c305ec560648f1b6bcc64d54d32e213926b26cd10d342f2c61ff5ac2d78b020111";

    @Test
    void fzInfo() {
        CcbPay100Request.FzInfo[] infos = IntStream.range(0, 10)
                .mapToObj(i -> CcbPay100Request.FzInfo.builder()
                        .numberType("01")
                        .receiptNumber("10511007011000" + i)
                        .amount("1.0" + i)
                        .refundFlag(0)
                        .build())
                .toArray(CcbPay100Request.FzInfo[]::new);
        Pair<String, String> pair = CcbPay100Request.fzInfo("21", infos);
        Assertions.assertEquals("21!" +
                "01^105110070110000^^^1.00^0#" +
                "01^105110070110001^^^1.01^0#" +
                "01^105110070110002^^^1.02^0#" +
                "01^105110070110003^^^1.03^0#" +
                "01^105110070110004^^^1.04^0#" +
                "01^105110070110005^^^1.05^0#" +
                "01^105110070110006^^^1.06^0#", pair.getLeft());
        Assertions.assertEquals("" +
                "01^105110070110007^^^1.07^0#" +
                "01^105110070110008^^^1.08^0#" +
                "01^105110070110009^^^1.09^0#", pair.getRight());
    }

    @Test
    void url() {
        final CcbPay100Request request = CcbPay100Request.builder()
                .merchantId("105421097080009")
                .posId("902807340")
                .branchId("360000000")
                .groupMch("JTSH:105000000000000123456789441000000")
                .txCode("PAY100")
                .merchantFlag(1)
                .termNo1("1054210970800090001")
                .termNo2("12345678")
                .orderId("20180906101102")
                .qrCode("134737690209713402")
                .amount("0.01")
                .productInfo("MobilePhone")
                .remark1("remark1")
                .remark2("remark2")
                .fzInfo1("21!01^105110070110001^^^1.23^0#01^105110070110002^^^2.46^0#")
                .fzInfo2("01^105110070110001^^^1.23^0#01^105110070110002^^^2.46^0#")
                .subAppId("wx3b8bb3fad101bb07")
                .returnField("11000000000000000000")
                .userParam(CcbPay100Request.UserParam.builder()
                        .username("张三")
                        .idNumber("330000000000000000")
                        .idType("IDENTITY_CARD")
                        .build())
                .detail(CcbPay100Request.Detail.builder()
                        .costPrice(1)
                        .receiptId("wx123")
                        .goodsDetail(CcbPay100Request.GoodsDetail.builder()
                                .goodsId("id1")
                                .wxPayGoodsId("1001")
                                .goodsName("iPhone6s 16G")
                                .quantity(1)
                                .price(1)
                                .build())
                        .build())
                .goodsTag("WXG")
                .build();
        String genUrl = request.url(host, publicKey);
        System.out.println(genUrl);
        Assertions.assertEquals(url, genUrl);
    }
}