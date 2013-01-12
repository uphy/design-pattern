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

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


/**
 * @author yuhi
 */
public class DisplayServer {

  boolean started;
  Thread serverThread;
  ServerSocket serverSocket;
  Display display;

  /**
   * {@link DisplayServer}オブジェクトを構築します。
   */
  public DisplayServer() {
    this(new LocalDisplay());
  }

  /**
   * {@link DisplayServer}オブジェクトを構築します。
   * 
   * @param display
   */
  public DisplayServer(Display display) {
    if (display == null) {
      throw new NullPointerException();
    }
    this.display = display;
  }

  public synchronized void start(final int port) {
    if (this.serverThread != null) {
      throw new IllegalStateException("Already started!");
    }

    this.serverThread = new Thread("Display Server") {

      public void run() {
        serverSocket = null;
        try {
          serverSocket = new ServerSocket(port);
          while (true) {
            final Socket socket = serverSocket.accept();
            try {
              final InputStream in = socket.getInputStream();
              int commandId;
              while ((commandId = in.read()) != -1) {
                final CommandType command = CommandType.values()[commandId];
                final byte[] argByte = new byte[in.read()];
                in.read(argByte);
                final String arg = new String(argByte, "UTF-8");
                switch (command) {
                  case SHOW:
                    display.show();
                    break;
                  case DISPOSE:
                    display.disponse();
                    break;
                  case SET_MESSAGE:
                    display.setMessage(arg);
                    break;
                }
              }
            } catch (SocketException ex) {
              // stopped
              continue;
            }
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
        } finally {
          if (serverSocket != null) {
            try {
              serverSocket.close();
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }
        }
      }
    };
    this.serverThread.start();
  }

  public synchronized void stop() {
    if (this.serverSocket == null) {
      throw new IllegalStateException("Server not started.");
    }
    try {
      this.serverSocket.close();
      this.serverSocket = null;
    } catch (IOException e) {

    } finally {
      this.serverThread.interrupt();
    }

    this.serverThread = null;
  }

}
