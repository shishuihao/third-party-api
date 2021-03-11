package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.notice.WxPayResultNoticeRequest;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class WxPayResultNoticeRequestConverter extends WxPayConverter {
    /**
     * COUPON_TYPE_PATTERN.
     */
    private static final Pattern COUPON_TYPE_PATTERN
            = Pattern.compile("coupon_type_(.*)");
    /**
     * COUPON_FEE_PATTERN.
     */
    private static final Pattern COUPON_FEE_PATTERN
            = Pattern.compile("coupon_fee_(.*)");
    /**
     * COUPON_ID_PATTERN.
     */
    private static final Pattern COUPON_ID_PATTERN
            = Pattern.compile("coupon_id_(.*)");

    /**
     * new WxPayResultNoticeConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPayResultNoticeRequestConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayResultNoticeRequest.class);
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
        String nodeName = reader.getNodeName().trim();
        putIfMatchCoupon(reader, (WxPayResultNoticeRequest) result, nodeName);
    }

    private void putIfMatchCoupon(final HierarchicalStreamReader reader,
                                  final WxPayResultNoticeRequest request,
                                  final String nodeName) {
        match(COUPON_TYPE_PATTERN, nodeName, index -> {
            List<String> list = request.getCouponTypes();
            if (list == null) {
                list = new ArrayList<>();
                request.setCouponTypes(list);
            }
            setValue(list, index, reader.getValue());
        });
        match(COUPON_FEE_PATTERN, nodeName, index -> {
            List<Integer> list = request.getCouponFees();
            if (list == null) {
                list = new ArrayList<>();
                request.setCouponFees(list);
            }
            setValue(list, index, Integer.valueOf(reader.getValue()));
        });
        match(COUPON_ID_PATTERN, nodeName, index -> {
            List<String> list = request.getCouponIds();
            if (list == null) {
                list = new ArrayList<>();
                request.setCouponIds(list);
            }
            setValue(list, index, reader.getValue());
        });
    }

    private <T> void setValue(final List<T> list,
                              final Integer index,
                              final T value) {
        IntStream.range(0, index - list.size() + 1)
                .forEach(it -> list.add(null));
        list.set(index, value);
    }

    private void match(final Pattern pattern, final String nodeName,
                       final Consumer<Integer> action) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .map(it -> Integer.parseInt(it.group(1)))
                .ifPresent(action);
    }
}
