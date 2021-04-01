package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseJpaEntity {
    /**
     * column name id.
     */
    public static final String COLUMN_ID = "`id`";
    /**
     * column name gmt_create.
     */
    public static final String COLUMN_GMT_CREATE = "`gmt_create`";
    /**
     * column name gmt_modified.
     */
    public static final String COLUMN_GMT_MODIFIED = "`gmt_modified`";
    /**
     * 数据库主键id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID, nullable = false, updatable = false)
    private Long id;
    /**
     * 创建时间 不可更新.
     */
    @Column(name = COLUMN_GMT_CREATE, nullable = false, updatable = false)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间.
     */
    @LastModifiedDate
    @Column(name = COLUMN_GMT_MODIFIED, nullable = false)
    private LocalDateTime gmtModified;
}
