public class GoodWordsCount implements UserVisitor
{
   private int counter = 0;
   private double msgCount = 0;
   private String[] goodWords = {"ecstatic", "wonderful", "dandy", "fun"};
   public void visitUser(User user)
   {
      
   }
   public void setCounter(int temp)
   {
      counter = temp;
   }
   
   public double getCounter()
   {
      return counter / msgCount;
      
   }
   public void visitGroup(UserGroup g)
   {
      
   }
   
   
   public void visitMessage(OutgoingMessage m)
   {
      msgCount++;
      for(String s: goodWords)
      {
         if(m.getMessage().contains(s))
         {
            counter++;
         }
      }
   }

   public void visitAdmin(AdminGUI a) 
   {
     
   }
}