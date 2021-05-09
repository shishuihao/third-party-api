package cn.shishuihao.thirdparty.api.pay.domain.merchant.addition_info;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class AdditionInfo {
    /**
     * 法人开户承诺函.
     * 1、请上传法定代表人或负责人亲笔签署的开户承诺函扫描件（下载模板）。
     * 亲笔签名承诺函内容清晰可见，不得有涂污，破损，字迹不清晰现象。
     * 2、请填写通过图片上传API预先上传图片生成好的MediaID。
     */
    private final String legalPersonCommitment;
    /**
     * 法人开户意愿视频.
     * 1、建议法人按如下话术录制“法人开户意愿视频”：
     * 我是#公司全称#的法定代表人（或负责人），
     * 特此证明本公司申请的商户号为我司真实意愿开立且用于XX业务（或XX服务）。
     * 我司现有业务符合法律法规及腾讯的相关规定。
     * 2、支持上传20M内的视频，格式可为avi、wmv、mpeg、mp4、mov、mkv、flv、f4v、m4v、rmvb。
     * 3、请填写通过视频上传API预先上传视频生成好的MediaID。
     */
    private final String legalPersonVideo;
    /**
     * 补充材料.
     * 1、根据驳回要求提供额外信息，如：
     * （1）业务模式不清晰时，需详细描述支付场景或提供相关材料（如业务说明/门店照/ 手持证件照等）；
     * （2）特殊业务要求提供相关的协议材料等；
     * 2、请填写通过图片上传API预先上传图片生成好的MediaID。
     */
    private final String[] businessAdditionPics;
    /**
     * 补充说明.
     * 根据驳回要求提供额外信息，如：业务模式不清晰时，请详细描述支付场景。
     */
    private final String businessAdditionMsg;
}
