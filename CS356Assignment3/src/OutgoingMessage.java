
public class OutgoingMessage
{
   private String tweet;
   private String op;
   
   
   public OutgoingMessage(String msg, User person)
   {
      tweet = msg;
      op = person.getUser();
   }
   
   public void accept(UserVisitor visitor)
   {
      visitor.visitMessage(this);
      
   }
   public String getMessage()
   {
      return tweet;
      
   }
   public String toString()
   {
      return "@" + op + " says " + tweet;
   }
   
   
}
