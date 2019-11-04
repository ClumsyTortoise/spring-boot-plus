package io.geekidea.springbootplus.foobar.service;

import io.geekidea.springbootplus.foobar.entity.MyTest;
import io.geekidea.springbootplus.common.service.BaseService;
import io.geekidea.springbootplus.foobar.param.MyTestQueryParam;
import io.geekidea.springbootplus.foobar.vo.MyTestQueryVo;
import io.geekidea.springbootplus.common.vo.PageInfo;

import java.io.Serializable;

/**
 * <pre>
 *  服务类
 * </pre>
 *
 * @author geekidea
 * @since 2019-11-04
 */
public interface MyTestService extends BaseService<MyTest> {

    /**
     * 保存
     *
     * @param myTest
     * @return
     * @throws Exception
     */
    boolean saveMyTest(MyTest myTest) throws Exception;

    /**
     * 修改
     *
     * @param myTest
     * @return
     * @throws Exception
     */
    boolean updateMyTest(MyTest myTest) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMyTest(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MyTestQueryVo getMyTestById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param myTestQueryParam
     * @return
     * @throws Exception
     */
    PageInfo<MyTestQueryVo> getMyTestPageList(MyTestQueryParam myTestQueryParam) throws Exception;

}
