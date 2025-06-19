package nl.kadaster.transform;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.locationtech.jts.geom.Coordinate;

import nl.kadaster.proj.PJ_COORD;
import nl.kadaster.proj.PJ_XYZ;
import nl.kadaster.proj.PJ_LPZ;
import nl.kadaster.proj.proj_h;

public class Transformer {

    private final Arena arena;
    private final MemorySegment projTrans;

    public Transformer(String sCrs, String tCrs) {
        this.arena = Arena.ofShared();
        this.projTrans = projTrans(sCrs, tCrs);
    }

    public Transformer(Arena arena, String sCrs, String tCrs) {
        this.arena = arena;
        this.projTrans = projTrans(sCrs, tCrs);
    }

    public Coordinate transformXYZ(double x, double y, double z) {
        MemorySegment new_coord = transform(this.projTrans, x, y, z);

        return new Coordinate(PJ_XYZ.x(new_coord),
                PJ_XYZ.y(new_coord),
                PJ_XYZ.z(new_coord));
    }

    public Coordinate transformLPZ(double x, double y, double z) {
        MemorySegment new_coord = transform(this.projTrans, x, y, z);

        return new Coordinate(PJ_LPZ.phi(new_coord),
                PJ_LPZ.lam(new_coord),
                PJ_LPZ.z(new_coord));
    }

    private MemorySegment projTrans(String sCrs, String tCrs) {
        final var NULL = MemorySegment.NULL;
        final var sourceCrs = arena.allocateFrom(sCrs);
        final var targetCrs = arena.allocateFrom(tCrs);

        MemorySegment context = proj_h.proj_context_create();
        MemorySegment pj = proj_h.proj_create_crs_to_crs(context, sourceCrs, targetCrs, NULL);

        return pj;
    }

    private MemorySegment transform(MemorySegment projTrans, double x, double y, double z) {

        MemorySegment coord = proj_h.proj_coord(arena, x, y, z, 0);
        MemorySegment proj_trans = proj_h.proj_trans(arena, projTrans, 1, coord);
        MemorySegment new_coord = PJ_COORD.xyz(proj_trans);

        new_coord = new_coord.reinterpret(PJ_COORD.xyz$layout().byteSize());
        return new_coord;
    }
}
