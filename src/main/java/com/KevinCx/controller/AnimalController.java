package com.KevinCx.controller;

import com.KevinCx.domain.dto.AnimalDTO;
import com.KevinCx.domain.query.AnimalQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.result.Result;
import com.KevinCx.domain.vo.AnimalVO;
import com.KevinCx.service.IAnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
@Slf4j
@Tag(name = "动物相关接口")
public class AnimalController {

	@Autowired
	private IAnimalService animalService;

	/**
	 * 添加动物
	 * @return
	 */
	@Operation(summary = "添加动物")
	@PostMapping("/add")
	public Result<AnimalVO> add(@RequestBody AnimalDTO animalDTO){
		log.info("添加动物,{}",animalDTO);
		AnimalVO animalVO = animalService.add(animalDTO);
		return Result.success(animalVO);
	}

	/**
	 * 根据id查询动物
	 * @param id
	 * @return
	 */
	@Operation(summary = "根据id查询动物")
	@GetMapping("/id")
	public Result<AnimalVO> getById(Long id){
		log.info("根据id查询动物,{}",id);

		try{
			AnimalVO animalVO = animalService.getById(id);
			return Result.success(animalVO);
		}catch (Exception e){
			return Result.error(e.getMessage());
		}
	}

	/**
	 * 修改动物信息
	 * @return
	 */
	@Operation(summary = "修改动物信息")
	@PutMapping("/animal")
	public Result changeAniInfo(@RequestBody AnimalDTO animalDTO){
		log.info("修改动物信息,{}",animalDTO);

		animalService.changeAniInfo(animalDTO);
		return Result.success();
	}

	/**
	 * 删除动物信息
	 * @param id
	 * @return
	 */
	@Operation(summary = "删除动物")
	@DeleteMapping("/delete")
	public Result deleteAni(Long id){
		log.info("删除动物信息,{}",id);
		animalService.deleteAni(id);
		return Result.success();
	}


	/**
	 * 分页查询文章列表
	 * @param animalQuery
	 * @return
	 */
	@Operation(summary = "分页查询动物列表")
	@PostMapping("/page")
	public Result<PageResult> page(@RequestBody AnimalQuery animalQuery){
		log.info("分页查询文章列表,{}",animalQuery);
		PageResult list = animalService.page(animalQuery);

		return Result.success(list);
	}
}
