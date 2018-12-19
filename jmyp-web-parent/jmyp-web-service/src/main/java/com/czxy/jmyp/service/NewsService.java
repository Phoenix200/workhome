package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.NewsMapper;
import com.czxy.jmyp.pojo.News;
import com.czxy.jmyp.vo.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName NewsService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 16:02
 * @Version 1.0
 **/
@Service
public class NewsService  {
    @Resource
    private NewsMapper newsMapper;
    /**
     *  查询快报
     * @param pageRequest 参数对像
     * @return
     */
    public PageInfo<News> findNewByPage(PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getPerPage());

        Example example =new Example(News.class);
        if ("asc".equals(pageRequest.getSortWay())){
            example.setOrderByClause("created_at asc");
        } else {
            example.setOrderByClause("created_at desc");
        }
        List<News> list =newsMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
}
