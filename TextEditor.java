 /*

This is my submission - Priyansh Singhal (2110110397) CSE'25
This text editor offers various functionalities.
Starting of we have a menu bar which contains 4 menus:

    File -> Open (Loads a file from PC)
    File -> Save (Saves the current file anywhere in the PC)
    File -> Exit (closes the program)

    Edit -> Cut (Cuts the selected area)
    Edit -> Copy (Copies the selected area)
    Edit -> Paste (Paste the selected area)

    Review -> Word Count (Counts the words and characters present in the text area and displays it at the bottom of the screen)

    Help -> About Us (Tells about me)

Then we have various buttons below the menu bar like Bold, Italics, Left Align, Right Align
Below that we have a font box which displays all the fonts present in java and beside that we have a fontsize box which displays various sizes. Users can select fonts or fontsize acc to their liking.
Then we have find and replace fields which do the usual find and replace acc to the buttons selected given below it.
Then we have a text area.
below that we have word count and character count which will display respective counts after 'Word Count' given in the Review menu.

*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.io.*;
import java.util.*;

public class TextEditor extends JFrame implements ActionListener
{
    JFrame frame;
    JTextField findArea,replaceArea;
    JTextArea textArea;
    JToggleButton bold,italics,underline,left,right,centre,justified;
    JPanel panel1,panel2;
    JButton findAll,findNext,replace,replaceAll;
    JMenuBar mb;
    JMenu file,edit,review,help;
    JMenuItem i1,i2,i3;
    JMenuItem j1,j2,j3;
    JMenuItem k1,l1;
    JComboBox<String> fontBox,fontSizeBox;
    JScrollPane sp;
    int currentPosition = 0;
    JButton rect,oval,line,triangle,pentagon,clear;
    JTextField charCount,wordCount;


    TextEditor()
    {
        frame = new JFrame("PS Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,650);
        frame.setLocationRelativeTo(null);

        mb = new JMenuBar();

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        String[] fontsize = { "5","10","15","20","25","30","35","40","45","50"};
        fontBox = new JComboBox<String>(fonts);
        fontBox.setEditable(true);
        fontBox.setSelectedItem("Arial");
        fontBox.addActionListener(this);

        fontSizeBox = new JComboBox<String>(fontsize);
        fontSizeBox.setEditable(true);
        fontSizeBox.setSelectedItem("10");
        fontSizeBox.addActionListener(this);


        i1 = new JMenuItem("Open");         i1.addActionListener(this);
        i2 = new JMenuItem("Save");         i2.addActionListener(this);
        i3 = new JMenuItem("Exit");         i3.addActionListener(this);
        j1 = new JMenuItem("Cut");          j1.addActionListener(this);
        j2 = new JMenuItem("Copy");         j2.addActionListener(this);
        j3 = new JMenuItem("Paste");        j3.addActionListener(this);
        k1 = new JMenuItem("Word Count");   k1.addActionListener(this);
        l1 = new JMenuItem("About Us");     l1.addActionListener(this);
        file = new JMenu("File");
        edit = new JMenu("Edit");
        review = new JMenu("Review");
        help = new JMenu("Help");
        file.add(i1);
        file.add(i2);
        file.add(i3);
        edit.add(j1);
        edit.add(j2);
        edit.add(j3);
        review.add(k1);
        help.add(l1);
        mb.add(file);
        mb.add(edit);
        mb.add(review);
        mb.add(help);
        frame.setJMenuBar(mb);

        GridLayout gd = new GridLayout(1,2);
        gd.setHgap(10);
        frame.setLayout(gd); 

        panel1 = new JPanel(new BorderLayout()); panel1.setBackground(new Color(0xEDEEF1));
        panel2 = new JPanel(); 
        
        JPanel subpanel1,subpanel2,subpanel3,subpanel4,subpanel5,subpanel6,subpanel7,subpanel8,subpanel8_1,subpanel8_2;
        JPanel subpanel9,subpanel10,subpanel11;
        subpanel1 = new JPanel();                       subpanel1.setBackground(new Color(0xEDEEF1));
        subpanel2 = new JPanel();                       subpanel2.setBackground(new Color(0xEDEEF1));
        subpanel3 = new JPanel();                       subpanel3.setBackground(new Color(0xEDEEF1));
        subpanel4 = new JPanel();                       subpanel4.setBackground(new Color(0xEDEEF1));
        subpanel5 = new JPanel();                       subpanel5.setBackground(new Color(0xEDEEF1));
        subpanel6 = new JPanel();                       subpanel6.setBackground(new Color(0xEDEEF1));
        subpanel7 = new JPanel();                       subpanel7.setBackground(new Color(0xEDEEF1));
        subpanel8 = new JPanel();     subpanel8.setBackground(new Color(0xEDEEF1));
        subpanel8_1 = new JPanel();                     subpanel8_1.setBackground(new Color(0xEDEEF1));
        subpanel8_2 = new JPanel();                     subpanel8_2.setBackground(new Color(0xEDEEF1));
        subpanel9 = new JPanel();                       subpanel9.setBackground(new Color(0xEDEEF1));
        subpanel10 = new JPanel();                      subpanel10.setBackground(new Color(0xEDEEF1));
        subpanel11 = new JPanel();                      subpanel11.setBackground(new Color(0xC1C2C5));

        bold = new JToggleButton("B");                bold.addActionListener(this);                   //Bold
        italics = new JToggleButton("I");             italics.addActionListener(this);                //Italics
        underline = new JToggleButton("U");           underline.addActionListener(this);              //UnderLine

        left = new JToggleButton("L");                 left.addActionListener(this);                  //Left Alignment
        centre = new JToggleButton("C");               centre.addActionListener(this);                //Center Alignment
        right = new JToggleButton("R");                right.addActionListener(this);                 //Right Alignment
        justified = new JToggleButton("Justified");    justified.addActionListener(this);             //Justified Alignment

        panel1.setLayout(new FlowLayout());

        subpanel1.add(bold);
        subpanel1.add(italics);
        subpanel1.add(underline);

        subpanel2.add(left);
        subpanel2.add(centre);
        subpanel2.add(right);
        subpanel2.add(justified);

        subpanel3.add(fontBox);
        subpanel3.add(fontSizeBox);

        
        JLabel label1 = new JLabel("FIND:          ");      label1.setForeground(Color.BLACK);
        JLabel label2 = new JLabel("REPLACE: ");            label2.setForeground(Color.BLACK);

        findArea = new JTextField();
        findArea.setPreferredSize(new Dimension(500,20));
        subpanel4.add(label1);
        subpanel4.add(findArea);
        subpanel4.setBackground(new Color(0xEDEEF1));
        
        replaceArea = new JTextField();
        replaceArea.setPreferredSize(new Dimension(500,20));
        subpanel5.add(label2);
        subpanel5.add(replaceArea);
        subpanel5.setBackground(new Color(0xEDEEF1));

        findNext = new JButton("Find Next");            findNext.addActionListener(this);
        findAll = new JButton("Find All");              findAll.addActionListener(this);
        replace = new JButton("Replace");               replace.addActionListener(this);
        replaceAll = new JButton("Replace All");        replaceAll.addActionListener(this);

        subpanel6.add(findNext);
        subpanel6.add(findAll);
        subpanel6.add(replace);
        subpanel6.add(replaceAll);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        sp = new JScrollPane(textArea);
        sp.setPreferredSize(new Dimension(550,325));
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        subpanel7.add(sp);        
        
        subpanel8.setPreferredSize(new Dimension(550,30));
        
        JLabel label3 = new JLabel("Word Count: ");
        // wordCount = new JLabel();
        wordCount = new JTextField();
        wordCount.setPreferredSize(new Dimension(85,23));
        wordCount.setEditable(false);
        wordCount.setBackground(new Color(0xEDEEF1));
        subpanel8_1.add(label3);
        subpanel8_1.add(wordCount);
        
        JLabel label4 = new JLabel("Character Count: ");
        // charCount = new JLabel();
        charCount = new JTextField();
        charCount.setPreferredSize(new Dimension(85,23));
        charCount.setEditable(false);
        wordCount.setBackground(new Color(0xEDEEF1));
        subpanel8_2.add(label4);
        subpanel8_2.add(charCount);
        
        subpanel8.add(subpanel8_1,BorderLayout.NORTH);
        subpanel8.add(subpanel8_2,BorderLayout.SOUTH);

        
        subpanel9.setPreferredSize(new Dimension(400,30));
        JLabel label5 = new JLabel("SketchPad");
        subpanel9.add(label5);
        
        
        
        rect = new JButton("Rectangle");            rect.addActionListener(this);
        oval = new JButton("Oval");                 oval.addActionListener(this);
        line = new JButton("Line");                 line.addActionListener(this);
        triangle = new JButton("Triangle");         triangle.addActionListener(this);
        pentagon = new JButton("Pentagon");         pentagon.addActionListener(this);
        clear = new JButton("CLEAR");               clear.addActionListener(this);

        subpanel10.add(rect);
        subpanel10.add(oval);
        subpanel10.add(line);
        subpanel10.add(triangle);
        subpanel10.add(pentagon);
        subpanel10.add(clear);
        
        subpanel11.setPreferredSize(new Dimension(545,440));

        

        panel1.add(subpanel1);
        panel1.add(subpanel2);
        panel1.add(subpanel3);
        panel1.add(subpanel4);
        panel1.add(subpanel5);
        panel1.add(subpanel6);
        panel1.add(subpanel7);
        panel1.add(subpanel8_1);
        panel1.add(subpanel8_2);

        panel2.add(subpanel9);
        panel2.add(subpanel10);
        panel2.add(subpanel11);


        Border black = BorderFactory.createLineBorder(Color.BLACK);
        panel1.setBorder(black);
        panel2.setBorder(black);

        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(italics.isSelected()==false)
        {
            textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
        }
        if(bold.isSelected()==false)
        {
            textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
        }
        if(italics.isSelected()==true)
        {
            textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC));
        }
        if(bold.isSelected()==true)
        {
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));
        }
        if(bold.isSelected()==true && italics.isSelected()==true)
        {
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD+Font.ITALIC));
        }
        if(e.getSource()==underline)
        {
            // textArea.setFont(new Font((String)textArea.getFont().getFamily(),Font.UnderLine,getFont().getSize()));
        }

        if(e.getSource()==right)
        {
            textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        if(e.getSource()==centre)
        {
            
        }
            
        if(e.getSource()==left)
        {
            textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }

        if(e.getSource()==  justified)
        {

        }


        if(e.getSource()==fontBox)
        {
            textArea.setFont(new Font((String) fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }


        if(e.getSource()==fontSizeBox)
        {
            textArea.setFont(new Font((String)textArea.getFont().getFontName(),Font.PLAIN,Integer.parseInt((String)fontSizeBox.getSelectedItem())));
        }


        if(e.getSource()==i1)
        {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            int res = fc.showOpenDialog(null);
            if(res==JFileChooser.APPROVE_OPTION)
            {
                File fp = new File(fc.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try
                {
                    fileIn = new Scanner(fp);
                    if(fp.isFile())
                    {
                        while(fileIn.hasNextLine())
                        {
                            String s = fileIn.nextLine()+"\n";
                            textArea.append(s);
                        }
                    }
                }
                catch(FileNotFoundException e0)
                {
                    e0.printStackTrace();
                }
                finally
                {
                    fileIn.close();
                }
            }
        }

        if(e.getSource()==i2)
        {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            int res = fc.showSaveDialog(null);
            if(res == JFileChooser.APPROVE_OPTION)
            {
                File fp;
                PrintWriter fileOut = null;
                fp = new File(fc.getSelectedFile().getAbsolutePath());
                try
                {
                    fileOut = new PrintWriter(fp);
                    fileOut.println(textArea.getText());
                }
                catch(FileNotFoundException e0)
                {
                    e0.printStackTrace();
                }
                finally
                {
                    fileOut.close();
                }
            }
        }

        if(e.getSource()==i3)
        {
            System.exit(0);
        }


        if(e.getSource()==j1)
        {
            textArea.cut();
        }


        if(e.getSource()==j2)
        {
            textArea.copy();
        }


        if(e.getSource()==j3)
        {
            textArea.paste();
        }
        
        
        if(e.getSource() == k1)
        {
            String text = textArea.getText();
            charCount.setText(" " + text.length());
            String words[] = text.split("\\s");
            wordCount.setText(" " + words.length);
        }

        if(e.getSource()==l1)
        {
            String x = "PS Word is an awesome text editor made by Priyansh Singhal.\nAs of December 2022, He is a 2nd year engineering student majoring in Computer Science.\nThis text editor was an assignment given as a graded CSD213\n(Object Oriented Programming) Assignment by Dr. Pooja Malik.";
            JOptionPane.showMessageDialog(null,x,"About us",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource()==findNext)
        {
            String textAreaText = textArea.getText().toLowerCase();
            String textFieldText = findArea.getText().toLowerCase();
            int index = textAreaText.indexOf(textFieldText,currentPosition);
            int length = textFieldText.length();
            Highlighter highlight = textArea.getHighlighter();
            highlight.removeAllHighlights();
            try
            {
                highlight.addHighlight(index, index+length, new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
            }
            catch(BadLocationException ex){
                ex.printStackTrace();
            }
            currentPosition = index+length;
            if(currentPosition >= textAreaText.length())
            {
                currentPosition = 0;
            }
            if(textAreaText.indexOf(textFieldText,currentPosition) == -1)
            {
                currentPosition = 0;
            }
        }

        if(e.getSource()==findAll)
        {
            String textAreaText = textArea.getText().toLowerCase();
            String textFieldText = findArea.getText().toLowerCase();
            Highlighter highlight = textArea.getHighlighter();
            highlight.removeAllHighlights();
            while(textAreaText.indexOf(textFieldText,currentPosition)!= -1)
            {
                int index = textAreaText.indexOf(textFieldText,currentPosition);
                int length = textFieldText.length();
                try
                {
                    highlight.addHighlight(index, index+length, new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
                }
                catch(BadLocationException ex){
                    ex.printStackTrace();
                }
                currentPosition = index+length;
            }
            if(currentPosition >= textAreaText.length())
            {
                currentPosition = 0;
            }
            if(textAreaText.indexOf(textFieldText,currentPosition) == -1)
            {
                currentPosition = 0;
            }
        }

        if(e.getSource()==replace)
        {
            String textAreaText = textArea.getText().toLowerCase();
            String textFieldText = findArea.getText().toLowerCase();
            String replaceText = replaceArea.getText();
            textArea.setText(textAreaText.replaceFirst(textFieldText, replaceText));
        }
        
        if(e.getSource()==replaceAll)
        {
            String textAreaText = textArea.getText().toLowerCase();
            String textFieldText = findArea.getText().toLowerCase();
            String replaceText = replaceArea.getText();
            textArea.setText(textAreaText.replaceAll(textFieldText, replaceText));
            currentPosition = 0;
        }


        // if(e.getSource()==rect)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }


        // if(e.getSource()==oval)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }


        // if(e.getSource()==line)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }


        // if(e.getSource()==triangle)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }


        // if(e.getSource()==pentagon)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }


        // if(e.getSource()==clear)
        // {
        //     subpanel11.drawRect(10,20,10,20);
        // }
    }


    public static void main(String args[])
    {
        TextEditor ob = new TextEditor();
    }
}