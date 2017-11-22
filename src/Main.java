import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Status;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws TwitterException {
        StringBuilder sb = new StringBuilder("");
        JFrame frame = new JFrame("こむぎこ");

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        JTextArea area = new JTextArea();
        area.setPreferredSize(new Dimension(1100,700));
        area.setFont(new Font("MS ゴシック", Font.BOLD, 24));
        area.setForeground(Color.white);
        area.setBackground(Color.BLACK);

        panel.add(area);

        frame.setBounds(100, 100, 1200, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

        area.insert("test",0);
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();



        for(Status status : statuses){
            sb.append(status.getUser().getName() + ":"+ status.getText() + "\n");
        }
        area.insert(sb.toString(), 0);
    }
}

