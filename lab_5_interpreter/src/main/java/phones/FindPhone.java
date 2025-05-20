package phones;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class FindPhone {
    private List<Phone> data = new PhoneDB().getPhoneData(); // Источник данных
    // Основной метод поиска с использованием интерпретатора
    public List<Phone> find(Tag tag) {
        List<Phone> result = new LinkedList<>();
        for (Phone ph : data) {
            if (tag.find(ph)) {// Интерпретация условия для каждого телефона
                result.add(ph);
            }
        }
        return result;
    }

    // Старые методы оставлены для обратной совместимости, но теперь они используют новый подход
// Примеры готовых запросов (используют интерпретатор)
    public List<Phone> byColor(Color col) {
        return find(new ColorTag(col));
    }

    public List<Phone> byModel(String mod) {
        return find(new ModelTag(mod));
    }

    public List<Phone> byMSize(int memSize) {
        return find(new MemorySizeTag(memSize));
    }

    public List<Phone> byModelAndPriceLow(String mod, double price) {
        return find(new AndTag(
                new ModelTag(mod),
                new PriceLowerTag(price)
        ));
    }

    public List<Phone> byMSizeAndNotColor(int memSize, Color col) {
        return find(new AndTag(
                new MemorySizeTag(memSize),
                new NotTag(new ColorTag(col))
        ));
    }
}
