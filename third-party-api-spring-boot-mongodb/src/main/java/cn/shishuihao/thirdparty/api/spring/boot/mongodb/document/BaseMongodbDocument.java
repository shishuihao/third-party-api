package cn.shishuihao.thirdparty.api.spring.boot.mongodb.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public abstract class BaseMongodbDocument {
    /**
     * field name id.
     */
    public static final String COLUMN_ID = "id";
    /**
     * field name gmt_create.
     */
    public static final String COLUMN_GMT_CREATE = "gmt_create";
    /**
     * field name gmt_modified.
     */
    public static final String COLUMN_GMT_MODIFIED = "gmt_modified";
    /**
     * 数据库主键id.
     */
    @Id
    @Field(name = COLUMN_ID)
    private ObjectId id;
    /**
     * 创建时间 不可更新.
     */
    @Field(name = COLUMN_GMT_CREATE)
    private LocalDateTime gmtCreate = LocalDateTime.now();
    /**
     * 更新时间.
     */
    @LastModifiedDate
    @Field(name = COLUMN_GMT_MODIFIED)
    private LocalDateTime gmtModified;
}
