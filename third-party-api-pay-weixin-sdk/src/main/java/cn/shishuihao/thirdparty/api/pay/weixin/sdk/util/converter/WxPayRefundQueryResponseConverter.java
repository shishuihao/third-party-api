package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.converter;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayRefundQueryResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlFieldUtils;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class WxPayRefundQueryResponseConverter extends ReflectionConverter {

    /**
     * String.
     */
    private static final Map<String, Field> NAME_FIELD_MAP
            = XmlFieldUtils.getNameFieldMap(WxPayRefundQueryResponse.class);
    /**
     * OUT_REFUND_NO_PATTERN.
     */
    private static final Pattern OUT_REFUND_NO_PATTERN
            = Pattern.compile("out_refund_no_(.*)");
    /**
     * REFUND_ID_PATTERN.
     */
    private static final Pattern REFUND_ID_PATTERN
            = Pattern.compile("refund_id_(.*)");
    /**
     * REFUND_CHANNEL_PATTERN.
     */
    private static final Pattern REFUND_CHANNEL_PATTERN
            = Pattern.compile("refund_channel_(.*)");
    /**
     * REFUND_FEE_PATTERN.
     */
    private static final Pattern REFUND_FEE_PATTERN
            = Pattern.compile("refund_fee_(.*)");
    /**
     * SETTLEMENT_REFUND_FEE_PATTERN.
     */
    private static final Pattern SETTLEMENT_REFUND_FEE_PATTERN
            = Pattern.compile("settlement_refund_fee(.*)");
    /**
     * COUPON_TYPES_PATTERN.
     */
    private static final Pattern COUPON_TYPES_PATTERN
            = Pattern.compile("coupon_type_(.*)_(.*)");
    /**
     * COUPON_REFUND_FEE_PATTERN.
     */
    private static final Pattern COUPON_REFUND_FEE_PATTERN
            = Pattern.compile("coupon_refund_fee_(.*)");
    /**
     * COUPON_REFUND_COUNT_PATTERN.
     */
    private static final Pattern COUPON_REFUND_COUNT_PATTERN
            = Pattern.compile("coupon_refund_count_(.*)");
    /**
     * COUPON_REFUND_ID_PATTERN.
     */
    private static final Pattern COUPON_REFUND_ID_PATTERN
            = Pattern.compile("coupon_refund_id_(.*)");
    /**
     * COUPON_REFUND_FEES_PATTERN.
     */
    private static final Pattern COUPON_REFUND_FEES_PATTERN
            = Pattern.compile("coupon_refund_fee_(.*)_(.*)");
    /**
     * REFUND_STATUS_PATTERN.
     */
    private static final Pattern REFUND_STATUS_PATTERN
            = Pattern.compile("refund_status_(.*)");
    /**
     * REFUND_ACCOUNT_PATTERN.
     */
    private static final Pattern REFUND_ACCOUNT_PATTERN
            = Pattern.compile("refund_account_(.*)");
    /**
     * REFUND_RECV_ACCOUNT_PATTERN.
     */
    private static final Pattern REFUND_RECV_ACCOUNT_PATTERN
            = Pattern.compile("refund_recv_accout_(.*)");
    /**
     * REFUND_SUCCESS_TIME_PATTERN.
     */
    private static final Pattern REFUND_SUCCESS_TIME_PATTERN
            = Pattern.compile("refund_success_time_(.*)");

    /**
     * new WxPayRefundQueryResponseConverter.
     *
     * @param mapper             mapper
     * @param reflectionProvider reflectionProvider
     */
    public WxPayRefundQueryResponseConverter(
            final Mapper mapper,
            final ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayRefundQueryResponse.class);
    }

    /**
     * Convert an object to textual data.
     *
     * @param source  The object to be marshalled.
     * @param writer  A stream to write to.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     */
    @Override
    public void marshal(final Object source,
                        final HierarchicalStreamWriter writer,
                        final MarshallingContext context) {
        WxPayRefundQueryResponse response = (WxPayRefundQueryResponse) source;
        NAME_FIELD_MAP.forEach((name, field) -> {
            try {
                Object fieldValue = FieldUtils.readField(field, response, true);
                if (fieldValue == null) {
                    return;
                }
                String namePrefix = name
                        .replace("_$n", "")
                        .replace("_$m", "");
                if (fieldValue instanceof Map) {
                    Map<Integer, ?> map = (Map<Integer, ?>) fieldValue;
                    marshalMap(writer, map, namePrefix);
                } else {
                    writer.startNode(namePrefix);
                    writer.setValue(String.valueOf(fieldValue));
                    writer.endNode();
                }
            } catch (IllegalAccessException e) {
                throw ExceptionUtils.<RuntimeException>rethrow(e);
            }
        });
    }

    /**
     * Convert textual data back into an object.
     *
     * @param reader  The stream to read the text from.
     * @param context A context that allows nested objects
     *                to be processed by XStream.
     * @return The resulting object.
     */
    @Override
    public Object unmarshal(final HierarchicalStreamReader reader,
                            final UnmarshallingContext context) {
        try {
            WxPayRefundQueryResponse response = new WxPayRefundQueryResponse();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String nodeName = reader.getNodeName().trim();
                putMapIfMatch(OUT_REFUND_NO_PATTERN, nodeName,
                        response::getOutRefundNos, reader::getValue);
                putMapIfMatch(REFUND_ID_PATTERN, nodeName,
                        response::getRefundIds, reader::getValue);
                putMapIfMatch(REFUND_CHANNEL_PATTERN, nodeName,
                        response::getRefundChannels, reader::getValue);
                putMapIfMatch(REFUND_FEE_PATTERN, nodeName,
                        response::getRefundFees, () ->
                                Integer.valueOf(reader.getValue()));
                putMapIfMatch(OUT_REFUND_NO_PATTERN, nodeName,
                        response::getOutRefundNos, reader::getValue);
                putMapIfMatch(SETTLEMENT_REFUND_FEE_PATTERN, nodeName,
                        response::getSettlementRefundFees, () ->
                                Integer.valueOf(reader.getValue()));
                putMapIfMatch(COUPON_REFUND_FEE_PATTERN, nodeName,
                        response::getCouponRefundFees, () ->
                                Integer.valueOf(reader.getValue()));
                putMapIfMatch(COUPON_REFUND_COUNT_PATTERN, nodeName,
                        response::getCouponRefundCounts, () ->
                                Integer.valueOf(reader.getValue()));
                putMapIfMatch(REFUND_STATUS_PATTERN, nodeName,
                        response::getRefundStatuses, reader::getValue);
                putMapIfMatch(REFUND_ACCOUNT_PATTERN, nodeName,
                        response::getRefundAccounts, reader::getValue);
                putMapIfMatch(REFUND_RECV_ACCOUNT_PATTERN, nodeName,
                        response::getRefundRecvAccounts, reader::getValue);
                putMapIfMatch(REFUND_SUCCESS_TIME_PATTERN, nodeName,
                        response::getRefundSuccessTimes, reader::getValue);
                putMapMapIfMatch(COUPON_TYPES_PATTERN, nodeName,
                        response::getCouponTypes, reader::getValue);
                putMapMapIfMatch(COUPON_REFUND_ID_PATTERN, nodeName,
                        response::getCouponRefundsIds, () ->
                                Integer.valueOf(reader.getValue()));
                putMapMapIfMatch(COUPON_REFUND_FEES_PATTERN, nodeName,
                        response::getCouponRefundsFees, () ->
                                Integer.valueOf(reader.getValue()));
                Field field = NAME_FIELD_MAP.get(nodeName);
                if (field != null) {
                    Class<?> type = mapper
                            .defaultImplementationOf(field.getType());
                    Object value = this
                            .unmarshallField(context, response, type, field);
                    FieldUtils.writeField(field, response, value, true);
                }
                reader.moveUp();
            }
            return response;
        } catch (Exception e) {
            throw ExceptionUtils.<RuntimeException>rethrow(e);
        }
    }

    private void marshalMap(final HierarchicalStreamWriter writer,
                            final Map<Integer, ?> fieldValue,
                            final String namePrefix) {
        fieldValue.forEach((m1, v1) -> {
            if (v1 instanceof Map) {
                Map<Integer, ?> map2 = (Map<Integer, ?>) v1;
                map2.forEach((m2, v2) -> {
                    writer.startNode(namePrefix + '_' + m1 + '_' + m2);
                    writer.setValue(String.valueOf(v2));
                    writer.endNode();
                });
            } else {
                writer.startNode(namePrefix + '_' + m1);
                writer.setValue(String.valueOf(v1));
                writer.endNode();
            }
        });
    }

    private <T> void putMapIfMatch(
            final Pattern pattern,
            final String nodeName,
            final Supplier<Map<Integer, T>> map,
            final Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> map.get()
                        .put(Integer.valueOf(it.group(1)),
                                valueSupplier.get()));
    }

    private <T> void putMapMapIfMatch(
            final Pattern pattern,
            final String nodeName,
            final Supplier<Map<Integer, Map<Integer, T>>> map,
            final Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> map.get()
                        .computeIfAbsent(Integer.valueOf(it.group(1)), k ->
                                new HashMap<>(Integer.SIZE))
                        .put(Integer.valueOf(it.group(2)),
                                valueSupplier.get()));
    }
}
