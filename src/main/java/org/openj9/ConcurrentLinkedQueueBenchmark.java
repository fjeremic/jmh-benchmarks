package org.openj9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.infra.ThreadParams;

@Fork(value = 3)
@Warmup(iterations = 3, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Threads(Threads.MAX)
public class ConcurrentLinkedQueueBenchmark {
    public static ConcurrentLinkedQueue<Integer> q = new ConcurrentLinkedQueue<Integer>();

    @State(Scope.Thread)
    public static class Tid {
        public int tid;

        @Setup
        public void setup(ThreadParams threads) {
            tid = threads.getThreadIndex();
        }
    }

    @Benchmark
    public void testInflate(Tid tid) {
        int r = ((1001 + tid.tid) * 10001) % 1000001;
        q.offer(r);
    }
}