package cn.shishuihao.thirdparty.api.pay.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class IpAddressUtils {
    private IpAddressUtils() {
    }

    /**
     * get local host.
     *
     * @return InetAddress
     * @throws UnknownHostException UnknownHostException
     */
    public static InetAddress getLocalHost() throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (!inetAddress.isLinkLocalAddress()
                            && !inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress;
                    }
                }
            }
        } catch (SocketException var4) {
            throw new UnknownHostException();
        }
        return InetAddress.getLocalHost();
    }
}
