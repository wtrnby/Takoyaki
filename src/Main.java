import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Status;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TwitterException {
        JFrame frame = new JFrame("こむぎこ"); //ウィンドウの作成
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1200, 800); //ウィンドウサイズの指定
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true); //ウィンドウの表示

        JTextArea area = new JTextArea(); //テキストエリアの作成
        area.setPreferredSize(new Dimension(1100,700)); //サイズ指定(ウィンドウサイズに応じて変化させたい)
        area.setFont(new Font("MS ゴシック", Font.BOLD, 24)); //フォント指定
        area.setEditable(false); //編集不可
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setForeground(Color.white); //文字色指定
        area.setBackground(Color.BLACK); //背景色指定
        area.setText("");
        panel.add(area);


        //タイムラインの表示。メソッドにしてアプリ起動時とキーでの更新に対応させたい
        StringBuilder sb = new StringBuilder("");
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();
        for(Status status : statuses){
            sb.append(status.getUser().getName() + " @"+ status.getUser().getScreenName() + "\n" + status.getText() + "\n\n");
        }
        area.insert(sb.toString(), 0);
    }
}

