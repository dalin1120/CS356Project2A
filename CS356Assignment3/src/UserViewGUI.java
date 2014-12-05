import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserViewGUI implements ActionListener
{
   private JFrame jfrm;
   private JTextField jtfName;
   private JTextField jtfSendMessage;
   private JScrollPane jscrlpFollow;
   private JScrollPane jscrlpNews;
   private JButton jbtnFollow;
   private JButton jbtnMessage;
   private JList<User> followingList;
   private JList<OutgoingMessage> newsList;
   private User person;
   
   public UserViewGUI(User holder)                
   {
      person = holder;
      guiManager();
      
   }
   public void guiManager()                              //Method that has all the buttons, frames and scrollpanes
   {
      jfrm = new JFrame(person.getUser() + " profile was created " + person.getTime() + " ms ago");
      jtfName = new JTextField("User ID");
      jtfSendMessage = new JTextField("Tweet Message");
      jbtnFollow = new JButton("Follow User");
      jbtnMessage = new JButton("Post Tweet");
      followingList = new JList<User>(person.getfollowing());
      jscrlpFollow = new JScrollPane(followingList);
      newsList = new JList<OutgoingMessage>(person.getNews());
      jscrlpNews = new JScrollPane(newsList);
      
      jbtnFollow.setActionCommand("One");
      jbtnMessage.setActionCommand("Two");
      jbtnFollow.addActionListener(this);
      jbtnMessage.addActionListener(this);
      
      jbtnFollow.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnFollow.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnMessage.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnFollow.setVerticalTextPosition(SwingConstants.CENTER);
      
      
      jtfName.setBounds(10, 5, 230, 35); 
      jtfSendMessage.setBounds(10, 220, 230, 35); 
      jscrlpFollow.setBounds(10, 45, 470, 170);  
      jscrlpNews.setBounds(10, 260, 470, 200);
      jbtnFollow.setBounds(250, 5, 230, 35);
      jbtnMessage.setBounds(250, 220, 230, 35);
      
      jfrm.setLayout(null);
      jfrm.add(jtfName);
      jfrm.add(jtfSendMessage);
      jfrm.add(jscrlpFollow);
      jfrm.add(jscrlpNews);
      jfrm.add(jbtnFollow);
      jfrm.add(jbtnMessage);
      jfrm.setSize(500, 500);
      jfrm.setVisible(true);
      jfrm.setLocationRelativeTo(null);
           
      
   }
   public void actionPerformed(ActionEvent ae)                             //Event handler for the buttons in the GUI
   {
      if(ae.getActionCommand().equals("One"))
      {
         if(!jtfName.getText().equals(person.getUser()) && AdminGUI.getInstance().getValues().containsKey(jtfName.getText()))
         {
            person.attach((User)AdminGUI.getInstance().getValues().get(jtfName.getText()));
         }
      }
      else
      {
         person.tweetMessage(jtfSendMessage.getText());
      }
   }
}
