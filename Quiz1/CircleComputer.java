import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleComputer extends JFrame
{
   // properties
   
   // constructors
   
   public CircleComputer()
   {
      super( "Circle Computer");
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      add( new MyPanel());
      setPreferredSize( new Dimension( 400,150));
      pack();
      setVisible( true);
   }
   
   
   
   public class MyPanel extends JPanel
   {
      // properties
      JPanel radiusPanel;
      JPanel circumferencePanel;
      JPanel panel;
      JTextField radiusField;
      JTextField circField;
      double circum;
      double rad;
      
      // constructors
      
      public MyPanel()
      {
         radiusPanel = new JPanel();
         radiusPanel.add( new JLabel( "Radius:"));
         radiusField = new JTextField( 20);
         radiusField.addActionListener( new RadiusListener());
         radiusPanel.add( radiusField);
         
         circumferencePanel = new JPanel();
         circumferencePanel.add( new JLabel( "Circumference:"));
         circField = new JTextField( 20);
         circField.addActionListener( new CircumferenceListener());
         circumferencePanel.add( circField);
         
         panel = new JPanel();
         panel.setLayout( new BorderLayout());
         panel.add( radiusPanel, BorderLayout.NORTH);
         panel.add( circumferencePanel, BorderLayout.EAST);
         add( panel);
      }
      
      public class CircumferenceListener implements ActionListener
      {
         public void actionPerformed( ActionEvent e)
         {
            String s;
            s = ((JTextField)e.getSource()).getText();
            circum = Double.parseDouble( s);
            rad = circum / ( 2 * Math.PI);
            radiusField.setText( String.valueOf( rad));
         }
      }
      
      public class RadiusListener implements ActionListener
      {
         public void actionPerformed( ActionEvent e)
         {
            String s;
            s = ((JTextField)e.getSource()).getText();
            rad = Double.parseDouble( s);
            circum = 2 * Math.PI * rad;
            circField.setText( String.valueOf( circum));
         }
      }
   }
}
   