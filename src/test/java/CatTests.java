import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnCorrectValue() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodInvokedTest() throws Exception{
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}