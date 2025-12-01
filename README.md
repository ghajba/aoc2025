# aoc2025
My AdventOfCode 2025 solutions.
They can be simple, complicated, imperformant... It is for fun, actually, for my own fun.

You can expect Java and Pythons solutions over the 12 days of the event, except for some weekends where I am not at my computer (and I do not like coding on my smartphone).

## AI

I will, as at work too, utilize AI for code completion, and maybe tests. However, it would take the fun if I would use AI to write the code. 


## Daily Reflections

If any.

### Day 01

Well, I wanted to do it only in Java, but with my Python approach. Anyhow, in the end, I ended up at the wrong number in the second part. I even ~refactored~ rewritten the whole part 1 to  be more clear for me to find the error, but did not manage.

Therefore, I went to Python, and did part 2 with Python and solved the problem. Now, with the right answer, I could go back to Java and figure out following:

Python uses modulo differently:

```python
-3 % 100 == 97 
```

but in Java the same is:

```java
-3 % 100 == -3
```

After this little fix, the Java solution worked.