# Multi threaded tasks
This is a simple proof of concept showing how to parallel run tasks.

Multi threading is not just to increase performance, but to prevent blockages in your software. 
With multi threading you do not have to wait for a task to finish before doing some other task.

The variables can be changed to execute desired amount of tasks on desired amount of threads:
``` java
// The amount of tasks you want to perform
int taskAmount = 10;
// The amount of threads you want to use
int threadCount = 2;
```

## Example
Each task takes 1 second(1000 milliseconds) to finish. 
Meaning if you single thread 10 tasks it would take 10 seconds to finish, but this speed can be improved by multi threading.

| Tasks | Threads | Execution time (seconds) |
| ----- | ------- | ------------------------ |
| 10    | 1       | 10                       |
| 10    | 2       | 5                        |
| 10    | 5       | 2                        |
| 10    | 10      | 1                        |

_Performance is only improved when using appropriate CPU(s)._

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Single_vs_multithreaded_processes.jpg/800px-Single_vs_multithreaded_processes.jpg" alt="single vs multi threading" width="550"/>
