package cn.shishuihao.thirdparty.api.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public class DomainEvent {
    /**
     * event id.
     */
    private final String id;
    /**
     * time when the event occurred.
     */
    private final LocalDateTime occurred = LocalDateTime.now();
}
