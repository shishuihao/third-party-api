package cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WechatPayRefundQueryResponseConverter
        extends WechatPayConverter {
    /**
     * COUPON_TYPES_PATTERN.
     */
    private static final Pattern COUPON_TYPES_PATTERN
            = Pattern.compile("coupon_type_(.*)_(.*)");
    /**
     * COUPON_REFUND_ID_PATTERN.
     */
    private static final Pattern COUPON_REFUND_IDS_PATTERN
            = Pattern.compile("coupon_refund_id_(.*)_(.*)");
    /**
     * COUPON_REFUND_FEES_PATTERN.
     */
    private static final Pattern COUPON_REFUND_FEES_PATTERN
            = Pattern.compile("coupon_refund_fee_(.*)_(.*)");

    /**
     * new WechatPayRefundQueryResponseConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WechatPayRefundQueryResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WechatPayRefundQueryResponse.class);
    }

    /**
     * unmarshal field.
     *
     * @param reader  The stream to read the text from.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     * @param result  result
     * @param field   field
     * @throws IllegalAccessException IllegalAccessException
     */
    @Override
    protected void unmarshalField(final HierarchicalStreamReader reader,
                                  final UnmarshallingContext context,
                                  final Object result,
                                  final Field field)
            throws IllegalAccessException {
        super.unmarshalField(reader, context, result, field);
        final String nodeName = reader.getNodeName().trim();
        putIfMatchCoupon(reader,
                (WechatPayRefundQueryResponse) result,
                nodeName);
    }

    private void putIfMatchCoupon(final HierarchicalStreamReader reader,
                                  final WechatPayRefundQueryResponse response,
                                  final String nodeName) {
        putMapMapIfMatch(COUPON_TYPES_PATTERN, nodeName,
                response::getCouponTypes, reader::getValue);
        putMapMapIfMatch(COUPON_REFUND_IDS_PATTERN, nodeName,
                response::getCouponRefundsIds, reader::getValue);
        putMapMapIfMatch(COUPON_REFUND_FEES_PATTERN, nodeName,
                response::getCouponRefundsFees, () ->
                        Integer.valueOf(reader.getValue()));
    }

    private <T> void putMapMapIfMatch(
            final Pattern pattern,
            final String nodeName,
            final Supplier<List<List<T>>> listSupplier,
            final Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> {
                    List<List<T>> lists = listSupplier.get();
                    int i1 = Integer.parseInt(it.group(1));
                    List<T> list = lists.get(i1);
                    if (list == null) {
                        list = new ArrayList<>();
                        WechatPayConverter.unmarshalList(lists, i1, list);
                    }
                    int i2 = Integer.parseInt(it.group(2));
                    WechatPayConverter.unmarshalList(list, i2,
                            valueSupplier.get());
                });
    }
}
