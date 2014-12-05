public class UserCountVisitor implements UserVisitor
{
   private int counter = 0;
   public void visitUser(User user)
   {
      counter++;
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