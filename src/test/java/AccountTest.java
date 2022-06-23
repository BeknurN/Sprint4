import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                //проверка пустой строки
                {" ", false}, //пустая строка
                {"Нармуханбекнур", false},//0 пробелов
                {"Нармухан Бекнур", true},//1 пробел
                {"Первый нармухан бекнур", false},//2 пробела
                {" Бекнур", false},//пробел в начале
                {"Бекнур ", false},//пробел в конце
                {" Бекнур ", false},//пробелы и в начале и в конце
                {"Нармухан Бекнур", true},//пробел в середине
                {" Нармухан Бекнур ", false},//пробелы в начале, в середине и в конце
                {"Бе", false},//2 символа
                {"Б н", true},//3 символа
                {"Нармухан Бекнураааа", true},//19 символа
                {"Нармухаааааан Бекнур", false},//20 символа
        };
    }

    @Test
    public void spaceTest() {
        assertEquals(name, new Account(name).checkNameToEmboss(), expectedResult);
    }
}