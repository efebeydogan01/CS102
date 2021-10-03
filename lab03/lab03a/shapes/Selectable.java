package shapes;

public interface Selectable
{
   boolean getSelected();
   
   void setSelected( boolean b);
   
   Shape contains( int x, int y);
}