package phones.tags;
import phones.Phone;
import java.awt.Color;

public abstract class Tag {
    public abstract boolean find(Phone ph);
}

// Реализации для различных критериев поиска
class ColorTag extends Tag {
    private Color color;

    public ColorTag(Color color) {
        this.color = color;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getColor() == color;
    }
}

class ModelTag extends Tag {
    private String model;

    public ModelTag(String model) {
        this.model = model;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getModel().equalsIgnoreCase(model);
    }
}

class MemorySizeTag extends Tag {
    private int memorySize;

    public MemorySizeTag(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getMemorySize() == memorySize;
    }
}

class PriceLowerTag extends Tag {
    private double price;

    public PriceLowerTag(double price) {
        this.price = price;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getPrice() < price;
    }
}

class NotTag extends Tag {
    private Tag tag;

    public NotTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean find(Phone ph) {
        return !tag.find(ph);
    }
}

class AndTag extends Tag {
    private Tag left;
    private Tag right;

    public AndTag(Tag left, Tag right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean find(Phone ph) {
        return left.find(ph) && right.find(ph);
    }
}
