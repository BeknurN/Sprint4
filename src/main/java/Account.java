import org.apache.commons.lang3.StringUtils;
public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;

    }



    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        // проверка пустой строки и null
        if(StringUtils.isBlank(name)){
            return false;
        }
        int spaceCount = StringUtils.countMatches(name, " ");
        return name.length() >= 3 && name.length() <= 19 && spaceCount == 1 && !(name.startsWith(" ") | name.endsWith(" "));
    }

}