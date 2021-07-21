package BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("等待连接。。");
            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了。。");
            handler(clientSocket);
//            new Thread(()->{
//                try {
//                    handler(clientSocket);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }).start();
        }
    }
    private static void handler(Socket clientSocket) throws IOException {
         byte[] bytes = new byte[1024];
         System.out.println("准备read。。");
         //接收客户端的数据，阻塞方法，没有数据可读时就阻塞
        InputStream inputStream = clientSocket.getInputStream();
//        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕。。");
        //循环的读取客户端发送的数据
        while (true){
            int read = inputStream.read(bytes);
            if (read != -1){
                System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));  }
            clientSocket.getOutputStream().write("HelloClient".getBytes());
            clientSocket.getOutputStream().flush();
            }
        }
}