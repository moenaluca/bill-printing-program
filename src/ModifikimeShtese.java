import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.event.*;

/*Ne kete panel kemi perzgjedhjen e modifikimeve apo opsioneve qe perdoruesi do te shtoje ne makinen e tij
 * Jepen te gjithe oprsionet e mundshme dhe ne saje te CheckBox,perdoruesi zgjedh se cilin do prej tyre ku sheh edhe kostot perkatese
 * Gjithashtu kemi edhe dy butona: totali i cili gjeneron totalin e ri ne varesi te perzgjedhjeve dhe printo i cili ben te mundur printimin e fatures
 */


public class ModifikimeShtese extends JPanel implements Printable,ActionListener {

    //Deklarimi i variablave globale

    private String emMbr,nr,model,gjinia,mosha,dataM,dataK,total;
    private JLabel m1,m2,m3,m4,m5,title;
    private JCheckBox p1,j1,p2,j2,p3,j3,p4,j4,p5,j5;
    private JButton printo,tot;
    private JTextField totali;
    ButtonGroup bg1,bg2,bg3,bg4,bg5;

    //Konstruktori i cili si te dhena hyrese do te marri te gjitha te dhenat e nevojshme per printimin e fatures

    public ModifikimeShtese(String emMbr,String nr,String model,String gjinia,String mosha,String dataM,String dataK,String total) {

        setLayout(null);				//Nuk kemi perdorur nje layout por kemi preferuar qe t'i vendosim ne menyre mekanike komponentet
        setBackground(Color.white);		//Kemi vendosur ngjyren e backgroundit

        this.emMbr=emMbr;
        this.nr=nr;
        this.model=model;
        this.gjinia=gjinia;
        this.mosha=mosha;
        this.dataM=dataM;
        this.dataK=dataK;
        this.total=total;

        /*Ne rreshtat e meposhtem kemi vendosur komponentet ne panel,ku jane JLabel te cilat tregojne modifikimin edhe RadioButton
         * po/jo per secilin ku ai perzgjedh njerin prej tyre ne varesi te preferencave
         * Gjithashtu per cdo modifikim kemi perdorur ButtonGroup ne menyre qe perdouesi te zgjedhi vetm njerin(pra ose po ose jo)
         * si dhe te dime se cilen vlere ka zgjedhur ai ne menyre qe te bejme ndryshimet e nevojshme ne vleren totale
         */

        title=new JLabel("Zgjidhni modifikimet qe doni te shtoni ne makinen tuaj:");
        title.setBounds(0,0,400,20);
        title.setFont(new Font("Serif", Font.BOLD, 14));

        m1=new JLabel("Goma debore(5000 All):");
        m1.setBounds(10,40,200,50);

        p1=new JCheckBox("Po");
        p1.setActionCommand("Po");
        p1.setBounds(190,55,50,20);
        p1.setContentAreaFilled(false);
        p1.setFocusPainted(false);
        p1.setBorderPainted(false);

        j1=new JCheckBox("Jo");
        j1.setBounds(245,55,50,20);
        j1.setContentAreaFilled(false);
        j1.setFocusPainted(false);
        j1.setBorderPainted(false);

        bg1=new ButtonGroup();
        bg1.add(p1);bg1.add(j1);

        m2=new JLabel("Mbajtese bagazhesh(1000 All):");
        m2.setBounds(10,70,200,50);

        p2=new JCheckBox("Po");
        p2.setActionCommand("Po");
        p2.setBounds(190,85,50,20);
        p2.setContentAreaFilled(false);
        p2.setFocusPainted(false);
        p2.setBorderPainted(false);

        j2=new JCheckBox("Jo");
        j2.setBounds(245,85,50,20);
        j2.setContentAreaFilled(false);
        j2.setFocusPainted(false);
        j2.setBorderPainted(false);

        bg2=new ButtonGroup();
        bg2.add(p2);bg2.add(j2);

        m3=new JLabel("Bileta parkimi(3000 All):");
        m3.setBounds(10,100,200,50);

        p3=new JCheckBox("Po");
        p3.setActionCommand("Po");
        p3.setBounds(190,115,50,20);
        p3.setContentAreaFilled(false);
        p3.setFocusPainted(false);
        p3.setBorderPainted(false);

        j3=new JCheckBox("Jo");
        j3.setBounds(245,115,50,20);
        j3.setContentAreaFilled(false);
        j3.setFocusPainted(false);
        j3.setBorderPainted(false);

        bg3=new ButtonGroup();
        bg3.add(p3);bg3.add(j3);

        m4=new JLabel("Sigurime(4000 All):");
        m4.setBounds(10,130,200,50);

        p4=new JCheckBox("Po");
        p4.setActionCommand("Po");
        p4.setBounds(190,145,50,20);
        p4.setContentAreaFilled(false);
        p4.setFocusPainted(false);
        p4.setBorderPainted(false);

        j4=new JCheckBox("Jo");
        j4.setBounds(245,145,50,20);
        j4.setContentAreaFilled(false);
        j4.setFocusPainted(false);
        j4.setBorderPainted(false);

        bg4=new ButtonGroup();
        bg4.add(p4);bg4.add(j4);

        m5=new JLabel("Sedilje me ngrohese(6000 All): ");
        m5.setBounds(10,160,200,50);

        p5=new JCheckBox("Po");
        p5.setActionCommand("Po");
        p5.setBounds(190,175,50,20);
        p5.setContentAreaFilled(false);
        p5.setFocusPainted(false);
        p5.setBorderPainted(false);

        j5=new JCheckBox("Jo");
        j5.setBounds(245,175,50,20);
        j5.setContentAreaFilled(false);
        j5.setFocusPainted(false);
        j5.setBorderPainted(false);

        bg5=new ButtonGroup();
        bg5.add(p5);bg5.add(j5);

        //Butoni i cili ben te mundur vendosjen e totalit ne JTextField

        tot=new JButton("Totali");
        tot.setBounds(10,200,70,25);
        tot.addActionListener(this);
        tot.setFocusable(false);
        tot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        totali=new JTextField();
        totali.setBounds(190,200,100,25);
        totali.setEditable(false);

        //Butoni per printimin e fatures

        printo=new JButton(new ImageIcon("fatura.png"));
        printo.setBounds(300,300,248,47);
        printo.setContentAreaFilled(false);
        printo.setFocusPainted(false);
        printo.setBorderPainted(false);
        printo.addActionListener(this);
        printo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Vendosja e te gjithe komponenteve ne panel

        add(title);add(m1);add(m2);add(m3);add(m4);add(m5);add(p1);add(j1);add(p2);add(j2);add(p3);add(j3);
        add(j4);add(p4);add(j4);add(p5);add(j5);add(printo);add(tot);add(totali);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*Nese perzgjidhet butoni tot,atehere ne fillim kontrollojme te gjithe JRadioButton.
         * Nese ata jane perzgjedhur po atehere bejme modifikimin tek totali me vleren e caktuar
         * Ne fund vendosim totalin tek JTextField i paeditueshem
         */

        if(e.getSource()==tot) {


            if(bg1.getSelection().getActionCommand()=="Po") {

                total=(Integer.parseInt(total)+5000)+"";

            }

            if(bg2.getSelection().getActionCommand()=="Po") {

                total=(Integer.parseInt(total)+1000)+"";

            }

            if(bg3.getSelection().getActionCommand()=="Po") {

                total=(Integer.parseInt(total)+3000)+"";

            }

            if(bg4.getSelection().getActionCommand()=="Po") {

                total=(Integer.parseInt(total)+4000)+"";

            }

            if(bg5.getSelection().getActionCommand()=="Po") {

                total=(Integer.parseInt(total)+6000)+"";

            }

            totali.setText(total+" All");

        }

        //Nese perzgjidhet butoni printo atehere krijojme nje objekt te PrintJob per krijimin e fatures dhe gjenerimin e saj ne format pdf

        if(e.getSource()==printo) {

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            boolean ok = job.printDialog();
            if (ok) {
                try {
                    job.print();
                } catch (PrinterException ex) {

                }
            }
        }

    }

    //Ne rreshtat e meposhtem kemi krijimin e formatit te fatures me te gjitha informacionet e nevojshme

    public int print(Graphics g, PageFormat pf,int page) throws PrinterException {


        if (page > 0) {
            return NO_SUCH_PAGE;
        }


        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        g.drawString("**********************************************", 220, 40);
        g.drawString("\nUBT Makina me Qera",270, 70);
        g.drawString("**********************************************", 220, 100);
        g.drawString("\nKlienti: "+emMbr,270,130);
        g.drawString("\nKontakt: "+nr,270,220);
        g.drawString("\nModeli i makines: "+model,270,250);
        g.drawString("\nGjinia: "+gjinia,270,190);
        g.drawString("\nMosha: "+mosha,270,160);
        g.drawString("\nData e marrjes: "+dataM,270,280);
        g.drawString("\nData e kthimit: "+dataK,270,310);
        g.drawString("\n********************************************",220,340);
        g.drawString("\nTotali: "+total+" All",270,370);
        g.drawString("\n********************************************",220,400);
        g.drawString("\n*****Faleminderit qe zgjodhet UBT Makina me Qera!*****",180,430);


        return PAGE_EXISTS;


    }


}


