package nl.kadaster.transform;

import org.locationtech.jts.geom.CoordinateSequence;
import org.locationtech.jts.geom.CoordinateSequenceFilter;

public class RdNapToEtrs89Transformation implements CoordinateSequenceFilter {

    private final Transformer transformer;

    public RdNapToEtrs89Transformation(String sourceCrs, String targetCrs) {
        this.transformer = new Transformer(sourceCrs, targetCrs);
    }

    @Override
    public void filter(CoordinateSequence sequence, int i) {

        var coordinate = sequence.getCoordinate(i);
        var etrs89Coordinate = transformer.transformLPZ(coordinate.getX(),
                coordinate.getY(), coordinate.getZ());
        sequence.setOrdinate(i, 0, etrs89Coordinate.getX());
        sequence.setOrdinate(i, 1, etrs89Coordinate.getY());
        if (sequence.getDimension() > 2) {
            sequence.setOrdinate(i, 2, etrs89Coordinate.getZ());
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