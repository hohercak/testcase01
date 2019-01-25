package testcase01;

import org.junit.Assert;
import testcase01.entity.CacheableEntity;
import testcase01.entity.CacheableEntityId;
import testcase01.repository.TestcaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestcaseApplicationTests {

	private static final Logger LOGGER = Logger.getLogger(TestcaseApplicationTests.class.getName());

	@Autowired
	private TestcaseRepository testcaseRepository;

	@Test
	public void contextLoads() {
		CacheableEntityId id = new CacheableEntityId(1, 1);
		testcaseRepository.persistData(new CacheableEntity(id));
		CacheableEntity loaded = testcaseRepository.findData(id);
		long secondLevelCacheHitCount = testcaseRepository.getSecondLevelCacheHitCount();

		// test failed when second level cache was not hit
		Assert.assertEquals("second level cache was not hit",  1, secondLevelCacheHitCount);
	}

}

