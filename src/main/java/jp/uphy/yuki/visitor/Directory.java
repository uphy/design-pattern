package jp.uphy.yuki.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private final String name;                    // ディレクトリの名前
    private final ArrayList dir = new ArrayList();      // ディレクトリエントリの集合
    public Directory(final String name) {         // コンストラクタ
        this.name = name;
    }
    @Override
    public String getName() {               // 名前を得る
        return name;
    }
    @Override
    public int getSize() {                  // サイズを得る
        int size = 0;
        final Iterator it = dir.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    @Override
    public Entry add(final Entry entry) {         // エントリの追加
        dir.add(entry);
        return this;
    }
    @Override
    public Iterator iterator() {      // Iteratorの生成
        return dir.iterator();
    }
    @Override
    public void accept(final Visitor v) {         // 訪問者の受け入れ
        v.visit(this);
    }
}
