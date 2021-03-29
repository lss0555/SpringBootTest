package exe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class pageTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("测试平台");
        jFrame.setSize(500,500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        JButton button = new JButton("进入患者全息视图");
        button.setSize(150,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExeAndCommand();
            }
        });
        button.setVisible(true);
        jFrame.add(button);
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
