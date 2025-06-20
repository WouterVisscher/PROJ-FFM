// Generated by jextract

package nl.kadaster.proj;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct {
 *     char *auth_name;
 *     char *name;
 * }
 * }
 */
public class PROJ_CELESTIAL_BODY_INFO {

    PROJ_CELESTIAL_BODY_INFO() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        proj_h.C_POINTER.withName("auth_name"),
        proj_h.C_POINTER.withName("name")
    ).withName("$anon$1124:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout auth_name$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("auth_name"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *auth_name
     * }
     */
    public static final AddressLayout auth_name$layout() {
        return auth_name$LAYOUT;
    }

    private static final long auth_name$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *auth_name
     * }
     */
    public static final long auth_name$offset() {
        return auth_name$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *auth_name
     * }
     */
    public static MemorySegment auth_name(MemorySegment struct) {
        return struct.get(auth_name$LAYOUT, auth_name$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *auth_name
     * }
     */
    public static void auth_name(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(auth_name$LAYOUT, auth_name$OFFSET, fieldValue);
    }

    private static final AddressLayout name$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("name"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *name
     * }
     */
    public static final AddressLayout name$layout() {
        return name$LAYOUT;
    }

    private static final long name$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *name
     * }
     */
    public static final long name$offset() {
        return name$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *name
     * }
     */
    public static MemorySegment name(MemorySegment struct) {
        return struct.get(name$LAYOUT, name$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *name
     * }
     */
    public static void name(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(name$LAYOUT, name$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

