package com.KevinCx.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "la.jwt")
@Data
public class JwtProperties {

	// todo 这儿只弄了一个用户的jwt配置，后面可以扩展，比如管理员的jwt配置
	/**
	 * 用户生成jwt令牌相关配置
	 */
	private String userSecretKey;
	private long userTtl;
	private String userTokenName;

}
