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
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author yuhi
 */
public class RemoteDisplay implements Display {

  private Socket socket;
  private OutputStream outputStream;

  /**
   * {@link RemoteDisplay}オブジェクトを構築します。
   * 
   * @throws IOException
   * @throws UnknownHostException
   */
  public RemoteDisplay(String host, int port) throws UnknownHostException, IOException {
    this.socket = new Socket(host, port);
    this.outputStream = this.socket.getOutputStream();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void show() {
    sendCommand(CommandType.SHOW);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setMessage(String message) {
    sendCommand(CommandType.SET_MESSAGE, message);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void disponse() {
    sendCommand(CommandType.DISPOSE);
  }

  private void sendCommand(CommandType command) {
    sendCommand(command, null);
  }

  private void sendCommand(CommandType command, String args) {
    try {
      this.outputStream.write(command.ordinal());
      final byte[] data = args == null ? new byte[0] : args.getBytes("UTF-8");
      final int length = args == null ? 0 : Math.min(args.length(), 0xFF);
      this.outputStream.write(length);
      this.outputStream.write(data, 0, length);
      this.outputStream.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void close() throws IOException {
    this.socket.close();
  }

}
