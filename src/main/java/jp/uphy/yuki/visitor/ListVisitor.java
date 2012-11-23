package jp.uphy.yuki.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";                         // 現在注目しているディレクトリ名
    @Override
    public void visit(final File file) {                  // ファイルを訪問したときに呼ばれる
        System.out.println(currentdir + "/" + file);
    }
    @Override
    public void visit(final Directory directory) {   // ディレクトリを訪問したときに呼ばれる
        System.out.println(currentdir + "/" + directory);
        final String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        final Iterator it = directory.iterator();
        while (it.hasNext()) {
            final Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
