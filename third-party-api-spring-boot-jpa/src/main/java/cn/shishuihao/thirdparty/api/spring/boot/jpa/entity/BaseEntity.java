package cn.shishuihao.thirdparty.api.spring.boot.jpa.entity;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@MappedSuperclass
public class BaseEntity {
    public static final String ENTITY_ID = "id";
    public static final String GMT_CREATE = "gmt_create";
    public static final String GMT_MODIFIED = "gmt_modified";
    /**
     * 数据库主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_ID, nullable = false, updatable = false)
    private Long id;
    /**
     * 创建时间 不可更新
     */
    @Column(name = GMT_CREATE, nullable = false, updatable = false)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = GMT_MODIFIED, nullable = false)
    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
