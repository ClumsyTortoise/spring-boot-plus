package io.geekidea.springbootplus.foobar.service.impl;

import io.geekidea.springbootplus.foobar.entity.MyTest;
import io.geekidea.springbootplus.foobar.mapper.MyTestMapper;
import io.geekidea.springbootplus.foobar.service.MyTestService;
import io.geekidea.springbootplus.foobar.param.MyTestQueryParam;
import io.geekidea.springbootplus.foobar.vo.MyTestQueryVo;
import io.geekidea.springbootplus.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.common.vo.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 *  服务实现类
 * </pre>
 *
 * @author geekidea
 * @since 2019-11-04
 */
@Slf4j
@Service
public class MyTestServiceImpl extends BaseServiceImpl<MyTestMapper, MyTest> implements MyTestService {

    @Autowired
    private MyTestMapper myTestMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMyTest(MyTest myTest) throws Exception {
        return super.save(myTest);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMyTest(MyTest myTest) throws Exception {
        return super.updateById(myTest);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMyTest(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public MyTestQueryVo getMyTestById(Serializable id) throws Exception {
        return myTestMapper.getMyTestById(id);
    }

    @Override
    public PageInfo<MyTestQueryVo> getMyTestPageList(MyTestQueryParam myTestQueryParam) throws Exception {
        Page page = setPageParam(myTestQueryParam, OrderItem.desc("create_time"));
        IPage<MyTestQueryVo> iPage = myTestMapper.getMyTestPageList(page, myTestQueryParam);
        return PageInfo.build(iPage);
    }

}
