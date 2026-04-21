# AI Reflection

## General reflection

This is similar to a "FizzBuzz" algorithm question, which is generally well-known.

Because of that, if asked to just solve it, most models would present the Stage 1 solution.
If we want the algorithm to be scalable and tested, we need to be more specific and describe the design needed for Stage 3 and the expected tests.

## 1. Which AI tools did you use?

I used Codex with the GPT-5.4 model.

## 2. Describe one interaction with AI that helped you

For the tests of Stage 1, AI suggested using a hardcoded list of values from `1` to `20`.
I remembered that Java has streams for this, but I did not remember the exact syntax, so I asked about it.

My prompt:

```text
List<Integer> values = List.of(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20
        );

        for (String alert : alertsFor(values)) {
            System.out.println(alert);
        }

This is an ugly list is there a more elegant way to write values from 1 to 20 for example with iterators like in C++ with streams?
```

AI suggested using `IntStream.rangeClosed`:

```java
public static void main(String[] args) {
    IntStream.rangeClosed(1, 20)
            .mapToObj(Main::alertFor)
            .forEach(System.out::println);
}
```

I used this idea because it made the code cleaner.

## 3. Describe one AI suggestion that you modified or rejected

For Stage 3, I suggested creating a class for the algorithm: `AlertRuleEngine`.
This class would store the rules and have a `for` loop that iterates through the list, instead of having separate `if` statements for each rule.

The design AI proposed was overcomplicated for this task.
It wanted to create an interface for `AlertRule`, then a class that implements it, and then `AlertRuleEngine`.

I simplified it by having one `AlertRule` that stores the divisor and label and has a method to check divisibility using the stored divisor.
AI also suggested using a Java `record` for it, which I used.
