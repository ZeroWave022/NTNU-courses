# Lab 2

## Task 1: Baseline - Measuring Performance

The following performance was measured using the default scheduler of xv6:

| Measurement | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ----------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Ticks       | 23  | 23  | 24  | 24  | 24  | 23  | 24  | 23  | 24  | 24  |

## Task 2: Multi-Level Feedback Queue

| Measurement | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ----------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Ticks       | 23  | 23  | 24  | 25  | 24  | 24  | 24  | 24  | 24  | 24  |

The performance is very close to Round Robin, the default scheduler of xv6.

The xv6 operating system in itself as well as the benchmark are quite simple.
Furthermore, it could be that the benchmark isn't suited to test the strengths of MLFQ.
We could see real performance differences if we had CPU-bound and I/O-bound processes,
however, the benchmark doesn't test this.
The benchmark at hand creates multiple similar processes, which makes the processes move between queues in a very similar fashion.
This makes MLFQ behave closer to Round Robin, which is the scheduler we're trying to compare MLFQ with.
Based on all these factors, it could be more difficult to see performance differences between the two schedulers.

## Task 3: Performance Measurements

1. What is the average of the baseline performance that you measured?

The average for Round Robin was 23.6 ticks.

2. What is the average of the performance measurements for the MLFQ?

The average for MLFQ was 23.9 ticks.
