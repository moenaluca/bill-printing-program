import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*Ne kete panel kemi krijimin e faqjes se pare te programimit.
 * Ajo eshte e perbere nga 9 imazhe te vendosur ne pjesen e djathte te ekranit si dhe siper imazheve eshte dhene edhe modeli perkates i makines.
 * Cdo imazh eshte i klikueshem dhe ne momentin kur perdoruesi klikon ne imazhin e nje makine,ne pjesen e majte te ekranit,atij do t'i shfaqet
 * emri i makines ne fillim,poshte saj imazhi i makines dhe poshte imazhit disa karakteristika te makines se klikuar,ku ai mund te zbuloje me teper per makinen dhe koston.
 * Pasi mbaron edhe pershkrimi kemi nje buton te cillin e kemi emertuar "Merr me qera",i cili na ben te mundur kalimin ne faqjen e fatures
 */


public class PaneliKryesor extends JPanel implements ActionListener {

    /*Ne 5 rreshtat e meposhtem kemi deklarimin e variablave globale
     *(pjesa me e madhe jane JLabel si dhe kemi edhe JTextArea,JButton dhe nje integer qe do te mbaje cmimin pasi na nevojitet per kalimin e te dhenave ne panelet e tjera)
     */

    private JLabel b1,b2,b3,b4,b5,b6,b7,b8,b9,previewModel;
    private JLabel img1,img2,img3,img4,img5,img6,img7,img8,img9,previewImage;
    private JTextArea pershkrim;
    private JButton zgjidh;
    int cmimi;

    /*Ne 9 rreshtat e meposhtem kemi krijuar objekte te klases ShtoMakine ku si te dhena hyres ato marrin
     *modelin(String),nje ImageIcon per te pare makine vizualisht,pershkrimin ose detajet rreth makines(Sring) dhe cmimin(int)
     */


    ShtoMakine m1=new ShtoMakine("Audi Q7",new ImageIcon("r1.jpg"),"Motorri:3.0 L V6\nKuaj Fuqi:225\n0-100:8.4 sec\nShpejtesia max:250 km/h",10000);
    ShtoMakine m2=new ShtoMakine("BMW Seria 7",new ImageIcon("r2.jpg"),"Motorri:Twin Power Turbo\nKuaj Fuqi:450\n0-100:7 sec\nShpejtesia max:250 km/h",12000);
    ShtoMakine m3=new ShtoMakine("BMW X5",new ImageIcon("r3.jpg"),"Motorri:4.8 L\nKuaj Fuqi:350\n0-100:6.5 sec\nShpejtesia max:241 km/h",5000);
    ShtoMakine m4=new ShtoMakine("Mercedes G63 AMG",new ImageIcon("r4.jpg"),"Motorri:5.5 V8\nKuaj Fuqi:544\n0-100:5.4 sec\nShpejtesia max:210 km/h",20000);
    ShtoMakine m5=new ShtoMakine("Audi R8 Spyder",new ImageIcon("r5.jpg"),"Motorri:5.2 L V10\nKuaj Fuqi:518\n0-100:3.9 sec\nShpejtesia max:317 km/h",25000);
    ShtoMakine m6=new ShtoMakine("Mercedes S-Class",new ImageIcon("r6.jpg"),"Motorri:BlueTec V6\nKuaj Fuqi:254\n0-100:6.8 sec\nShpejtesia max:249 km/h",15000);
    ShtoMakine m7=new ShtoMakine("Porsche Cayenne",new ImageIcon("r7.jpg"),"Motorri:4.8L V8\nKuaj Fuqi:385\n0-100:4.7 sec\nShpejtesia max:275 km/h",5000);
    ShtoMakine m8=new ShtoMakine("Range Rover Sport",new ImageIcon("r8.jpg"),"Motorri:4.4L V8\nKuaj Fuqi:305\n0-100:8.2 sec\nShpejtesia max:209 km/h",5000);
    ShtoMakine m9=new ShtoMakine("Mercedes Benz V-Class",new ImageIcon("r9.jpg"),"Motorri:2.1L TurboDiesel\nKuaj Fuqi:190\n0-100:9.1 sec\nShpejtesia max:207 km/h",15000);

    //Ne rreshtat e meposhtem kemi konstruktorin,ku kemi vendosur te gjitha komponentet tone ne panel


    public PaneliKryesor() {

        setLayout(null);				//Nuk kemi perdorur nje layout por kemi preferuar qe t'i vendosim ne menyre mekanike komponentet
        setBackground(Color.WHITE);		//Kemi vendosur ngjyren e backgroundit


        /*Ne 6 rreshtat e meposhtem kemi vendosjen e JLabeleve ne panel ku i kemi ndare ne dy pjese kryesore:
         * Ne fillim kemi vendosur JLabel i cili tregon modelin e makines te cillin e marrim nga objektet e krijuara ne fillim
         * dhe poshte tij kemi nje JLabel tjeter i cili si te dhene hyrese do te marri nje image(i cili do te jete i klikueshem)
         * qe gjithashtu do te merret nga objekti perkates i krijuar,i cili ben te mundur vizualizimin e modelit
         * E njejta procedure eshte kryer per 8 makinat e tjera deri ne rreshtin 110
         */

        b1=new JLabel(m1.getModel()); 					//m1.getModel() na ben te mundur marrjen modelit te makines
        b1.setBounds(300,30,100,20);
        b1.setFont(new Font("Serif", Font.BOLD, 14));	//Kemi perzgjedhur fontin
        img1=new JLabel(m1.getImage());
        img1.setBounds(300,55,150,100);
        img1.setCursor(new Cursor(Cursor.HAND_CURSOR));	//Kemi ndryshur kursorin qe ne momentin qe jemi siper nje imazhi,kursori te jete ne formen e dores perderisa imazhi eshte i klikueshem

        b2=new JLabel(m2.getModel());
        b2.setBounds(520,30,100,20);
        b2.setFont(new Font("Serif", Font.BOLD, 14));
        img2=new JLabel(m2.getImage());
        img2.setBounds(520,55,150,100);
        img2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b3=new JLabel(m3.getModel());
        b3.setBounds(740,30,100,20);
        b3.setFont(new Font("Serif", Font.BOLD, 14));
        img3=new JLabel(m3.getImage());
        img3.setBounds(740,55,150,100);
        img3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b4=new JLabel(m4.getModel());
        b4.setBounds(300,185,150,20);
        b4.setFont(new Font("Serif", Font.BOLD, 14));
        img4=new JLabel(m4.getImage());
        img4.setBounds(300,210,150,100);
        img4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b5=new JLabel(m5.getModel());
        b5.setBounds(520,185,100,20);
        b5.setFont(new Font("Serif", Font.BOLD, 14));
        img5=new JLabel(m5.getImage());
        img5.setBounds(520,210,150,100);
        img5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b6=new JLabel(m6.getModel());
        b6.setBounds(740,185,150,20);
        b6.setFont(new Font("Serif", Font.BOLD, 14));
        img6=new JLabel(m6.getImage());
        img6.setBounds(740,210,150,100);
        img6.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b7=new JLabel(m7.getModel());
        b7.setBounds(300,340,150,20);
        b7.setFont(new Font("Serif", Font.BOLD, 14));
        img7=new JLabel(m7.getImage());
        img7.setBounds(300,365,150,100);
        img7.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b8=new JLabel(m8.getModel());
        b8.setBounds(520,340,150,20);
        b8.setFont(new Font("Serif", Font.BOLD, 14));
        img8=new JLabel(m8.getImage());
        img8.setBounds(520,365,150,100);
        img8.setCursor(new Cursor(Cursor.HAND_CURSOR));

        b9=new JLabel(m9.getModel());
        b9.setBounds(740,340,150,20);
        b9.setFont(new Font("Serif", Font.BOLD, 14));
        img9=new JLabel(m9.getImage());
        img9.setBounds(740,365,150,100);
        img9.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*Ne 7 rreshtat e meposhtem,previeModel,previewImage dhe pershkrim jane komponentet te cilet
         * bejne te mundur qe ne rastin kur ne klikojme ne imazhin e nje makine te caktuar,ne krahun
         * e majte te ekranit te shfaqet modeli,imazhi dhe cilesite kryesore te makines se klikuar.
         * Ne fillim vlerat e tyre i kemi lene bosh deri ne momentin qe nje imazh do te klikohet
         */


        previewModel=new JLabel(" ");
        previewImage=new JLabel(" ");
        previewModel.setBounds(10,5,100,100);
        previewImage.setBounds(10,55,100,100);
        pershkrim=new JTextArea("");
        pershkrim.setEditable(false);
        pershkrim.setBounds(10,160,300,300);


        /*Ne 7 rreshtat e meposhtem kemi butonin,te cilit i kemi vendosur nje imazh per ta bere me estetik
         * dhe i kemi vendosur edhe ActionListener qe e menyre kur ai te klikohet te hapet dritarja e fatures
         * per plotesimin e te dhenave te nevojshme per mmarrjen e makines me qera
         */


        zgjidh=new JButton(new ImageIcon("buton.png"));
        zgjidh.setBounds(10,300,206,54);
        zgjidh.setContentAreaFilled(false);
        zgjidh.setFocusPainted(false);
        zgjidh.setBorderPainted(false);
        zgjidh.addActionListener(this);
        zgjidh.setCursor(new Cursor(Cursor.HAND_CURSOR));


        /*Ne rreshtat e meposhtem i kemi dhene imazheve tona MouseListener qe ne momentin qe ndonjeri prej tyre
         * te klikohet previewModel,previewImage dhe pershkrim te marri vlerat e imazhit te klikuar
         * dhe ne te kete menyre ne te majte te ekranit do te na shfaqet te gjitha te dhenat e nevojshme per
         * makinen e klikuar.E njejta procedure eshte ndjekur edhe per 8 makinat e tjera deri ne rreshtin 337
         */

        img1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                /*Ne fiilim kemi venodosur setVisible te treja variablave qe do te bejne afishimine elementeve te makines.
                 * Arsyeja e kryerjes se ketij veprimi eshte qe ne momentin kur do te klikohet nje imazh tjeter ne panel
                 * ai nuk do te mbivenodset mbi imazhin dhe te dhenat parardhese por do t'i zevendesoje ato.
                 * Me pas duke marre te dhenat nga objektet perkatese i kemi vendosur ato ne panel dhe ne fund kemi bere
                 * repaint panelin me te dhenat e reja te vendosura.
                 * Te njejten procedure kemi kryer edhe per 8 imazhet e tjera
                 */

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m1.getCmim();
                previewModel=new JLabel(m1.getModel());
                previewModel.setBounds(10,20,100,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m1.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m1.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m2.getCmim();
                previewModel=new JLabel(m2.getModel());
                previewModel.setBounds(10,20,100,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m2.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m2.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m3.getCmim();
                previewModel=new JLabel(m3.getModel());
                previewModel.setBounds(10,20,100,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m3.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m3.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img4.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m4.getCmim();
                previewModel=new JLabel(m4.getModel());
                previewModel.setBounds(10,20,150,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m4.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m4.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img5.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m5.getCmim();
                previewModel=new JLabel(m5.getModel());
                previewModel.setBounds(10,20,100,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m5.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m5.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img6.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m1.getCmim();
                previewModel=new JLabel(m6.getModel());
                previewModel.setBounds(10,20,150,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m6.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m6.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img7.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m7.getCmim();
                previewModel=new JLabel(m7.getModel());
                previewModel.setBounds(10,20,150,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m7.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m7.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img8.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m8.getCmim();
                previewModel=new JLabel(m8.getModel());
                previewModel.setBounds(10,20,150,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m8.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m8.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        img9.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                previewModel.setVisible(false);
                previewImage.setVisible(false);
                pershkrim.setVisible(false);
                cmimi=m9.getCmim();
                previewModel=new JLabel(m9.getModel());
                previewModel.setBounds(10,20,150,20);
                previewModel.setFont(new Font("Serif", Font.BOLD, 14));
                previewImage=new JLabel(m9.getImage());
                previewImage.setBounds(10,55,150,100);
                pershkrim=new JTextArea("Kostoja ditore: "+cmimi+" All\n"+m9.getPershkrimi());
                pershkrim.setBounds(10,180,200,100);
                add(previewModel);add(previewImage);add(pershkrim);
                repaint();

            }
        });

        //Ne 3 rreshtat e meposhtem kemi vendosjen e te gjithe komponenteve ne panel

        add(b1);add(img1);add(b2);add(img2);add(b3);add(img3);add(b4);add(img4);
        add(b5);add(img5);add(b6);add(img6);add(b7);add(img7);add(b8);add(img8);
        add(b9);add(img9);add(zgjidh);add(previewModel);add(previewImage);add(pershkrim);

    }

    //Ne rreshtat e meposhtem i kemi dhene butonit ActionListener

    public void actionPerformed(ActionEvent e) {

        //Nese butoni shtypet pa klikuar ne asnje makine atehere,gjenerojme nje mesazh gabimi

        if(previewModel.getText()==" ") {

            JOptionPane.showMessageDialog(null,"Ju lutem zgjidhni nje makine!");

        }

        /*Perndryshe eshte zgjedhur nje makine dhe shkojme ne faqen e fatures.
         * Ne fiilim kemi krijuar nje JFrame dhe i kemi vendosur panelin e fatures te krijuar
         * i cili merr si te dhena modelin(JLabel),imazhin(JLabel),cmimin(int) dhe pershkrimin(JTextArea)
         */

        else {

            JFrame kornizaFature=new JFrame("Fatura");
            kornizaFature.setSize(600,500);
            kornizaFature.getContentPane().add(new PaneliFature(previewModel,previewImage,cmimi,pershkrim));
            kornizaFature.setVisible(true);
        }
    }

}

