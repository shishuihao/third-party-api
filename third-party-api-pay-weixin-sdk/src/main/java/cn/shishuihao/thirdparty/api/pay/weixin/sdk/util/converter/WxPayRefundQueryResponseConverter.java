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
                    Map<Integer, ?> map1 = (Map<Integer, ?>) fieldValue;
                    map1.forEach((m1, v1) -> {
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
                Optional.of(OUT_REFUND_NO_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getOutRefundNos().put(index, reader.getValue()));
                Optional.of(REFUND_ID_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundIds().put(index, reader.getValue()));
                Optional.of(REFUND_CHANNEL_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundChannels().put(index, reader.getValue()));
                Optional.of(REFUND_FEE_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundFees().put(index, Integer.valueOf(reader.getValue())));
                Optional.of(SETTLEMENT_REFUND_FEE_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getSettlementRefundFees().put(index, Integer.valueOf(reader.getValue())));
                Optional.of(COUPON_TYPES_PATTERN.matcher(nodeName)).filter(Matcher::find)
                        .ifPresent(it -> response.getCouponTypes()
                                .computeIfAbsent(Integer.valueOf(it.group(1)), k -> new HashMap<>())
                                .put(Integer.valueOf(it.group(2)), reader.getValue()));
                Optional.of(COUPON_REFUND_FEE_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getCouponRefundFees().put(index, Integer.valueOf(reader.getValue())));
                Optional.of(COUPON_REFUND_COUNT_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getCouponRefundCounts().put(index, Integer.valueOf(reader.getValue())));
                Optional.of(COUPON_REFUND_ID_PATTERN.matcher(nodeName)).filter(Matcher::find)
                        .ifPresent(it -> response.getCouponRefundsIds()
                                .computeIfAbsent(Integer.valueOf(it.group(1)), k -> new HashMap<>())
                                .put(Integer.valueOf(it.group(2)), Integer.valueOf(reader.getValue())));
                Optional.of(COUPON_REFUND_FEES_PATTERN.matcher(nodeName)).filter(Matcher::find)
                        .ifPresent(it -> response.getCouponRefundsFees()
                                .computeIfAbsent(Integer.valueOf(it.group(1)), k -> new HashMap<>())
                                .put(Integer.valueOf(it.group(2)), Integer.valueOf(reader.getValue())));
                Optional.of(REFUND_STATUS_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundStatuses().put(index, reader.getValue()));
                Optional.of(REFUND_ACCOUNT_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundAccounts().put(index, reader.getValue()));
                Optional.of(REFUND_RECV_ACCOUNT_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundRecvAccounts().put(index, reader.getValue()));
                Optional.of(REFUND_SUCCESS_TIME_PATTERN.matcher(nodeName)).filter(Matcher::find).map(it -> Integer.valueOf(it.group(1)))
                        .ifPresent(index -> response.getRefundSuccessTimes().put(index, reader.getValue()));
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
}
