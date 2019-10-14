import com.alibaba.fastjson.JSON;
import model.Result;
import model.qa_item;
import model.user_paper_items;

import java.io.*;
import java.util.ArrayList;

public class FileTest {
    public static void main(String[] args) throws IOException {
        String allContent = "";
        for (int p = 0; p < 52; p++) {
            Result result = JSON.parseObject(getFileContent("C:\\Users\\admin\\Desktop\\subject\\" +p+ ".txt"), Result.class);
            ArrayList<user_paper_items> user_paper_items = result.getData().getUser_paper_items();
            for (int i = 0; i < user_paper_items.size(); i++) {
                model.user_paper_items paperItems = user_paper_items.get(i);
                String problem = "";
                qa_item qa_item = paperItems.getQa_item();
                String title = (i + 1)+(p)*10 + ":" + paperItems.getName() +"( )";
                ArrayList<String> sel_items = qa_item.getSel_items();
                for (int j = 0; j < sel_items.size(); j++) {
                    String re = "(" + (j + 1) + ")" + sel_items.get(j);
                    if (problem.equals("")) {
                        problem = re;
                    } else {
                        problem = problem + "\n" + re;
                    }

                }
                String content = title + "\n" + problem + "\n"+"答案："+ qa_item.getRight_answers()+ "\n" ;
                allContent = allContent + "\n" + content;
            }
        }
        System.out.println(allContent);
        File file =new File("C:\\Users\\admin\\Desktop\\subject\\result.txt");
        Writer out =new FileWriter(file);
        String data=allContent;
        out.write(data);
        out.close();

        //======================================================================
//        String s = getFileContent("C:\\Users\\admin\\Desktop\\subject\\0.txt");
//        Result result = JSON.parseObject(s, Result.class);
//        ArrayList<user_paper_items> user_paper_items = result.getData().getUser_paper_items();
//
//        String allContent = "";
//        for (int i=0;i<user_paper_items.size();i++){
//            model.user_paper_items paperItems = user_paper_items.get(0);
//            String problem="";
//            qa_item qa_item = paperItems.getQa_item();
//            String title=(i+1)+":"+paperItems.getName()+"  答案"+qa_item.getRight_answers();
//            ArrayList<String> sel_items = qa_item.getSel_items();
//            for (int j=0;j<sel_items.size();j++){
//                String re="("+(j+1)+")"+sel_items.get(j);
//                if(problem.equals("")){
//                    problem=re;
//                }else {
//                    problem=problem+"\n"+re;
//                }
//
//            }
//            String jx="";
//            if(qa_item.getExplain().isEmpty()){
//                jx="无";
//            }else {
//                jx=qa_item.getExplain();
//            }
//
//            String content=title+"\n"+problem+"\n"+"解析:"+jx+"\n";
//            allContent=allContent+"\n"+content;
//        }
//
//
//
//        System.out.println(allContent);

    }

    private static String getFileContent(String filePath) {

        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }
}
