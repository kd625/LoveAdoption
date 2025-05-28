package com.KevinCx.controller;

import com.KevinCx.domain.dto.ApplicationAdminDTO;
import com.KevinCx.domain.query.ApplicationQuery;
import com.KevinCx.domain.query.UserQuery;
import com.KevinCx.domain.result.PageResult;
import com.KevinCx.domain.result.Result;
import com.KevinCx.domain.vo.ApplicationVO;
import com.KevinCx.service.IApplicationService;
import com.KevinCx.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员相关接口
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "管理员相关接口")
@Slf4j
public class AdminController {

	@Autowired
	private IApplicationService applicationService;
	@Autowired
	private IUserService userService;

	//todo 待测试
	@Operation(summary = "申请领养表分页查询")
	@PostMapping("/page")
	public Result<PageResult> page(@RequestBody ApplicationQuery applicationQuery){
		log.info("申请领养表分页查询,{}",applicationQuery);
		PageResult pageResult = applicationService.page(applicationQuery);

		return Result.success(pageResult);
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
	@Operation(summary = "删除申请领养表")
	@DeleteMapping("/delete")
	public Result delete(Long id){
		log.info("根据ID删除申请领养表,{}",id);
		try {
			applicationService.delete(id);
			return Result.success();
		}catch (Exception e){
			return Result.error("删除失败"+e.getMessage());
		}
	}

	//todo 待测试
	/**
	 * 管理员审核申请
	 * @param applicationAdminDTO
	 * @return
	 */
	@Operation(summary = "管理员同意审核申请")
	@PostMapping("/admitApplication")
	public Result admitApplication(@RequestBody ApplicationAdminDTO applicationAdminDTO){
		log.info("管理员同意审核申请,{}",applicationAdminDTO);
		applicationService.admitApplication(applicationAdminDTO);

		return Result.success();
	}


	/**
	 * 管理员拒绝审核申请
	 * @param applicationAdminDTO
	 * @return
	 */
	@Operation(summary = "管理员拒绝审核申请")
	@PostMapping("/rejectApplication")
	public Result rejectApplication(@RequestBody ApplicationAdminDTO applicationAdminDTO){
		log.info("管理员拒绝审核申请,{}",applicationAdminDTO);
		applicationService.rejectApplication(applicationAdminDTO);
		return Result.success();
	}

	/**
	 * 用户分页查询
	 * 管理员可以根据用户名、邮箱、手机号、角色、状态等条件进行查询
	 * @param userQuery
	 * @return
	 */
	@Operation(summary = "用户分页查询")
	@PostMapping("/pageUser")
	public Result<PageResult> pageUser(@RequestBody UserQuery userQuery){
		log.info("用户分页查询,{}",userQuery);
		return Result.success(userService.page(userQuery));
	}

	@Operation(summary = "冻结用户")
	@PostMapping("/freezeUser")
	public Result freezeUser(Long id){
		log.info("冻结用户,{}",id);
		userService.freezeUser(id);
		return Result.success();
	}

	/**
	 * 解冻用户
	 * @param id
	 * @return
	 */
	@Operation(summary = "解冻用户")
	@PostMapping("/unfreezeUser")
	public Result unfreezeUser(Long id){
		log.info("解冻用户,{}",id);
		userService.unfreezeUser(id);
		return Result.success();
	}

}
