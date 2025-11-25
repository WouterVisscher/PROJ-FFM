package nl.kadaster;

import junit.framework.TestCase;
import nl.kadaster.transform.Transformer;
import org.locationtech.jts.geom.Coordinate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TransformerFileTest extends TestCase {

    public void testTransformETRS89ToRDNAP() throws IOException {
        // Setup paths
        Path inputFile = Paths.get("src/test/resources/002_ETRS89.txt");
        Path outputFile = Paths.get("target/test-output/002_RDNAP_RESULT.txt");
        
        // Create output directory if it doesn't exist
        Files.createDirectories(outputFile.getParent());
        
        // Initialize transformer: ETRS89 (lat/long/height) to RDNAP (x/y/z)
        Transformer transformer = new Transformer("EPSG:7931", "EPSG:7415");
        
        // Read input, transform, and write output
        try (BufferedReader reader = Files.newBufferedReader(inputFile);
             BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            
            writer.write("point_id\tx_coordinate\ty_coordinate\theight\n");
            
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                // Skip empty lines, comments, and the first line (column headers)
                if (line.trim().isEmpty() || line.trim().startsWith("#") || lineNumber == 1) {
                    continue;
                }
                
                // Parse coordinates
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 4) {
                    System.err.println("Skipping invalid line " + lineNumber + ": " + line);
                    continue;
                }
                
                try {
                    String identifier = parts[0];
                    double latitude = Double.parseDouble(parts[1]);
                    double longitude = Double.parseDouble(parts[2]);
                    double height = Double.parseDouble(parts[3]);
                    
                    // Transform coordinate (input is phi, lam, z)
                    Coordinate transformed = transformer.transformLPZ(latitude, longitude, height);
                    
                    // Write result with identifier
                    writer.write(String.format("%s\t%.4f\t%.4f\t%.4f%n", 
                        identifier, transformed.y, transformed.x, transformed.z));
                    
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid coordinate on line " + lineNumber + ": " + line);
                }
            }
        }
        
        // Verify output file was created and has content
        assertTrue("Output file should exist", Files.exists(outputFile));
        long lineCount = Files.lines(outputFile).filter(l -> !l.trim().isEmpty() && !l.trim().startsWith("point_id")).count();
        assertTrue("Output file should have transformed coordinates", lineCount > 0);
        
        System.out.println("ETRS89 to RDNAP transformation complete!");
        System.out.println("Input file: " + inputFile.toAbsolutePath());
        System.out.println("Output file: " + outputFile.toAbsolutePath());
    }

    public void testTransformRDNAPToETRS89() throws IOException {
        // Setup paths
        Path inputFile = Paths.get("src/test/resources/002_RDNAP.txt");
        Path outputFile = Paths.get("target/test-output/002_ETRS89_RESULT.txt");
        
        // Create output directory if it doesn't exist
        Files.createDirectories(outputFile.getParent());
        
        // Initialize transformer: RDNAP (x/y/z) to ETRS89 (lat/long/height)
        Transformer transformer = new Transformer("EPSG:7415", "EPSG:7931");
        
        // Read input, transform, and write output
        try (BufferedReader reader = Files.newBufferedReader(inputFile);
             BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            
            writer.write("point_id\tlatitude\tlongitude\theight\n");
            
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                // Skip empty lines, comments, and the first line (column headers)
                if (line.trim().isEmpty() || line.trim().startsWith("#") || lineNumber == 1) {
                    continue;
                }
                
                // Parse coordinates
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 4) {
                    System.err.println("Skipping invalid line " + lineNumber + ": " + line);
                    continue;
                }
                
                try {
                    String identifier = parts[0];
                    double x = Double.parseDouble(parts[1]);
                    double y = Double.parseDouble(parts[2]);
                    double z = Double.parseDouble(parts[3]);
                    
                    // Transform coordinate
                    Coordinate transformed = transformer.transformLPZ(x, y, z);
                    
                    // Write result with identifier (output is phi, lam, z)
                    writer.write(String.format("%s\t%.9f\t%.9f\t%.4f%n", 
                        identifier, transformed.y, transformed.x, transformed.z));
                    
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid coordinate on line " + lineNumber + ": " + line);
                }
            }
        }
        
        // Verify output file was created and has content
        assertTrue("Output file should exist", Files.exists(outputFile));
        long lineCount = Files.lines(outputFile).filter(l -> !l.trim().isEmpty() && !l.trim().startsWith("point_id")).count();
        assertTrue("Output file should have transformed coordinates", lineCount > 0);
        
        System.out.println("RDNAP to ETRS89 transformation complete!");
        System.out.println("Input file: " + inputFile.toAbsolutePath());
        System.out.println("Output file: " + outputFile.toAbsolutePath());
    }
}
