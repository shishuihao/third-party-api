package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class TxXmlUtils {
    private TxXmlUtils() {
    }

    /**
     * encode.
     *
     * @param txXml txXml
     * @return encoded txXml
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static String encode(final String txXml)
            throws UnsupportedEncodingException {
        int idx = txXml.indexOf("txXml=");
        String all;
        if (idx >= 0) {
            all = txXml.substring("txXml=".length());
            int idx1 = all.indexOf("<SIGN_INFO>");
            int idx2 = all.indexOf("</SIGN_INFO>");
            if (idx1 >= 0) {
                String before = all.substring(0, idx1);
                String mid1 = all.substring(idx1, idx2);
                String after = all.substring(idx2);
                int idx3 = after.indexOf("<SIGNCERT>");
                int idx4 = after.indexOf("</SIGNCERT>");
                if (idx3 >= 0) {
                    String before2 = after.substring(0, idx3);
                    String mid2 = after.substring(idx3, idx4);
                    String after2 = after.substring(idx4);
                    all = URLEncoder.encode(before, "GB18030")
                            + mid1 + URLEncoder.encode(before2, "GB18030")
                            + mid2 + URLEncoder.encode(after2, "GB18030");
                } else {
                    all = URLEncoder.encode(before, "GB18030")
                            + mid1 + URLEncoder.encode(after, "GB18030");
                }
            } else {
                all = URLEncoder.encode(all, "GB18030");
            }
            return "txXml=" + all + "&errcode12=1";
        }
        return txXml + "&errcode12=1";
    }
}
