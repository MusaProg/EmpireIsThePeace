import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)
    {
        Socket s = null;
        PrintStream ps = null;

        try
        {
            ServerSocket serverSocket = new ServerSocket(Main.port);
            s = serverSocket.accept();
            ps = new PrintStream(s.getOutputStream());
            ps.println("Server connected");
            ps.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = br.readLine();
            ps.println("Server answer: your message: " + msg);
            ps.flush();
        }
        catch (IOException e)
        {
            System.err.print("Error server connection...\n");
        }
        finally
        {
            if (ps != null)
                ps.close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                catch(IOException e)
                {

                }
            }
        }
    }
}
