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
 * typedef size_t (*proj_network_read_range_type)(PJ_CONTEXT *, PROJ_NETWORK_HANDLE *, unsigned long long, size_t, void *, size_t, char *, void *)
 * }
 */
public class proj_network_read_range_type {

    proj_network_read_range_type() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        long apply(MemorySegment ctx, MemorySegment handle, long offset, long size_to_read, MemorySegment buffer, long error_string_max_size, MemorySegment out_error_string, MemorySegment user_data);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
        proj_h.C_LONG,
        proj_h.C_POINTER,
        proj_h.C_POINTER,
        proj_h.C_LONG_LONG,
        proj_h.C_LONG,
        proj_h.C_POINTER,
        proj_h.C_LONG,
        proj_h.C_POINTER,
        proj_h.C_POINTER
    );

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH = proj_h.upcallHandle(proj_network_read_range_type.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(proj_network_read_range_type.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static long invoke(MemorySegment funcPtr,MemorySegment ctx, MemorySegment handle, long offset, long size_to_read, MemorySegment buffer, long error_string_max_size, MemorySegment out_error_string, MemorySegment user_data) {
        try {
            return (long) DOWN$MH.invokeExact(funcPtr, ctx, handle, offset, size_to_read, buffer, error_string_max_size, out_error_string, user_data);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}

