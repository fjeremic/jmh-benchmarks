package org.openj9;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@Fork(value = 3, jvmArgsAppend = { "-Xjit:noRecompile,optLevel=cold", "-Xnoaot" })
@Warmup(iterations = 3, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class StringLatin1Benchmark {
    public static byte[] src;
    public static char[] dst;

    @Param({ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "16", "32", "64", "128" })
    public int len;

    @Setup
    public void setup() {
        src = new byte[130];
        dst = new char[130];

        for (int i = 0; i < src.length; ++i) {
            src[i] = (byte)i;
        }
    }

    @Benchmark
    public void testInflate() {
        StringLatin1.inflate(src, 0, dst, 0, len);
    }
}
