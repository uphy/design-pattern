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
package jp.uphy.dsptn.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 * @author Yuhi Ishikura Ishikura
 */
public class JButtonExample {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    JButton button = new JButton("Button");
    button.addActionListener(new MyButtonListener());
    frame.add(button);
    frame.pack();
    frame.setVisible(true);
  }

  static class MyButtonListener implements ActionListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(null, "Button pressed");
    }

  }

}
