package cn.shishuihao.thirdparty.api.spring.boot.mongodb.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class BaseDocument {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_GMT_CREATE = "gmt_create";
    public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
    /**
     * 数据库主键id
     */
    @Id
    @Field(name = COLUMN_ID)
    private ObjectId id;
    /**
     * 创建时间 不可更新
     */
    @Field(name = COLUMN_GMT_CREATE)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间
     */
    @LastModifiedDate
    @Field(name = COLUMN_GMT_MODIFIED)
    private LocalDateTime gmtModified;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
