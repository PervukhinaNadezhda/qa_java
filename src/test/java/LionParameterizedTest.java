import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Test {index}: doesHaveManeReturnCorrectValue() for:   {0}")
    public static Object[][] getTopPageOrderButton() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
            Lion lion = new Lion(sex, feline);
            lion.doesHaveMane();
            Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

}