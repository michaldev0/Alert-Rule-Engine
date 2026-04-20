# Alert Rule Engine

## Tests

**The expected outputs for the implemented stages are tested in `src/test/java` with JUnit.**

## Stage 1 - Note about the provided expected output

There seems to be a small mistake in the Stage 1 example output in `TASK_TAKE_HOME.md`.
For value `16`, the file says the output should be `LOW`.

The rules say that:

- numbers divisible by `3` return `LOW`
- numbers divisible by `5` return `ADVISORY`
- numbers divisible by both return `LOWADVISORY`
- other numbers return the original number

`16` is not divisible by `3` or `5`, so this project prints:

```text
16
```
