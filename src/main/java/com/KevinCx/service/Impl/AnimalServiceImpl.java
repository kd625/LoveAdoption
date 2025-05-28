package com.KevinCx.service.Impl;

import com.KevinCx.domain.dto.AnimalDTO;
import com.KevinCx.domain.pojo.Animal;
import com.KevinCx.domain.query.AnimalQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.vo.AnimalVO;
import com.KevinCx.mapper.AnimalMapper;
import com.KevinCx.service.IAnimalService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private AnimalMapper animalMapper;

	/**
	 * 新增动物信息
	 * @param animalDTO
	 * @return
	 */
	@Override
	public AnimalVO add(AnimalDTO animalDTO) {
		Animal animal = new Animal();
		BeanUtils.copyProperties(animalDTO, animal);

		animal.setCreatedTime(LocalDateTime.now());
		animal.setUpdatedTime(LocalDateTime.now());
		animal.setAdoptionStatus(Animal.ADOPTION_STATUS_UNADOPTED);

		animalMapper.add(animal);

		AnimalVO animalVO = new AnimalVO();
		BeanUtils.copyProperties(animal, animalVO);
		return animalVO;
	}

	/**
	 * 根据id查询动物信息
	 * @param id
	 * @return
	 */
	@Override
	public AnimalVO getById(Long id) {
		Animal animal = animalMapper.getById(id);
		if (animal == null){
			throw new RuntimeException("查询不到对应动物");
		}
		AnimalVO animalVO = new AnimalVO();
		BeanUtils.copyProperties(animal,animalVO);

		return animalVO;
	}

	/**
	 * 修改动物信息
	 * @param animalDTO
	 * @return
	 */
	@Override
	public void changeAniInfo(AnimalDTO animalDTO) {
		Animal animal = new Animal();
		BeanUtils.copyProperties(animalDTO, animal);
		animal.setUpdatedTime(LocalDateTime.now());

		animalMapper.putById(animal);
	}

	/**
	 * 删除动物信息
	 * @param id
	 */
	@Override
	public void deleteAni(Long id) {
		Animal animal = animalMapper.getById(id);
		if (animal == null || animal.getAdoptionStatus().equals(Animal.ADOPTION_STATUS_DELETED)){
			throw new RuntimeException("查询不到对应动物");
		}

		Animal animal1 = new Animal();
		animal1.setId(id);
		animal1.setDeletedTime(LocalDateTime.now());
		animal1.setAdoptionStatus(Animal.ADOPTION_STATUS_DELETED);
		animalMapper.putById(animal1);
	}

	/**
	 * 分页查询动物信息
	 * @param animalQuery
	 * @return
	 */
	@Override
	public PageResult page(AnimalQuery animalQuery) {
		PageHelper.startPage(animalQuery.getPageNum(), animalQuery.getPageSize());
		Page<Animal> page = animalMapper.page(animalQuery);

		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		return pageResult;
	}
}
