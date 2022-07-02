package com.bill.performanceTest;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput, Mode.AverageTime})
@Warmup(iterations = 2)
@Measurement(iterations = 2, time = 1 )
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2)
@Threads(12)
@State(Scope.Thread)
@OperationsPerInvocation
public class Test {
    @Benchmark
    public void test_logN(Blackhole blackhole) { // O(log n)
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i = i * 2) {
            sb.append(i);
        }
        blackhole.consume(sb.toString());
    }

    @Benchmark
    public void test_N(Blackhole blackhole) { // O(n)
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        blackhole.consume(sb.toString());
    }

    @Benchmark
    public void test_NlogN(Blackhole blackhole) {  // n(log n)
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j = j * 2) {
                sb.append(j);
            }
        }
        blackhole.consume(sb.toString());
    }

    @Param({"100", "1000", "10000"})
    private int n;

    @Setup
    public void setup() {
    }

    @TearDown
    public void tearDown() {
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Test.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON)
//                .output("/Users/bill/backendProject/performanceTest/jmh-benchmark/result.json")
                .build();
        new Runner(opt).run();
    }
}
