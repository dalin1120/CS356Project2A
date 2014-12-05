public class GroupCountVisitor implements UserVisitor
{
   private int counter = 0;
   public void visitUser(User user)
   {
      
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
      counter++;
   }

   public void visitAdmin(AdminGUI a) 
   {
      
   }
}