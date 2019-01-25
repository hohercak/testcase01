package testcase01.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Immutable
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class CacheableEntity {

  @EmbeddedId
  CacheableEntityId id;

  public CacheableEntity() {
  }

  public CacheableEntity(CacheableEntityId id) {
    this.id = id;
  }

  public CacheableEntityId getId() {
    return id;
  }

  public void setId(CacheableEntityId id) {
    this.id = id;
  }
}
