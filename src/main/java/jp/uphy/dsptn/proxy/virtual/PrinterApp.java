/**
 * Copyright (C) 2013 uphy.jp
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
package jp.uphy.dsptn.proxy.virtual;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * @author yuhi
 */
public class PrinterApp {

  @SuppressWarnings("serial")
  public static void main(String[] args) {
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(0, 1));
    frame.add(new JButton(new AbstractAction("Direct") {

      @Override
      public void actionPerformed(ActionEvent e) {
        launch(false);
      }
    }));
    frame.add(new JButton(new AbstractAction("Via Proxy") {

      @Override
      public void actionPerformed(ActionEvent e) {
        launch(true);
      }
    }));
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }

  static void launch(final boolean viaProxy) {
    new Thread() {

      /**
       * {@inheritDoc}
       */
      @Override
      public void run() {
        final Printer printer = viaProxy ? new VirtualPrinter() : new RealPrinter();
        final PrinterView view = new PrinterView(printer);
        view.launch();
      }
    }.start();
  }

}
