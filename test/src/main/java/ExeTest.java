import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExeTest {
    public static void main(String[] args) {
        String keyWord = "hvsp system.exe";
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("cmd /c Tasklist");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            boolean isExistExe=false;
            while ((s = in.readLine()) != null) {
                s = s.toLowerCase();

                if (s.startsWith(keyWord)) {
                    //存在进程
                    isExistExe=true;
                    break;
                }
            }
            //存在进程
            if(isExistExe){

            }else {
                startExeAndCommand();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startExeAndCommand() {
        try {
            System.err.println("准备运行 prometheus...");
//            String[] url= {"C:\\\\Program Files\\\\HVSP System\\\\HVSP System.exe","B123","FJ12345614321325","2021121345"};
            String no = "6BC3A3E26A3F207959CE6F1040FF150AF07A3FB57D865226745BDB5E12A6D3274E036A3C7768BC2B2AC4E879CD9BD83CA2052D4A9A99DA799AF250462264AFEC74255A2CEBE5CF4A166671888A2AF1B7A4E17014F65AA4857E1CF94A03850F0BCB3D9E43224127CB8668C19D7ECCA629";
//            String[] url= {"D:\\\\Web\\\\Project\\\\hvsp_desktop\\\\node_modules\\\\electron\\\\dist\\\\electron.exe",no};
            String[] url = {"C:\\\\\\\\Program Files\\\\\\\\HVSP System\\\\\\\\HVSP System.exe", no};
            Runtime.getRuntime().exec(url);
            System.err.println("成功启动 prometheus...");
        } catch (IOException e) {
            System.out.println("Error exec!");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
