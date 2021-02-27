package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class BaseEntity {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_GMT_CREATE = "gmt_create";
    public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
    /**
     * 数据库主键id
     */
    @TableId(value = COLUMN_ID, type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间 不可更新
     */
    @TableField(value = COLUMN_GMT_CREATE, update = "now()", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间
     */
    @TableField(value = COLUMN_GMT_MODIFIED, update = "now()", fill = FieldFill.INSERT_UPDATE)
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
