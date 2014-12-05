public class MessageVisitor implements UserVisitor
{
   private int counter;
   public void visitUser(User user)
   {
      counter += user.getNews().size();
   }
   public void setCounter(int temp)
   {
      counter = temp;
   }
   public int getCounter()
   {
      return counter;
      
   }
   public void visitMessage(OutgoingMessage m)
   {
      
   }
   public void visitGroup(UserGroup g)
   {
      
   }
   public void visitAdmin(AdminGUI a)
   {
     
   }
}
