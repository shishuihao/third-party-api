package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.util;

import com.ccb.wlpt.url.MerchantUrlInfo;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class UrlInfoInterfaceUtils {
    /**
     * 前缀.
     */
    private static final String HTTP = "http";

    private UrlInfoInterfaceUtils() {
    }

    /**
     * 获取UrlInfoInterface.
     *
     * @param body 返回
     * @return UrlInfoInterface
     */
    public static MerchantUrlInfo getUrlInfo(final String body) {
        // <!DOCTYPE html>success::MER01##MER01##
        MerchantUrlInfo urlInfo = new MerchantUrlInfo();
        if (body != null && !"".equals(body.trim())) {
            int nIndexStart = body.indexOf("success::");
            int nIndexEnd = body.indexOf("##");
            if (nIndexStart >= 0 && nIndexEnd >= 0) {
                String[] itemList = body
                        .substring(nIndexStart + "success::".length())
                        .split("##");
                String b2cServlet = getB2cServlet(itemList);
                String channelName = urlInfo.getChannelName();
                setNewB2cUrl(urlInfo, b2cServlet, channelName);
                setNewB2cBigDownloadUrl(urlInfo, b2cServlet,
                        getB2cDownloadUrl(itemList, b2cServlet),
                        channelName);
                setNewB2cBigUploadUrl(urlInfo, b2cServlet,
                        getB2cUploadUrl(itemList, b2cServlet),
                        channelName);
                urlInfo.setChannelName(b2cServlet);
            }
        }
        return urlInfo;
    }

    private static String getB2cServlet(final String[] itemList) {
        if (itemList.length > 0 && !"".equals(itemList[0].trim())) {
            return itemList[0].trim();
        }
        return "";
    }

    private static String getB2cUploadUrl(
            final String[] itemList,
            final String b2cServlet) {
        String b2cUploadUrl;
        if (itemList.length > 2 && !"".equals(itemList[2].trim())) {
            b2cUploadUrl = itemList[2].trim();
        } else {
            b2cUploadUrl = b2cServlet;
        }
        return b2cUploadUrl;
    }

    private static String getB2cDownloadUrl(
            final String[] itemList,
            final String b2cServlet) {
        String b2cDownloadUrl;
        if (itemList.length > 1 && !"".equals(itemList[1].trim())) {
            b2cDownloadUrl = itemList[1].trim();
        } else {
            b2cDownloadUrl = b2cServlet;
        }
        return b2cDownloadUrl;
    }

    private static void setNewB2cBigUploadUrl(
            final MerchantUrlInfo urlInfo,
            final String b2cServlet,
            final String b2cUploadUrl,
            final String channelName) {
        String newB2cBigUploadUrl;
        if (!"".equals(b2cUploadUrl)) {
            if (b2cUploadUrl.contains(HTTP)) {
                urlInfo.setNEW_B2C_BIG_UPLOAD_URL(b2cUploadUrl);
            } else {
                newB2cBigUploadUrl = urlInfo.getNEW_B2C_BIG_UPLOAD_URL()
                        .replace(channelName, b2cServlet);
                urlInfo.setNEW_B2C_BIG_UPLOAD_URL(newB2cBigUploadUrl);
            }
        }
    }

    private static void setNewB2cBigDownloadUrl(
            final MerchantUrlInfo urlInfo,
            final String b2cServlet,
            final String b2cDownloadUrl,
            final String channelName) {
        String newB2cBigUploadUrl;
        if (!"".equals(b2cDownloadUrl)) {
            if (b2cDownloadUrl.contains(HTTP)) {
                urlInfo.setNEW_B2C_BIG_DOWNLOAD_URL(b2cDownloadUrl);
            } else {
                newB2cBigUploadUrl = urlInfo.getNEW_B2C_BIG_DOWNLOAD_URL()
                        .replace(channelName, b2cServlet);
                urlInfo.setNEW_B2C_BIG_DOWNLOAD_URL(newB2cBigUploadUrl);
            }
        }
    }

    private static void setNewB2cUrl(
            final MerchantUrlInfo urlInfo,
            final String b2cServlet,
            final String channelName) {
        String newB2cBigUploadUrl;
        if (!"".equals(b2cServlet)) {
            if (b2cServlet.contains(HTTP)) {
                urlInfo.setNEW_B2C_URL(b2cServlet);
            } else {
                newB2cBigUploadUrl = urlInfo.getNEW_B2C_URL()
                        .replace(channelName, b2cServlet);
                urlInfo.setNEW_B2C_URL(newB2cBigUploadUrl);
            }
        }
    }
}
