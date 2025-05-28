package com.KevinCx.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询
 * @author KevinCx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {
	private int pageNum;
	private int pageSize;
}
