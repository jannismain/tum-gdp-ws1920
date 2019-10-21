# (F)AQ - (Frequently) Asked Questions

## Aufgabe 8

![ue08-markov-regel](/assets/ue08-markov-regel.png)

**Ist `<|| -> ||< (R1)` korrekt/notwendig?**

- Reicht nicht auch `|| -> 𝜀 (R1)`?
- Produziert R1 wie angegeben nicht `<||||> -> ||||ist gerade`?

*Lösungsvorschlag: Lösung bewahrt Striche absichtlich. Kleinere Ungenauigkeiten (fehlendes Leerzeichen) jedoch kein Fehler.*

## Aufgabe 10

![Verdopplung von Dezimalzahlen (Variante 1)](/assets/Screenshot%202019-12-16%20at%2020.51.45.png)

**Does this really work?**

- 66: `66 -> #66 -> $2#6 -> $2$2# -> $32# -> 132# -> 132` ✅
- 516: `516 -> #516 -> $0#16 -> $02#6 -> $02$2# -> $032# -> 1032# -> 1032` ✅
- 55: `55 -> #55 -> $0#5 -> $0$0# -> $10# -> 110# -> 110` ✅

*Yes!*
