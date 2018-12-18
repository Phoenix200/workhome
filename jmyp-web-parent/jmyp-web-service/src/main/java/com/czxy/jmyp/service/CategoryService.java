package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.CategoryMapper;
import com.czxy.jmyp.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 14:29
 * @Version 1.0
 **/
@Service
public class CategoryService  {

    @Resource
    private CategoryMapper categoryMapper;



    public List<Category> findAll(){
        // 1.查询所有，按照 parent_id 升序排序
        Example example = new Example(Category.class);
        example.setOrderByClause("parent_id asc");
        List<Category> temp = this.categoryMapper.selectByExample(example );

        // 2.1 记录所有父元素
        List<Category> list = new ArrayList<>();
        // 3.1 记录所有元素，方法子元素寻找到对应的父元素
        Map<Integer , Category> map = new HashMap<>();
        for (Category category : temp) {
            // 2.2 存放所有父元素
            if(category.getParentId() == 0){
                list.add( category);
            }

            //3.2 存储所有元素
            map.put(category.getId() , category);
            //3.3 获得当前元素的父元素，并添加到父元素的children集合中
            Category parentCategory = map.get(category.getParentId());
            if (parentCategory != null) {
                parentCategory.getChildren().add( category );
            }
        }


        return list;
    }
}
