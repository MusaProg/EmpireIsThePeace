import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{

    public static void main(String[] args)
    {
        Socket socket = null;
        try
        {
            socket = new Socket(Main.host, Main.port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = br.readLine();
            System.out.println( msg);
            Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            System.out.print("Input your message: ");
            ps.println(sc.nextLine());
            ps.flush();
            System.out.println(br.readLine());
        }
        catch (UnknownHostException e)
        {
            System.out.println("Unknow Host Exception");
        }
        catch (IOException e)
        {
            System.out.println("IO exception");
        }
    }
}
