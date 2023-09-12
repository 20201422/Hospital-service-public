package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.List;

public class NumberSourcePool {
  private final GenericObjectPool<List<NumberSourceDetail>> pool;  // 号源池

  /**
   * 初始化号源池
   */
  public NumberSourcePool(List<NumberSourceDetail> detailList) {
    // 定义对象池配置
    NumberSourcePoolFactory factory = new NumberSourcePoolFactory(detailList);
    GenericObjectPoolConfig<List<NumberSourceDetail>> config = new GenericObjectPoolConfig<>();
    config.setMaxTotal(10);  // 池中最大对象数
    config.setMaxIdle(5);    // 池中最大空闲对象数
    config.setMinIdle(1);    // 池中最小空闲对象数
    config.setBlockWhenExhausted(true);  // 池中对象耗尽时是否阻塞
    config.setMaxWaitMillis(1000);       // 最大等待时间（毫秒）

    // 创建号源池对象
    this.pool = new GenericObjectPool<>(factory, config);
  }
  /**
   * 获取一个空闲的号源对象
   *
   * @return 号源对象
   * @throws Exception
   */
  public NumberSourceDetail getNumberSource() throws Exception {
    List<NumberSourceDetail> detailList = pool.borrowObject();
    return detailList.get(0);
  }

  /**
   * 释放号源对象
   *
   * @param detailList 号源对象
   */
  public void releaseNumberSource(List<NumberSourceDetail> detailList) {
    pool.returnObject(detailList);
  }

  /**
   * 销毁号源池对象
   */
  public void destroy() {
    pool.close();
  }

}
