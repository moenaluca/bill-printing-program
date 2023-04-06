import java.awt.*;
import java.awt.print.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import java.awt.event.*;

/*Ne kete panel kemi plotesimin e te dhenave te perdoruesit per marrjen e makines me qera,duke perdorur nje nderthurje te komponenteve te java swing.
 * Pasi perdoruesi ploteson te dhenat ai mund te llogaris si fillim totalin,duke klikuar mbi butonin perkates dhe te zgjedhi midis dy butonave te tjere:
 * modifiko nese deshiron qe ai te modifikoje makinen dhe t'i shtoje ndonje cilesi shtese(sigurisht cdo perzgjedhje i shtohet kostos totale) ose te zgjedhi
 * butonin Printo fature e cila ben te mundur printimin e nje fature e cila ne saje te implementit te PrintJob eshte nje fature e cila mund te printohet
 * direkt ne printer ose te ruhet ne kompjuterin tuaj ne formatin pdf,e cila eshte pothuajse identike si faturat normale dhe i jep programit nje perdorim sa me real
 */

public class PaneliFature extends JPanel implements Printable,ActionListener{

    //Me poshte kemi deklarimin e variablave globale

    private JLabel emri,mbiemri,mosha,gjinia,nrDite,nrCel;
    private JTextField emr,mbiemr,nrCelular,tot;
    private JRadioButton mashkull,femer;
    private JComboBox mosh,nrDit;
    private JLabel pic,modeli;
    private int cmimi=0;
    private JButton totali,modifiko;
    private JTextArea detajet;
    private JButton print;
    private GregorianCalendar data;
    private int dita,muaji,viti,ditaKthim,muajiKthim;
    ButtonGroup bg;



    /*Ne rreshta vijues kemi konstruktorin,i cili merr si parametra hyres modelin,imazhin,cmimin dhe detajet perkates te makines se klikuar
     * si dhe vendos te gjitha komponentet ne panel
     */

    public PaneliFature(JLabel modeli,JLabel pic,int cmimi,JTextArea detajet){

        this.modeli=modeli;
        this.pic=pic;
        this.cmimi=cmimi;
        this.detajet=detajet;

        setLayout(null);				//Nuk kemi perdorur nje layout por kemi preferuar qe t'i vendosim ne menyre mekanike komponentet
        setBackground(Color.white);		//Kemi vendosur ngjyren e backgroundit

        //Ne kater rreshtat e meposhtem kemi vendosur ne panel modelin,imazhin dhe detajet perkatese te makines se perzgjedhur

        modeli.setBounds(300,5,150,20);
        modeli.setFont(new Font("Serif", Font.BOLD, 14));

        pic.setBounds(300,60,150,100);
        detajet.setBounds(300,180,200,100);


        /*Ne rreshtat e meposhtem kemi vendosjen e te gjithe komponenteve ne panel si emri,mbiemri mosha,gjinia,nrcel etj
         * te cilat ashtu sic e permendem jane nje nderthurje e disa prej elementeve te java swing
         */


        emri=new JLabel("Emri:");
        emri.setBounds(20,10,50,50);

        emr=new JTextField();
        emr.setBounds(80,25,100,25);

        mbiemri=new JLabel("Mbiemri:");
        mbiemri.setBounds(20,50,50,50);

        mbiemr=new JTextField();
        mbiemr.setBounds(80,65,100,25);

        mosha=new JLabel("Mosha:");
        mosha.setBounds(20,90,50,50);

        //Ne rreshtat e meposhtem kemi perdorur nje cikel for per te mbushur JComboBox dhe diapazioni i moshes eshte zgjedhur 18-90

        mosh=new JComboBox();

        for(int i=18;i<=90;i++) {

            mosh.addItem(i);
        }

        mosh.setBounds(80,105,50,25);

        gjinia=new JLabel("Gjinia:");
        gjinia.setBounds(20,130,50,50);

        /*Ne rreshtat e meposhtem kemi  perdorimin e JRadioButton per gjininen,ku kemi perdoru edhe ButtonGroup
         *  per te bere te mundur qe te zgjidhet vetem njera prej alternativave dhe te marrim rezultatin e zgjedhur
         */

        mashkull=new JRadioButton("Mashkull");
        mashkull.setBounds(80,150,80,15);
        mashkull.setActionCommand("Mashkull");
        mashkull.setContentAreaFilled(false);
        mashkull.setFocusPainted(false);
        mashkull.setBorderPainted(false);

        femer=new JRadioButton("Femer");
        femer.setBounds(180,150,80,15);
        femer.setActionCommand("Femer");
        femer.setContentAreaFilled(false);
        femer.setFocusPainted(false);
        femer.setBorderPainted(false);

        bg=new ButtonGroup();
        bg.add(mashkull);
        bg.add(femer);



        nrDite=new JLabel("N.r i diteve: ");
        nrDite.setBounds(15,170,80,50);

        /*Per numrin e diteve qe perdoruesi do te zgjedhe te marre makinen me qera kemi perzgjedhur
         * perseri nje JComboBox ku nepermjet nje cikli for kemi mbushur JComboBox me vlera ne diapazonin 1-31
         */

        nrDit=new JComboBox();

        for(int i=1;i<=31;i++) {
            nrDit.addItem(i);
        }

        nrDit.setBounds(80,185,50,25);

        nrCel=new JLabel("N.r Cel:");
        nrCel.setBounds(20,210,50,50);

        nrCelular=new JTextField();
        nrCelular.setBounds(80,225,100,25);

        tot=new JTextField("");
        tot.setBounds(80,265,100,25);
        tot.setEditable(false);

        //Me poshte eshte butoni i cili do te beje te mundur llogaritjen e totalit

        totali=new JButton("Totali:");
        totali.setBounds(5,265,70,25);
        totali.addActionListener(this);
        totali.setFocusable(false);
        totali.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Me poshte eshte butoni i cili do te beje te mundur te shkojme ne faqen e modifikimeve nese perdoruesi zgjedh te shtoje opsione shtese

        modifiko=new JButton(new ImageIcon("modifiko.png"));
        modifiko.setBounds(300,300,154,43);
        modifiko.setContentAreaFilled(false);
        modifiko.setFocusPainted(false);
        modifiko.setBorderPainted(false);
        modifiko.addActionListener(this);
        modifiko.setCursor(new Cursor(Cursor.HAND_CURSOR));;

        //Me poshte eshte butoni i cili ben te mundur printimin e fatures

        print=new JButton(new ImageIcon("fatura.png"));
        print.setBounds(200,380,248,47);
        print.setContentAreaFilled(false);
        print.setFocusPainted(false);
        print.setBorderPainted(false);
        print.addActionListener(this);
        print.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Me poshte kemi perdorimin e dates aktuale per te bere llogarite e nevojshme per daten kur eshte marre makina me qera dhe per daten kur do te kthehet

        data=new GregorianCalendar();
        dita=data.get(Calendar.DAY_OF_MONTH);
        muaji=data.get(Calendar.MONTH);
        viti=data.get(Calendar.YEAR);

        //Me poshte kemi vendosjen e te gjithe komponenteve ne panel

        add(modeli);add(pic);add(detajet);add(emri);add(emr);add(mbiemri);add(mbiemr);add(mosha);add(mosh);
        add(gjinia);add(mashkull);add(femer);add(nrDite);add(nrDit);add(nrCel);add(nrCelular);add(tot);add(totali);add(print);add(modifiko);

    }

    //Kemi funksionin i cili do te na ktheje totalin

    public String getTotal(int vl1,int vl2) {

        return (vl1*vl2)+"";

    }

    //Ne rreshtat e meposhtem i kemi dhene butonave ActionListener

    public void actionPerformed(ActionEvent e) {

        /*Nese klikohet butoni totali atehere ne JTextField e paeditueshem tot,vendos vleren e totalit
         * (shohim se vlera e totalit eshte llogaritur duke perdorur funksionin getTotal te krijuar me siper
         * i cili si variabla hyres ka marre cmimin qe e marrim nga klasa PaneliKryesor si dhe vleren e zgjedhur ne JComboBoc nrDit
         * e cila ishte per numrin e diteve qe perdoruesi donte te merrte me qera makinen)
         */

        if(e.getSource()==totali) {

            tot.setText(getTotal(cmimi,(int)nrDit.getSelectedItem()));

        }

        /*Nese klikohet butoni print,atehere si fillim shohim daten,nese data aktuale plus nr e diteve do te jete me e madhe se 31
         * atehere do te kalojme ne muajin tjeter dhe si date do te vendosim shumen minus 31(kjo gje behet qe data e kthimit ne fature te vendose korrekte)
         * Nese nuk eshte me e madhe se 31 atehere thjeshte mbledhim daten aktuale me numrin e diteve te perzgjedhur si dhe vendosim muajin aktual
         * Ne rreshtat e fundit kemi krijimin e nje objekti te PrinterJob i cili do te na mundesoje printimin e fatures dhe gjenerimin e saj ne format pdf
         */

        if(e.getSource()==print) {


            if(dita+(int)nrDit.getSelectedItem()>31) {

                ditaKthim=(dita+(int)nrDit.getSelectedItem())-31;
                muajiKthim=data.get(Calendar.MONTH)+2;
            }

            else {

                ditaKthim=dita+(int)nrDit.getSelectedItem();
                muajiKthim=data.get(Calendar.MONTH)+1;
            }

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

        /*Nese klikohet butoni modifiko,atehere do te kryhet si fillim i njejti validim per daten
         * sepse perseri do te printojme fature dhe ne fature do te vendosim daten e kthimit
         * Me pas do te shkojme ne faqen e modifikimeve,ku ne fillim kemi krijuar nje JFrame dhe i kemi dhene si panel
         * ModifikimeShtese i cili do te marre emrin dhe mbiemrin,numrin e celularit,modelin e makines,gjinine,moshen
         * daten e marrjes,daten e kthimit si dhe totalin(vlera e te cilit ne baaze te perzgjedhjeve,do te ndryshoje ne kete panel).
         * Pra kemi marre te gjitha te dhenat qe na duhen per te printuar faturen,ku totali ne baze te perzgjedhjeve do te ndryshoje
         */

        if(e.getSource()==modifiko) {

            if(dita+(int)nrDit.getSelectedItem()>31) {
                ditaKthim=(dita+(int)nrDit.getSelectedItem())-31;
                muajiKthim=data.get(Calendar.MONTH)+2;
            }

            else {
                ditaKthim=dita+(int)nrDit.getSelectedItem();
                muajiKthim=data.get(Calendar.MONTH)+1;
            }

            JFrame modShtese=new JFrame("Modifikimet");
            modShtese.setSize(600,400);
            modShtese.getContentPane().add(new ModifikimeShtese(emr.getText()+" "+mbiemr.getText(),nrCelular.getText(),modeli.getText(),bg.getSelection().getActionCommand(),mosh.getSelectedItem().toString(),dita+"/"+(muaji+1)+"/"+viti,ditaKthim+"/"+muajiKthim+"/"+viti,tot.getText()));
            modShtese.setVisible(true);
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
        g.drawString("\nKlienti: "+emr.getText()+" "+mbiemr.getText(),270,130);
        g.drawString("\nKontakt: "+nrCelular.getText(),270,220);
        g.drawString("\nModeli i makines: "+modeli.getText(),270,250);
        g.drawString("\nGjinia: "+bg.getSelection().getActionCommand(),270,190);
        g.drawString("\nMosha: "+mosh.getSelectedItem(),270,160);
        g.drawString("\nData e marrjes: "+dita+"/"+(muaji+1)+"/"+viti,270,280);
        g.drawString("\nData e kthimit: "+ditaKthim+"/"+muajiKthim+"/"+viti,270,310);
        g.drawString("\n********************************************",220,340);
        g.drawString("\nTotali: "+tot.getText()+" All",270,370);
        g.drawString("\n********************************************",220,400);
        g.drawString("\n****Faleminderit qe zgjodhet UBT Makina me Qera!****",180,430);


        return PAGE_EXISTS;


    }
}

