package com.KevinCx.service;

import com.KevinCx.domain.dto.AnimalDTO;
import com.KevinCx.domain.query.AnimalQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.AnimalVO;

public interface IAnimalService {

	AnimalVO add(AnimalDTO animalDTO);

	AnimalVO getById(Long id);

	void changeAniInfo(AnimalDTO animalDTO);

	void deleteAni(Long id);

	PageResult page(AnimalQuery animalQuery);
}
