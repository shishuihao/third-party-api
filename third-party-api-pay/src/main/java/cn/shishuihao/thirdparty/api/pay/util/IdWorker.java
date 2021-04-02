package cn.shishuihao.thirdparty.api.pay.util;

import xyz.downgoon.snowflake.Snowflake;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class IdWorker {
    /**
     * MAX_DATACENTER_ID.
     */
    private static final long MAX_DATACENTER_ID = 31;
    /**
     * MAX_WORKER_ID.
     */
    private static final long MAX_WORKER_ID = 31;
    /**
     * DATACENTER_ID_BITS.
     */
    private static final long DATACENTER_ID_BITS = 5L;
    /**
     * SNOWFLAKE_ID_WORKER.
     */
    private static final Snowflake SNOWFLAKE_ID_WORKER;
    /**
     * LOW_MASK.
     */
    private static final int LOW_MASK = 0x00ff;
    /**
     * HIGH_MASK.
     */
    private static final int HIGH_MASK = 0xff00;
    /**
     * MASK.
     */
    private static final int MASK = 0xffff;

    static {
        long dataCenterId = getDataCenterId(MAX_DATACENTER_ID);
        long workerId = getMaxWorkerId(dataCenterId, MAX_WORKER_ID);
        SNOWFLAKE_ID_WORKER = new Snowflake(dataCenterId, workerId);
    }

    private IdWorker() {
    }

    /**
     * next id.
     *
     * @return long
     */
    public static long nextId() {
        return SNOWFLAKE_ID_WORKER.nextId();
    }

    /**
     * next id String.
     *
     * @return String
     */
    public static String nextIdString() {
        return String.valueOf(nextId());
    }

    private static long getDataCenterId(final long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = IpAddressUtils.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    long low = (LOW_MASK & (long) mac[mac.length - 1]);
                    long high = (HIGH_MASK & (((long) mac[mac.length - 2])
                            << Byte.SIZE));
                    id = (low | high) >> DATACENTER_ID_BITS + 1;
                    id = id % (maxDatacenterId + 1);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("getDataCenterId: "
                    + e.getMessage());
        }
        return id;
    }

    private static long getMaxWorkerId(final long dataCenterId,
                                       final long maxWorkerId) {
        StringBuilder mPid = new StringBuilder();
        mPid.append(dataCenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!isBlank(name)) {
            mPid.append(name.split("@")[0]);
        }
        return (mPid.toString().hashCode() & MASK) % (maxWorkerId + 1);
    }

    private static boolean isBlank(final CharSequence cs) {
        int strLen = length(cs);
        if (strLen == 0) {
            return true;
        } else {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
}
