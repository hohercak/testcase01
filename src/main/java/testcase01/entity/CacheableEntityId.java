package testcase01.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CacheableEntityId implements Serializable {

  private static final long serialVersionUID = 1L;

  private int a;
  private int b;

  public CacheableEntityId() {
  }

  public CacheableEntityId(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  public int getB() {
    return b;
  }

  public void setB(int b) {
    this.b = b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CacheableEntityId)) return false;

    CacheableEntityId that = (CacheableEntityId) o;

    if (a != that.a) return false;
    return b == that.b;
  }

  @Override
  public int hashCode() {
    int result = a;
    result = 31 * result + b;
    return result;
  }
}
