package io.geekidea.springbootplus.foobar.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.geekidea.springbootplus.foobar.entity.MyTest;
import io.geekidea.springbootplus.foobar.param.MyTestQueryParam;
import io.geekidea.springbootplus.foobar.vo.MyTestQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 *  Mapper 接口
 * </pre>
 *
 * @author geekidea
 * @since 2019-11-04
 */
@Repository
public interface MyTestMapper extends BaseMapper<MyTest> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    MyTestQueryVo getMyTestById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param myTestQueryParam
     * @return
     */
    IPage<MyTestQueryVo> getMyTestPageList(@Param("page") Page page, @Param("param") MyTestQueryParam myTestQueryParam);

}
