package nl.kadaster;

import org.locationtech.jts.geom.Coordinate;

import nl.kadaster.transform.Transformer;


public class App 
{
    public static void main( String[] args )
    {
        Transformer transformer = new Transformer("EPSG:28992", "EPSG:9067");
        Coordinate coord1 = transformer.transformLPZ( 155000, 463000, 0);
        Coordinate coord2 = transformer.transformLPZ( 155000, 463000, 0);

        Coordinate coord3 = transformer.transformLPZ( 155000, 463000, 0);


        System.out.println("Transformed Coordinate: " + coord1);
        System.out.println("Transformed Coordinate: " + coord2);
        System.out.println("Transformed Coordinate: " + coord3);
    }
}
