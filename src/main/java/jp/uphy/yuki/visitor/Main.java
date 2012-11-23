package jp.uphy.yuki.visitor;

public class Main {
    public static void main(final String[] args) {
        try {
            System.out.println("Making root entries...");
            final Directory rootdir = new Directory("root");
            final Directory bindir = new Directory("bin");
            final Directory tmpdir = new Directory("tmp");
            final Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());              

            System.out.println("");
            System.out.println("Making user entries...");
            final Directory yuki = new Directory("yuki");
            final Directory hanako = new Directory("hanako");
            final Directory tomura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());              
        } catch (final FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
