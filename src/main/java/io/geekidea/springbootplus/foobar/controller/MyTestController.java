package io.geekidea.springbootplus.foobar.controller;

import io.geekidea.springbootplus.common.api.ApiResult;
import io.geekidea.springbootplus.common.controller.BaseController;
import io.geekidea.springbootplus.common.vo.PageInfo;
import io.geekidea.springbootplus.foobar.entity.MyTest;
import io.geekidea.springbootplus.foobar.param.MyTestQueryParam;
import io.geekidea.springbootplus.foobar.service.MyTestService;
import io.geekidea.springbootplus.foobar.vo.MyTestQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <pre>
 *  前端控制器
 * </pre>
 *
 * @author geekidea
 * @since 2019-11-04
 */
@Slf4j
@RestController
@RequestMapping("/myTest")
@Api(" API")
public class MyTestController extends BaseController {

    @Autowired
    private MyTestService myTestService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加MyTest对象", notes = "添加")
    public ApiResult<Boolean> addMyTest(@Valid @RequestBody MyTest myTest) throws Exception {
        boolean flag = myTestService.saveMyTest(myTest);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改MyTest对象", notes = "修改")
    public ApiResult<Boolean> updateMyTest(@Valid @RequestBody MyTest myTest) throws Exception {
        boolean flag = myTestService.updateMyTest(myTest);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除MyTest对象", notes = "删除")
    public ApiResult<Boolean> deleteMyTest(@PathVariable("id") Long id) throws Exception {
        boolean flag = myTestService.deleteMyTest(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取MyTest对象详情", notes = "查看")
    public ApiResult<MyTestQueryVo> getMyTest(@PathVariable("id") Long id) throws Exception {
        MyTestQueryVo myTestQueryVo = myTestService.getMyTestById(id);
        return ApiResult.ok(myTestQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取MyTest分页列表", notes = "分页列表")
    public ApiResult<PageInfo<MyTestQueryVo>> getMyTestPageList(@Valid @RequestBody MyTestQueryParam myTestQueryParam) throws Exception {
        PageInfo<MyTestQueryVo> pageInfo = myTestService.getMyTestPageList(myTestQueryParam);
        return ApiResult.ok(pageInfo);
    }

}

