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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * @author yuhi
 */
public class ClientApp {

  public static void main(String[] args) {
    final JFrame frame = new JFrame("Client");
    final JTextField hostField = new JTextField("localhost");
    final JTextField portField = new JTextField(String.valueOf(ServerApp.DEFAULT_PORT));

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(0, 2));
    frame.add(new JLabel("Host:"));
    frame.add(hostField);
    frame.add(new JLabel("Port:"));
    frame.add(portField);

    final ActionListener startClient = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          startClient(frame, hostField.getText().trim(), Integer.parseInt(portField.getText().trim()));
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(frame, e1.toString());
          e1.printStackTrace();
        }
      }
    };

    final JButton startClientButton = new JButton("Start");
    startClientButton.addActionListener(startClient);

    frame.add(new Label());
    frame.add(startClientButton);

    hostField.addActionListener(startClient);
    portField.addActionListener(startClient);

    frame.pack();
    frame.setVisible(true);
  }

  @SuppressWarnings("serial")
  private static void startClient(Component parent, String host, int port) throws UnknownHostException, IOException {
    final Display display = new RemoteDisplay(host, port);
    final JTextField message = new JTextField();
    final JFrame frame = new JFrame(host + ":" + port);
    frame.setMinimumSize(new Dimension(100, 0));
    frame.setLocationRelativeTo(parent);

    frame.setLayout(new GridLayout(0, 1));
    frame.add(new JButton(new AbstractAction("Show") {

      @Override
      public void actionPerformed(ActionEvent e) {
        display.show();
      }
    }));
    frame.add(new JButton(new AbstractAction("Dispose") {

      @Override
      public void actionPerformed(ActionEvent e) {
        display.disponse();
      }
    }));
    message.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        display.setMessage(message.getText());
      }
    });
    frame.add(message);

    frame.pack();
    frame.setVisible(true);
  }
}
