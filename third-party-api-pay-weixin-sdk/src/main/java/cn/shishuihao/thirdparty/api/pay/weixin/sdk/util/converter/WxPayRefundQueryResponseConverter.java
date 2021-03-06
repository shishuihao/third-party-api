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
    private static final Map<String, Field> NAME_FIELD_MAP = XmlFieldUtils.getNameFieldMap(WxPayRefundQueryResponse.class);
    private static final Pattern OUT_REFUND_NO_PATTERN = Pattern.compile("out_refund_no_(.*)");
    private static final Pattern REFUND_ID_PATTERN = Pattern.compile("refund_id_(.*)");
    private static final Pattern REFUND_CHANNEL_PATTERN = Pattern.compile("refund_channel_(.*)");
    private static final Pattern REFUND_FEE_PATTERN = Pattern.compile("refund_fee_(.*)");
    private static final Pattern SETTLEMENT_REFUND_FEE_PATTERN = Pattern.compile("settlement_refund_fee(.*)");
    private static final Pattern COUPON_TYPES_PATTERN = Pattern.compile("coupon_type_(.*)_(.*)");
    private static final Pattern COUPON_REFUND_FEE_PATTERN = Pattern.compile("coupon_refund_fee_(.*)");
    private static final Pattern COUPON_REFUND_COUNT_PATTERN = Pattern.compile("coupon_refund_count_(.*)");
    private static final Pattern COUPON_REFUND_ID_PATTERN = Pattern.compile("coupon_refund_id_(.*)");
    private static final Pattern COUPON_REFUND_FEES_PATTERN = Pattern.compile("coupon_refund_fee_(.*)_(.*)");
    private static final Pattern REFUND_STATUS_PATTERN = Pattern.compile("refund_status_(.*)");
    private static final Pattern REFUND_ACCOUNT_PATTERN = Pattern.compile("refund_account_(.*)");
    private static final Pattern REFUND_RECV_ACCOUNT_PATTERN = Pattern.compile("refund_recv_accout_(.*)");
    private static final Pattern REFUND_SUCCESS_TIME_PATTERN = Pattern.compile("refund_success_time_(.*)");

    public WxPayRefundQueryResponseConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider, WxPayRefundQueryResponse.class);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        WxPayRefundQueryResponse response = (WxPayRefundQueryResponse) value;
        NAME_FIELD_MAP.forEach((name, field) -> {
            try {
                Object fieldValue = FieldUtils.readField(field, response, true);
                if (fieldValue == null) {
                    return;
                }
                String namePrefix = name.replace("_$n", "").replace("_$m", "");
                if (fieldValue instanceof Map) {
                    marshalMap(writer, (Map<Integer, ?>) fieldValue, namePrefix);
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

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            WxPayRefundQueryResponse response = new WxPayRefundQueryResponse();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String nodeName = reader.getNodeName().trim();
                putMapIfMatch(OUT_REFUND_NO_PATTERN, nodeName, response::getOutRefundNos, reader::getValue);
                putMapIfMatch(REFUND_ID_PATTERN, nodeName, response::getRefundIds, reader::getValue);
                putMapIfMatch(REFUND_CHANNEL_PATTERN, nodeName, response::getRefundChannels, reader::getValue);
                putMapIfMatch(REFUND_FEE_PATTERN, nodeName, response::getRefundFees, () -> Integer.valueOf(reader.getValue()));
                putMapIfMatch(OUT_REFUND_NO_PATTERN, nodeName, response::getOutRefundNos, reader::getValue);
                putMapIfMatch(SETTLEMENT_REFUND_FEE_PATTERN, nodeName, response::getSettlementRefundFees, () -> Integer.valueOf(reader.getValue()));
                putMapIfMatch(COUPON_REFUND_FEE_PATTERN, nodeName, response::getCouponRefundFees, () -> Integer.valueOf(reader.getValue()));
                putMapIfMatch(COUPON_REFUND_COUNT_PATTERN, nodeName, response::getCouponRefundCounts, () -> Integer.valueOf(reader.getValue()));
                putMapIfMatch(REFUND_STATUS_PATTERN, nodeName, response::getRefundStatuses, reader::getValue);
                putMapIfMatch(REFUND_ACCOUNT_PATTERN, nodeName, response::getRefundAccounts, reader::getValue);
                putMapIfMatch(REFUND_RECV_ACCOUNT_PATTERN, nodeName, response::getRefundRecvAccounts, reader::getValue);
                putMapIfMatch(REFUND_SUCCESS_TIME_PATTERN, nodeName, response::getRefundSuccessTimes, reader::getValue);

                putMapMapIfMatch(COUPON_TYPES_PATTERN, nodeName, response::getCouponTypes, reader::getValue);
                putMapMapIfMatch(COUPON_REFUND_ID_PATTERN, nodeName, response::getCouponRefundsIds, () -> Integer.valueOf(reader.getValue()));
                putMapMapIfMatch(COUPON_REFUND_FEES_PATTERN, nodeName, response::getCouponRefundsFees, () -> Integer.valueOf(reader.getValue()));
                Field field = NAME_FIELD_MAP.get(nodeName);
                if (field != null) {
                    Class<?> type = mapper.defaultImplementationOf(field.getType());
                    FieldUtils.writeField(field, response, unmarshallField(context, response, type, field), true);
                }
                reader.moveUp();
            }
            return response;
        } catch (Exception e) {
            throw ExceptionUtils.<RuntimeException>rethrow(e);
        }
    }

    private void marshalMap(HierarchicalStreamWriter writer, Map<Integer, ?> fieldValue, String namePrefix) {
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

    private <T> void putMapIfMatch(Pattern pattern, String nodeName, Supplier<Map<Integer, T>> map, Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> map.get().put(Integer.valueOf(it.group(1)), valueSupplier.get()));
    }

    private <T> void putMapMapIfMatch(Pattern pattern, String nodeName, Supplier<Map<Integer, Map<Integer, T>>> map, Supplier<T> valueSupplier) {
        Optional.of(pattern.matcher(nodeName))
                .filter(Matcher::find)
                .ifPresent(it -> map.get().computeIfAbsent(Integer.valueOf(it.group(1)), k -> new HashMap<>(16))
                        .put(Integer.valueOf(it.group(2)), valueSupplier.get()));
    }
}
