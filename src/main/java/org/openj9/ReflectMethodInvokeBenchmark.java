package org.openj9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@Fork(value = 1)
@Warmup(iterations = 10, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ReflectMethodInvokeBenchmark {
    public static Method m;

    private static void process(String str) {
    }

    @Setup
    public void setup() throws NoSuchMethodException, IllegalAccessException {
        m = ReflectMethodInvokeBenchmark.class.getDeclaredMethod("process", String.class);
    }

    @Benchmark
    public void testInvoke() throws IllegalAccessException, InvocationTargetException {
        m.invoke(null, "test");
    }
}
