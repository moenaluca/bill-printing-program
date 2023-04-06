import javax.swing.*;

/*Kemi krijuar nje klase per kornizen e cila do te mbaje panelin kryesor
 * Shohim se varialat perberes te saj jane gjeresia dhe gjatesia dhe ne fund kemi shtuar edhe panelin tone kryesor
 */

public class KornizaKryesore extends JFrame {


    private int gjeresi;
    private int gjatesi;

    public KornizaKryesore(int gjeresi,int gjatesi) {


        this.gjeresi=gjeresi;
        this.gjatesi=gjatesi;

        setSize(gjeresi,gjatesi);
        setTitle("UBT Makina me Qera");
        getContentPane().add(new PaneliKryesor());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}

