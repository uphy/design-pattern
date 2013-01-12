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
package jp.uphy.dsptn.proxy.remote;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * @author yuhi
 */
public class ServerApp {

  public static final int DEFAULT_PORT = 12321;

  @SuppressWarnings("serial")
  public static void main(String[] args) {
    final JFrame frame = new JFrame("Server");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    final Display display = new LocalDisplay();
    final DisplayServer server = new DisplayServer(display);
    final JTextField portField = new JTextField(String.valueOf(DEFAULT_PORT));
    final JButton startButton = new JButton();
    final JButton stopButton = new JButton();

    startButton.setAction(new AbstractAction("Start") {

      @Override
      public void actionPerformed(ActionEvent e) {
        startButton.setEnabled(false);
        portField.setEnabled(false);
        server.start(Integer.parseInt(portField.getText().trim()));
        stopButton.setEnabled(true);
      }
    });
    stopButton.setAction(new AbstractAction("Stop") {

      @Override
      public void actionPerformed(ActionEvent e) {
        server.stop();
        portField.setEnabled(true);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
      }
    });
    stopButton.setEnabled(false);

    frame.setLayout(new GridLayout(0, 1));
    frame.add(portField);
    frame.add(startButton);
    frame.add(stopButton);
    frame.setMinimumSize(new Dimension(300, 0));
    frame.pack();
    frame.setVisible(true);
  }

}
