create database LoveAdoption;

use LoveAdoption;

-- 创建用户表
CREATE TABLE user
(
    id              INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID，主键',                                  -- 用户ID，主键
    username        VARCHAR(50)  NOT NULL COMMENT '用户名，唯一',                                           -- 用户名，唯一
    password        VARCHAR(255) NOT NULL COMMENT '加密后的密码',                                          -- 密码（加密存储）
    email           VARCHAR(100) UNIQUE COMMENT '用户邮箱，唯一',                                           -- 用户邮箱，唯一
    phone           VARCHAR(20) UNIQUE COMMENT '用户手机号，唯一',                                          -- 用户手机号，唯一
    role            INT      DEFAULT 0 COMMENT '用户角色，0表示普通用户，1表示管理员',                       -- 用户角色，0为普通用户，1为管理员
    status          INT      DEFAULT 1 COMMENT '用户状态，0表示正常使用，1表示冻结',                         -- 用户状态，0为未激活，1为已激活
    profile_picture VARCHAR(255) COMMENT '用户头像图片的URL',                                              -- 用户头像图片的URL
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',                             -- 用户创建时间
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间', -- 更新时间
    deleted_at      DATETIME     NULL COMMENT '软删除时间，记录删除时间用于软删除',                         -- 软删除时间（标记删除）
    UNIQUE (username) COMMENT '确保用户名唯一'                                                             -- 确保用户名唯一
);

-- 创建邮箱和手机号唯一索引
CREATE UNIQUE INDEX idx_user_email ON user (email) COMMENT '确保邮箱唯一';
CREATE UNIQUE INDEX idx_user_phone ON user (phone) COMMENT '确保手机号唯一';

-- 创建动物表
CREATE TABLE animal
(
    id              INT AUTO_INCREMENT PRIMARY KEY COMMENT '动物ID，主键',                                  -- 动物ID，主键
    name            VARCHAR(50)             NOT NULL COMMENT '动物的名字',                                 -- 动物名字
    species         VARCHAR(50)             NOT NULL COMMENT '动物物种',                                   -- 动物物种（如：猫、狗等）
    age             INT COMMENT '动物年龄',                                                                -- 动物年龄
    gender          ENUM ('male', 'female') NOT NULL COMMENT '动物性别',                                   -- 动物性别，male 或 female
    description     TEXT COMMENT '动物的描述',                                                             -- 动物的详细描述（性格、特征等）
    health_status   VARCHAR(100) COMMENT '动物健康状况',                                                   -- 动物的健康状况
    adoption_status INT      DEFAULT 0 COMMENT '动物领养状态，0 表示可领养，1 表示已领养',                   -- 动物的领养状态
    image_url       VARCHAR(255) COMMENT '动物图片的URL',                                                  -- 动物图片的URL
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '动物记录创建时间',                         -- 记录创建时间
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间', -- 记录更新时间
    deleted_at      DATETIME                NULL COMMENT '软删除时间，标记动物记录删除',                    -- 软删除时间（标记删除）
    UNIQUE (name) COMMENT '确保动物名称唯一'                                                               -- 确保动物名称唯一
);

-- 创建领养表
CREATE TABLE application
(
    id                 INT AUTO_INCREMENT PRIMARY KEY COMMENT '申请ID，主键',                                 -- 主键
    user_id            INT      NOT NULL COMMENT '申请用户ID，关联user表',                                    -- 用户ID
    animal_id          INT      NOT NULL COMMENT '申请领养的动物ID，关联animal表',                            -- 动物ID
    application_reason TEXT COMMENT '用户申请理由（如喜爱动物、有经验等）',                                     -- 用户填写的领养理由
    status             INT      DEFAULT 0 COMMENT '申请状态，0：待审核，1：通过，2：拒绝，3：已撤回',                -- 申请状态
    review_comments    TEXT COMMENT '审核备注（管理员审批意见）',                                              -- 管理员备注
    reviewed_by        INT COMMENT '审核管理员ID，关联user表',                                                -- 审核人ID
    applicationTime    DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '申请提交时间',                            -- 提交申请时间
    reviewTime         DATETIME COMMENT '审核时间',                                                          -- 审核时间
    createdTime        DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',                            -- 创建时间
    updatedTime        DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',-- 更新时间
    deletedTime        DATETIME NULL COMMENT '软删除时间'                                                   -- 软删除时间（标记删除）
);





