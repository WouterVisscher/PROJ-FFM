package nl.kadaster.transform;

import org.locationtech.jts.geom.CoordinateSequence;
import org.locationtech.jts.geom.CoordinateSequenceFilter;

public class Etrs89ToRdTransformation implements CoordinateSequenceFilter {

    private final Transformer transformer;

    public Etrs89ToRdTransformation(String sourceCrs, String targetCrs) {
        this.transformer = new Transformer(sourceCrs, targetCrs);
    }

    @Override
    public void filter(CoordinateSequence sequence, int i) {

        var coordinate = sequence.getCoordinate(i);
        var rdCoordinate = this.transformer.transformXYZ(coordinate.getX(),
                coordinate.getY(), coordinate.getZ());
        sequence.setOrdinate(i, 0, rdCoordinate.getX());
        sequence.setOrdinate(i, 1, rdCoordinate.getY());
        if (sequence.getDimension() > 2) {
            sequence.setOrdinate(i, 2, rdCoordinate.getZ());
        }
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public boolean isGeometryChanged() {
        return true;
    }
}