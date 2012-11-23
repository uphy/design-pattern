package jp.uphy.yuki.visitor;

public class File extends Entry {
    private final String name;
    private final int size;
    public File(final String name, final int size) {
        this.name = name;
        this.size = size;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
