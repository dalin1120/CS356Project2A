import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.util.ArrayList;
import java.util.Hashtable;


public class AdminGUI implements ActionListener
{
   private int userCounterIDHolder;
   private int groupCounterIDHolder;
   private JFrame jfrm;
   private JTextField jtfName;
   private JTextField jtfGroup;
   private JScrollPane jscrlp;          
   private JButton jbtnUser;
   private JButton jbtnGroup;
   private JButton jbtnValidate;
   private JButton jbtnUpdate;
   private JButton jbtnUserTotal;
   private JButton jbtnGroupTotal;
   private JButton jbtnPercent;
   private JButton jbtnMessageTotal;
   private JButton jbtnView;
   private JTree jtree;
   private ArrayList<AbstractGroup> groups;
   private ArrayList<OutgoingMessage> messageHistory;
   private DefaultMutableTreeNode childNode;
   private DefaultMutableTreeNode start;
   private DefaultMutableTreeNode treeNode;
   private Hashtable<String, AbstractGroup> values;
   private static AdminGUI instance = new AdminGUI();
   
   
   private AdminGUI()                                             //Initialzing all the variables
   {
      groups = new ArrayList<AbstractGroup>();
      messageHistory = new ArrayList<OutgoingMessage>();
      start = new DefaultMutableTreeNode("Root");
      values = new Hashtable<String, AbstractGroup>();
      userCounterIDHolder = 0;                        
      groupCounterIDHolder = 0;    
      guiManager();
   }

   public void guiManager()                                       //Method that manages all the buttons, groups, textfields, and frame
   {
      jfrm = new JFrame("Adminstrator Control Panel");
      jtfName = new JTextField("User ID");
      jtfGroup = new JTextField("Group ID");
      jbtnUser = new JButton("Add User");
      jbtnGroup = new JButton("Add Group");
      jbtnValidate = new JButton("Validate User Name");
      jbtnUpdate = new JButton("Last Update");
      jbtnUserTotal = new JButton("Show User Total");
      jbtnGroupTotal = new JButton("Show Group Total");
      jbtnPercent = new JButton("Positive Word %");
      jbtnMessageTotal = new JButton("Show Total # Messages");
      jbtnView = new JButton("User View");
      jtree = new JTree(start);
      jtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
      jtree.addTreeSelectionListener(new TreeSelectionListener()
      {
         public void valueChanged(TreeSelectionEvent tse)
         {
            treeNode = (DefaultMutableTreeNode)jtree.getLastSelectedPathComponent();
         }
      });
      jscrlp = new JScrollPane(jtree);
      
      jbtnUser.setActionCommand("One");                                    //Setting the action command for each component so that they are unique when called
      jbtnGroup.setActionCommand("Two");
      jbtnValidate.setActionCommand("Three");
      jbtnUpdate.setActionCommand("Four");
      jbtnUserTotal.setActionCommand("Five");
      jbtnGroupTotal.setActionCommand("Six");
      jbtnPercent.setActionCommand("Seven");
      jbtnMessageTotal.setActionCommand("Eight");
      jbtnView.setActionCommand("Nine");
      
      jbtnUser.addActionListener(this);                                    //Adding actionListneres for the actionCommands
      jbtnGroup.addActionListener(this);
      jbtnValidate.addActionListener(this);
      jbtnUpdate.addActionListener(this);
      jbtnUserTotal.addActionListener(this);
      jbtnGroupTotal.addActionListener(this);
      jbtnPercent.addActionListener(this);
      jbtnMessageTotal.addActionListener(this);
      jbtnView.addActionListener(this);
      
      //Setting position on frame
      jbtnUser.setHorizontalTextPosition(SwingConstants.LEADING);          
      jbtnUser.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnGroup.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnGroup.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnValidate.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnValidate.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnUpdate.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnUpdate.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnUserTotal.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnUserTotal.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnGroupTotal.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnGroupTotal.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnPercent.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnPercent.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnMessageTotal.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnMessageTotal.setVerticalTextPosition(SwingConstants.CENTER);
      jbtnView.setHorizontalTextPosition(SwingConstants.LEADING);
      jbtnView.setVerticalTextPosition(SwingConstants.CENTER);
      
      jbtnUser.setBounds(540, 7, 240, 60);
      jtfName.setBounds(295, 7, 240, 60);   
      
      jbtnGroup.setBounds(540, 70, 240, 60);
      jtfGroup.setBounds(295, 70, 240, 60);
      
      jbtnValidate.setBounds(295, 260, 240, 60);
      jbtnUpdate.setBounds(540, 260, 240, 60);
      jbtnUserTotal.setBounds(295, 330, 240, 60);
      jbtnGroupTotal.setBounds(540, 330, 240, 60);
      jbtnPercent.setBounds(540, 400, 240, 60);
      jbtnMessageTotal.setBounds(295, 400, 240, 60);
      jbtnView.setBounds(295, 180, 485, 60);
      jscrlp.setBounds(10, 7, 280, 450);
      
      
      
      jfrm.getContentPane().setLayout(null);
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jfrm.add(jbtnUser);
      jfrm.add(jbtnGroup);
      jfrm.add(jbtnValidate);
      jfrm.add(jbtnUpdate);
      jfrm.add(jbtnUserTotal);
      jfrm.add(jbtnGroupTotal);
      jfrm.add(jbtnPercent);
      jfrm.add(jbtnMessageTotal);
      jfrm.add(jbtnView);
      jfrm.add(jscrlp);
      jfrm.add(jtfName);
      jfrm.add(jtfGroup);
      jfrm.setSize(800, 500);
      jfrm.setVisible(true);
      jfrm.setLocationRelativeTo(null);
      
   }
   public void actionPerformed(ActionEvent ae)                    //the events that happen when a button is pressed
   {
      if(ae.getActionCommand().equals("One"))                     //Add user event handler
      {
         if(!values.containsKey(jtfName.getText()))
         {
            addNameNode(jtfName.getText());
         }
      }
      else if(ae.getActionCommand().equals("Two"))                //Add group event handler
      {
         if(!values.containsKey(jtfGroup.getText()))
         {
            addGroupNode(jtfGroup.getText());
         }
      }
      else if(ae.getActionCommand().equals("Three"))              //Check invalid event handler. Names are invalid if they contain spaces or tabs
      {
         for(AbstractGroup tmp: groups)
         {
            if(tmp.getUser().contains(" ") || tmp.getUser().contains("\t"))
            {
               JOptionPane.showMessageDialog(null, "Invalid name");
            }
         }   
      }
      else if(ae.getActionCommand().equals("Four"))               //Action event for when looking for recent update
      {
         User lastUser = new User("JohnDoe", "123");
         User holder;
         for(AbstractGroup group: groups)
         {  
            holder = (User)group;
            if(lastUser.getUpdateTime() == 0)                     //Need to initally set the fake user to some sort of user that's in the list
            {
               lastUser = (User)holder;
            }
            else if(holder.getUpdateTime() < lastUser.getUpdateTime()) //standard algorith where if new time is less than old time, replace
            {
               lastUser = (User)holder;
            }
         }
         JOptionPane.showMessageDialog(null, lastUser.getUser() + " updated: " + lastUser.getUpdateTime() + " ms ago");
      }
      else if(ae.getActionCommand().equals("Five"))                     //Event handler to count the number of visitors
      {
         UserCountVisitor holder = new UserCountVisitor();
         instance.accept(holder);
         JOptionPane.showMessageDialog(null, "Total number of users: " + holder.getCounter());
      }
      else if(ae.getActionCommand().equals("Six"))                      //Event handler to count the number of groups
      {
         GroupCountVisitor holder = new GroupCountVisitor();
         instance.accept(holder);
         JOptionPane.showMessageDialog(null, "Total number of groups in tree: " + holder.getCounter());
      }
      else if(ae.getActionCommand().equals("Seven"))                    //Event handler to count the number of good words
      {
         GoodWordsCount holder = new GoodWordsCount();
         instance.accept(holder);
         JOptionPane.showMessageDialog(null, holder.getCounter() + " of your messages were positive");
      }
      else if(ae.getActionCommand().equals("Eight"))                    //Event handler for number of messages
      {
         MessageVisitor holder = new MessageVisitor();
         instance.accept(holder);
         JOptionPane.showMessageDialog(null, "Total number of tweets: " + holder.getCounter());
      }
      else if(ae.getActionCommand().equals("Nine"))                     //Pops up user view
      {
         if(!treeNode.getAllowsChildren())
         {
            new UserViewGUI((User)treeNode.getUserObject());
         }
      }
   }

   
   
   public void accept(UserVisitor tmp)
   {
      for(AbstractGroup tmpGroup: groups)
      {
         tmpGroup.accept(tmp);
      }
      for(OutgoingMessage msg: messageHistory )
      {
         msg.accept(tmp);
      }
      tmp.visitAdmin(this);
   }
   public static AdminGUI getInstance()
   {
      if(instance == null)
      {
         instance = new AdminGUI();
      }
      return instance;
   }
   public void addNameNode(String name)                  //Adding users to the tree with an ID
   {
      User tweeter = new User(name, userCounterIDHolder + "");
      add(tweeter);
      userCounterIDHolder++;
   }
   public void addGroupNode(String name)
   {
      UserGroup groupName = new UserGroup(name, groupCounterIDHolder + "");      //Adding Groups with an ID
      add(groupName);
      groupCounterIDHolder++;
   }
   public void add(AbstractGroup tmp)                             //adding to the actual tree and checking the status of group
   {
      boolean status = tmp.groupStatus();
      values.put(tmp.getUser(), tmp);
      groups.add(tmp);
      childNode = new DefaultMutableTreeNode(tmp);
      childNode.setAllowsChildren(status);
      start.add(childNode);
      if(treeNode != null && treeNode.getAllowsChildren())
      {
         start.remove(childNode);
         treeNode.add(childNode);
      }
      jfrm.dispose();
      guiManager();
   }
   
   //getters and setters
   public ArrayList<OutgoingMessage> getHistory()
   {
      return messageHistory;
   }
   public Hashtable<String, AbstractGroup> getValues()
   {
      return values;
   }
   public ArrayList<OutgoingMessage> getMessageHistory()
   {
      return messageHistory;
   }//
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            AdminGUI.getInstance();
         }
      });
   }
   
}
