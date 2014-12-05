public interface UserVisitor
{
   public void visitGroup(UserGroup g);
   public void visitMessage(OutgoingMessage m);
   public void visitUser(User u);
   public void visitAdmin(AdminGUI a);
}