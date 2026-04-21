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

## Stage 2

The `LOWADVISORY` case was removed.
The result is built by appending to a `StringBuilder`.

## Stage 3

Rules are stored as a list of `AlertRule` objects.
`AlertRuleEngine` checks the rules one by one and joins labels.

Stage 3 tests check that:

- the output for values `1` to `20` still works
- the engine can use more than two rules
- rule order is preserved

## Stage 4

A new rule was added to Main:

- numbers divisible by `7` return `WARN`

New Stage 4 test checks the required values:

- `21` returns `LOWWARN`
- `35` returns `ADVISORYWARN`
- `105` returns `LOWADVISORYWARN`

