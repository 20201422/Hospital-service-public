package com.coop.tripleunionhospitalregistrationsystemservice.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * @description: 批量插入 SQL 注入器
 **/
public class InsertBatchSqlInjector extends DefaultSqlInjector {

  @Override
  public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
    // super.getMethodList() 保留 Mybatis Plus 自带的方法
    List<AbstractMethod> methodList = super.getMethodList(mapperClass);
    // 添加自定义方法：批量插入，方法名为 insertBatchSomeColumn
    methodList.add(new InsertBatchSomeColumn());
    return methodList;
  }
}