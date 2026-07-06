# Lab 2

## Task 1: Baseline - Measuring Performance

The following performance was measured using the default scheduler of xv6:

| Measurement | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ----------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Ticks       | 23  | 23  | 24  | 24  | 24  | 23  | 24  | 23  | 24  | 24  |

Average: 23.6

## Task 2: Multi-Level Feedback Queue

Performed changes:

- Added `mlfq_scheduler` to `kernel/proc.c`
- Added `mlfq_scheduler` to `kernel/defs.h`
- Added `priority`, `started_at` and `runtime` to `proc` struct
- Set priority and runtime in `allocproc` function in `kernel/proc.c`
- Added `MLFQ_QUEUES_NUM` and `MLFQ_TIME_SLICES` in `kernel/param.h`
- Modified `yield` function to check if a process used its time slice and update the priority appropriately
- Added `started_at` to Round Robin as well

| Measurement | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ----------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Ticks       | 23  | 23  | 24  | 25  | 24  | 24  | 24  | 24  | 24  | 24  |

Average: 23.9

## Task 3: Performance Measurements

1. What is the average of the baseline performance that you measured?

The average for Round Robin was 23.6 ticks.

2. What is the average of the performance measurements for the MLFQ?

The average for MLFQ was 23.9 ticks.
