package testcase01.repository;

import testcase01.entity.CacheableEntity;
import testcase01.entity.CacheableEntityId;

public interface TestcaseRepository {

  void persistData(CacheableEntity entity);

  CacheableEntity findData(CacheableEntityId id);

  long getSecondLevelCacheHitCount();
}
