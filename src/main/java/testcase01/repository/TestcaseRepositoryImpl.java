package testcase01.repository;

import testcase01.entity.CacheableEntity;
import testcase01.entity.CacheableEntityId;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TestcaseRepositoryImpl implements TestcaseRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void persistData(CacheableEntity entity) {
    entityManager.persist(entity);
  }

  @Override
  public CacheableEntity findData(CacheableEntityId id) {
    return entityManager.find(CacheableEntity.class, id);
  }

  @Override
  public long getSecondLevelCacheHitCount() {
    Session session = entityManager.unwrap(Session.class);
    Statistics statistics = session.getSessionFactory().getStatistics();
    return statistics.getSecondLevelCacheHitCount();
  }
}
