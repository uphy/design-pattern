/**
 * Copyright (C) 2012 uphy.jp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.uphy.yuki.visitor;

import java.util.Iterator;


/**
 * @author Yuhi Ishikura
 */
public class Dame {

  public static void main(String[] args) {
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
    listDirectory(rootdir);

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
    listDirectory(rootdir);
    System.out.println("File Count     : " + countFiles(rootdir));
    System.out.println("Directory Count: " + countDirectories(rootdir));
  }

  private static int countDirectories(Entry entry) {
    if (entry instanceof File) {
      return 0;
    } else {
      Iterator<?> iterator = entry.iterator();
      int sum = 1;
      while (iterator.hasNext()) {
        Entry child = (Entry)iterator.next();
        sum += countDirectories(child);
      }
      return sum;
    }
  }

  private static int countFiles(Entry entry) {
    if (entry instanceof File) {
      return 1;
    } else {
      Iterator<?> iterator = entry.iterator();
      int sum = 0;
      while (iterator.hasNext()) {
        Entry child = (Entry)iterator.next();
        sum += countFiles(child);
      }
      return sum;
    }
  }

  private static void listDirectory(Entry currentdir) {
    listDirectory("", currentdir);
  }

  private static void listDirectory(String parentPath, Entry current) {
    String currentPath = parentPath + "/" + current.getName();
    System.out.println(currentPath +"  ("+ current.getSize()+")");
    if (current instanceof Directory) {
      Iterator<?> iterator = current.iterator();
      while (iterator.hasNext()) {
        Entry entry = (Entry)iterator.next();
        listDirectory(currentPath, entry);
      }
    }
  }
}
