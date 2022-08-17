### Note

```

    Throughput： 吞吐量，測試每秒可以執行操作的次數
    Average Time： 平均耗時，測試單次操作的平均耗時
    Sample Time：取樣耗時，測試單次操作的耗時，包括最大、最小耗時，已經百分位耗時等
    Single Shot Time： 只計算一次的耗時，一般用來測試冷啟動的效能（不設定JVM預熱）
    All： 測試上面的所有指標
    
    
    Fork
    @Fork註解用來設定啟動的JVM程式數量，多個程式是序列的方式啟動的，多個程式可以減少偶發因素對測試結果的影響。
    
    Thread
    @Thread用來配置執行測試啟動的執行緒數量
    
    Warmup
    @Warmup 用來配置預熱的時間，如下所示配置預熱五輪，每輪1second，也就是說總共會預熱5s左右，在這5s內會不停的迴圈呼叫測試方法，但是預熱時的資料不作為測試結果參考。
    
    @Warmup(iterations = 5, time = 1)

```

### Result

```
    # Warmup: n iterations, m s each   ------------------------------  預熱 n 次, 每次 m 秒
    # Measurement: n iterations, m s each --------------------------- 正式測試 m个迭代，每個 m 秒
    # Timeout: n min per iteration ---------------------------------- testing/per timeout 時間 n min
    # Threads: n thread, will synchronize iterations ----------------- 測試時開 n 個 thread
    # Benchmark mode: Throughput, ops/time --------------------------- 使用 xxx mode (Throughput, Averagetime)
    # Benchmark: com.bill.xxx ---------------------------------------- 測試時的 package
    # Parameters: (size = 10000) ------------------------------------- 測試時 n 值
```

### json to chart

http://deepoove.com/jmh-visual-chart/
