package crystalrace.model;

public class NormalCell extends Cell{

    public NormalCell(int number) {
        super(number);
    }

    @Override
    public int destination() {
        return getNumber();
    }

    @Override
    public String description() {
        return "Casa normal";
    }
}
