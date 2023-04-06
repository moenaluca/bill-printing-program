import javax.swing.ImageIcon;

/*Kemi ndertuar nje klase ShtoMakine e cila do te perdoret tek PaneliKryesor
 * Variablat perberes te kesaj klase jane modeli,imazhi,pershkrimi dhe kostoja ditore e makines
 * Kemi ndetuar konstruktorin dhe kemi krijuar getters per secilin prej variablave
 */

public class ShtoMakine {

    private String modeli;
    private ImageIcon img;
    private String pershkrimi;
    private int cmimi;


    public ShtoMakine(String modeli,ImageIcon img,String pershkrimi,int cmimi) {

        this.modeli=modeli;
        this.img=img;
        this.pershkrimi=pershkrimi;
        this.cmimi=cmimi;

    }


    public String getModel() {

        return modeli;

    }

    public ImageIcon getImage() {

        return img;
    }

    public String getPershkrimi() {

        return pershkrimi;

    }

    public int getCmim() {

        return cmimi;
    }

}

