package com.KevinCx.service;

import com.KevinCx.domain.dto.ApplicationAdminDTO;
import com.KevinCx.domain.dto.ApplicationDTO;
import com.KevinCx.domain.query.ApplicationQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.ApplicationVO;

public interface IApplicationService {
	PageResult page(ApplicationQuery applicationQuery);

	void add(ApplicationDTO applicationDTO);

	ApplicationVO getById(Long id);

	void delete(Long id);

	ApplicationVO update(ApplicationDTO applicationDTO);

	void admitApplication(ApplicationAdminDTO applicationAdminDTO);

	void rejectApplication(ApplicationAdminDTO applicationAdminDTO);
}
