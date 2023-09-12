package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

import com.coop.tripleunionhospitalregistrationsystemservice.entity.model.NumberSourceDetail;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.List;

public class NumberSourcePoolFactory implements PooledObjectFactory<List<NumberSourceDetail>> {
  private final List<NumberSourceDetail> numberSourceDetails;
  public NumberSourcePoolFactory(List<NumberSourceDetail> numberSourceDetails) {
    this.numberSourceDetails = numberSourceDetails;
  }
  @Override
  public PooledObject<List<NumberSourceDetail>> makeObject() throws Exception {
    return new DefaultPooledObject<>(numberSourceDetails);
  }

  @Override
  public void destroyObject(PooledObject pooledObject) throws Exception {

  }

  @Override
  public void destroyObject(PooledObject p, DestroyMode mode) throws Exception {
    PooledObjectFactory.super.destroyObject(p, mode);
  }

  @Override
  public boolean validateObject(PooledObject pooledObject) {
    return true;
  }

  @Override
  public void activateObject(PooledObject pooledObject) throws Exception {

  }

  @Override
  public void passivateObject(PooledObject pooledObject) throws Exception {

  }
}
