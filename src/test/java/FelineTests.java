import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    Feline feline;

    @Mock
    Animal animal;

    @Test
    public void eatMeatReturnCorrectValue() throws Exception {
        Feline feline = new Feline();
        Mockito.when(animal.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(feline.eatMeat(), animal.getFood("Хищник"));
    }

    @Test
    public void eatMeatInvokedTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnCorrectValue() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(feline.getKittens(), feline.getKittens(1));
    }

    @Test
    public void getKittensInvokedTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithKittensCountReturnCorrectValue() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens(1));
    }

}