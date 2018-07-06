package com.dss.girl.controller;

import com.dss.girl.Exception.GirlException;
import com.dss.girl.domain.Girl;
import com.dss.girl.domain.Result;
import com.dss.girl.enums.ResultEnum;
import com.dss.girl.repository.GirlRepository;
import com.dss.girl.service.GirlService;
import com.dss.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;

	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

	/**
	 * 查询所有女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/girlList")
	public List<Girl> girlList() {
		logger.info("====girlList====");
		return girlRepository.findAll();
	}

	/**
	 * 新增一个女生 BindingResult表示在表单验证是绑定的错误
	 * 
	 * @param girl
	 * @return
	 */
	@PostMapping(value = "/girlAdd")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {

		Result result = new Result();

		if (bindingResult.hasErrors()) {
			return ResultUtil.retrunResult(ResultEnum.VERIFY_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage(), null);
		}

		return ResultUtil.retrunResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),
				girlRepository.save(girl));
	}

	/**
	 * 通过id查询一个女生
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getGirlById/{id}")
	public Girl getGirlById(@PathVariable("id") Integer id) {
		return girlRepository.findById(id).get();
	}

	/**
	 * 通过id更新一个女生
	 * 
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/updateGirl/{id}")
	public Girl updateGirl(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {

		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);

		return girlRepository.save(girl);
	}

	/**
	 * 通过id删除一个女生
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/deleteGirl/{id}")
	public void deleteGirl(@PathVariable("id") Integer id) {
		Girl girl = new Girl();
		girl.setId(id);
		girlRepository.delete(girl);
	}

	/**
	 * 通过年龄查询女生
	 * 
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/findGirlByAge/{age}")
	public List<Girl> findGirlByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}

	/**
	 * 一次性插入两个女生
	 */
	@PostMapping(value = "/insertTwoGril")
	public void insertTwoGril() {
		girlService.insertTwoGirl();
	}

	@GetMapping(value = "/getAgeById/{id}")
	public void getAgeById(@PathVariable("id") Integer id) throws GirlException {
		girlService.getAgeById(id);
	}
}
