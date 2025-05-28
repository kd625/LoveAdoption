package com.KevinCx.controller;


import com.KevinCx.domain.dto.ApplicationDTO;
import com.KevinCx.domain.query.ApplicationQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.result.Result;
import com.KevinCx.domain.vo.ApplicationVO;
import com.KevinCx.service.IApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/application")
@Tag(name = "申请领养相关接口")
public class ApplicationController {

	@Autowired
	private IApplicationService applicationService;


	//todo 待测试
	@Operation(summary = "申请领养表分页查询")
	@PostMapping("/page")
	public Result<PageResult> page(@RequestBody ApplicationQuery applicationQuery){
		log.info("申请领养表分页查询,{}",applicationQuery);
		PageResult pageResult = applicationService.page(applicationQuery);

		return Result.success(pageResult);
	}

	/**
	 * 申请领养表新增
	 * @param applicationDTO
	 * @return
	 */
	@Operation(summary = "申请领养表新增")
	@PostMapping("/add")
	public Result add(@RequestBody ApplicationDTO applicationDTO){
		log.info("申请领养表新增");
		applicationService.add(applicationDTO);

		return Result.success();
	}

	/**
	 * 根据ID查询申请领养表
	 * @param id
	 * @return
	 */
	@Operation(summary = "根据ID查询申请领养表")
	@GetMapping("/getById")
	public Result<ApplicationVO> getById(Long id){
		log.info("根据ID查询申请领养表,{}",id);
		try {
			ApplicationVO applicationVO = applicationService.getById(id);
			return Result.success(applicationVO);
		}catch (Exception e){
			return Result.error("查询失败"+e.getMessage());
		}
	}

	/**
	 * 根据ID删除申请领养表
	 * @param id
	 * @return
	 */
	@Operation(summary = "用户撤回申请领养表")
	@DeleteMapping("/delete")
	public Result delete(Long id){
		log.info("用户撤回申请领养表,{}",id);
		try {
			applicationService.delete(id);
			return Result.success();
		}catch (Exception e){
			return Result.error("删除失败"+e.getMessage());
		}
	}

	/**
	 * 修改申请领养表
	 * @param applicationDTO
	 * @return
	 */
	@Operation(summary = "修改申请领养表")
	@PostMapping("/update")
	public Result<ApplicationVO> update(@RequestBody ApplicationDTO applicationDTO){
		log.info("修改申请领养表,{}",applicationDTO);

		ApplicationVO applicationVO = applicationService.update(applicationDTO);
		return Result.success(applicationVO);
	}

}
