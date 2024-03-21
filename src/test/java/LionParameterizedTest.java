import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String lionSexExceptionText = "Используйте допустимые значения пола животного - самец или самка";
    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTopPageOrderButton() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"ИнстаСамка", false},
        };
    }

    @Test
    public void doesHaveManeReturnCorrectValue() {
        try {
            Lion lion = new Lion(sex);
            lion.doesHaveMane();
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals(lionSexExceptionText, exception.getMessage());
        }
    }

}