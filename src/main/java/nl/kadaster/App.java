package nl.kadaster;

import org.locationtech.jts.geom.Coordinate;

import nl.kadaster.transform.Transformer;


public class App 
{
    public static void main( String[] args )
    {
        Transformer transformer = new Transformer("EPSG:28992", "EPSG:9067");
        Coordinate coord1 = transformer.transformLPZ( 155029, 463001, 0);   // Amersfoort O.L. Vrouwetoren Amersfoort
        Coordinate coord2 = transformer.transformLPZ( 	194632, 469365, 0);  // Apeldoorn AGRS de Grift

        Coordinate coord3 = transformer.transformLPZ( 194164, 465895, 0); // Amersfoort NETPOS de Brug


        System.out.println("Transformed Coordinate: " + coord1);
        System.out.println("Transformed Coordinate: " + coord2);
        System.out.println("Transformed Coordinate: " + coord3);
    }
}
