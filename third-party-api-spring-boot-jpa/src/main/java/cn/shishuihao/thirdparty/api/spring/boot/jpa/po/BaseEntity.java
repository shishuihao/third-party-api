package cn.shishuihao.thirdparty.api.spring.boot.jpa.po;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@MappedSuperclass
public class BaseEntity {
    /**
     * 数据库主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间 不可更新
     */
    @Column(updatable = false)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column
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
