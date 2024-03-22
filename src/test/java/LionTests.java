import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;

    private final String lionSexExceptionText = "Используйте допустимые значения пола животного - самец или самка";

    @Test
    public void getKittensInvokedTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(lion.getFood(), feline.getFood("Хищник"));
    }

    @Test
    public void getFoodInvokedTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void lionSexExceptionTest() {
        try {
            Lion lion = new Lion("ИнстаСамка", feline);
        } catch (Exception exception) {
            Assert.assertEquals(lionSexExceptionText, exception.getMessage());
        }
    }

}