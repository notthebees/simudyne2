package simulation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrandFactorTest {
    @Test
    public void calculatesBrandFactorCorrectly() throws Exception {
        assertThat(BrandFactor.calculate(1), equalTo(0.1));
        assertThat(BrandFactor.calculate(3), equalTo(0.5));
        assertThat(BrandFactor.calculate(15), equalTo(2.9));
    }
}