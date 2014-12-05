import java.util.Hashtable;

public interface AbstractGroup
{

   public String getUser();
   public String getUserId();
   public String toString();
   public AbstractGroup getChild(String userName);
   public boolean groupStatus();
   public void setGroup(boolean groupStatus);
   public Hashtable<String, AbstractGroup> getChilds();
   public void addToGroup(AbstractGroup child);
   public void remove(User user);
   public void accept(UserVisitor visitor);
   public long getTime();
   
}
