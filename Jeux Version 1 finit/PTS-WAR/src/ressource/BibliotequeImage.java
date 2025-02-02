package ressource;

import javafx.scene.image.Image;

//Cette classe permet de precharger les image utiliser en jeux

public class BibliotequeImage {

    //Case
    public static Image contour = new Image("/ressource/image/ContourV1.png");
    public static Image plaine = new Image("/ressource/image/Plains.png");
    public static Image ocean = new Image("/ressource/image/sea.png");
    public static Image plaineClean = new Image("/ressource/image/cleanPlains.png");
    public static Image oceanClean = new Image("/ressource/image/cleanSea.png");

    //Batiment Neutre
    public static Image usine = new Image("/ressource/image/UsineNeutre.png");
    public static Image ville = new Image("/ressource/image/VilleNeutreV1.png");

    //Batiment Bleu
    public static Image blueUsine = new Image("/ressource/image/UsineBleueV1.png");
    public static Image blueVille = new Image("/ressource/image/VilleBleueV1.png");

    //Batiment rouge
    public static Image redUsine = new Image("/ressource/image/UsineRougeV1.png");
    public static Image redVille = new Image("/ressource/image/VilleRougeV1.png");

    //Uniter bleu
    public static Image blueBazooka = new Image("/ressource/image/BlueBazookaV1.png");
    public static Image blueInfantrie = new Image("/ressource/image/BlueInfantryV1.png");
    public static Image blueTank = new Image("/ressource/image/BlueTankV1.png");

    //Uniter rouge
    public static Image redBazooka = new Image("/ressource/image/RedBazookaV1.png");
    public static Image redInfantrie = new Image("/ressource/image/RedInfantryV1.png");
    public static Image redTank = new Image("/ressource/image/RedTankV1.png");
    
    public static Image randomeImageOcean()
    {
        double nombreAleatoir = 0+Math.random()*101;
        if(nombreAleatoir < 40)
        {
            return ocean;
        }else
        {
            return oceanClean;
        }
    }
    
        public static Image randomeImagePlain()
    {
        double nombreAleatoir = 0+Math.random()*101;
        if(nombreAleatoir < 60)
        {
            return plaine;
        }else
        {
            return plaineClean;
        }
    }
}
