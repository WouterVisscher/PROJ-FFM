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
 *     long long __clang_max_align_nonce1;
 *     long double __clang_max_align_nonce2;
 * }
 * }
 */
public class max_align_t {

    max_align_t() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        proj_h.C_LONG_LONG.withName("__clang_max_align_nonce1"),
        MemoryLayout.paddingLayout(24)
    ).withName("$anon$19:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfLong __clang_max_align_nonce1$LAYOUT = (OfLong)$LAYOUT.select(groupElement("__clang_max_align_nonce1"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * long long __clang_max_align_nonce1
     * }
     */
    public static final OfLong __clang_max_align_nonce1$layout() {
        return __clang_max_align_nonce1$LAYOUT;
    }

    private static final long __clang_max_align_nonce1$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * long long __clang_max_align_nonce1
     * }
     */
    public static final long __clang_max_align_nonce1$offset() {
        return __clang_max_align_nonce1$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * long long __clang_max_align_nonce1
     * }
     */
    public static long __clang_max_align_nonce1(MemorySegment struct) {
        return struct.get(__clang_max_align_nonce1$LAYOUT, __clang_max_align_nonce1$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * long long __clang_max_align_nonce1
     * }
     */
    public static void __clang_max_align_nonce1(MemorySegment struct, long fieldValue) {
        struct.set(__clang_max_align_nonce1$LAYOUT, __clang_max_align_nonce1$OFFSET, fieldValue);
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

