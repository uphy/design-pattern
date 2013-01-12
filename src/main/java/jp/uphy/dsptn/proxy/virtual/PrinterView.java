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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * @author yuhi
 */
public class PrinterView {

  private Printer printer;
  private JFrame frame;
  private JTextField textField;

  /**
   * {@link PrinterView}オブジェクトを構築します。
   * 
   * @param printer
   */
  @SuppressWarnings("serial")
  public PrinterView(Printer printer) {
    this.printer = printer;
    this.frame = new JFrame("Printer App");
    this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.textField = new JTextField(20);
    this.frame.setLayout(new FlowLayout());
    this.frame.add(this.textField);
    this.frame.add(new JButton(new AbstractAction("Print") {

      @Override
      public void actionPerformed(ActionEvent e) {
        print();
      }
    }));
    this.frame.add(new JButton(new AbstractAction("Show Name") {

      @Override
      public void actionPerformed(ActionEvent e) {
        showPrinterName();
      }
    }));
    this.frame.pack();
    this.frame.setLocationByPlatform(true);
  }

  /**
   * 起動します。
   */
  public void launch() {
    this.frame.setVisible(true);
  }

  /**
   * 終了します。
   */
  public void exit() {
    this.frame.dispose();
  }

  void print() {
    final String text = this.textField.getText();
    this.printer.print(text);
  }
  
  void showPrinterName(){
    JOptionPane.showMessageDialog(this.frame, this.printer.getName());
  }

}
