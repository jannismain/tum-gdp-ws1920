# Übungsblatt 1 (21.10.19)

## Aufgabe 1: Bunte Reihe

Es gibt m verschiedene Farben mit jeweils n_m Wimpel in dieser Farbe. Bei einer gültigen Wimpelfolge dürfen keine 2 benachbarten Wimpel dieselbe Farbe haben.

### a) Lösungen, falls 3 rote, 2 grüne und 1 blauer Wimpel zur Verfügung stehen

- Wimpel: RRRGGB

Lösungen:

RGRGR + B (6):

```
BRGRGR
RBGRGR
RGBRGR
RGRBGR
RGRGBR
RGRGRB
```

RBRGR + G (5):

```
GRBRGR
RGBRGR
RBGRGR
RBRGGR
RBRGRG
```

RGRBR + G (5):

```
GRGRBR
RGGRBR
RGRGBR
RGRBGR
RGRBRG
```

--> 16 Lösungen

### b) Hinreichende + notwendige Bedingung, dass eine derartige Wimpelfolge existiert

N_m = Menge aller Teilsummen der Wimpel nach Farbe (e.g. 5 blaue, 3 rote --> $N_m = {5, 3}$)

$max(N_m) <= sum(N_m / max(N_m)) - 1$

d.h. die größte Wimpel-Teilsumme muss kleiner als die Summe der restlichen Wimpel-Teilsummen - 1. Nur dann kann garantiert sein, dass Wimpel der gleichen Farbe immer durch einen Wimpel einer anderen Farbe getrennt werden können.

### c) Verfahren zur Konstruktion **einer** Lösung

- Häufigste Wimpelfarbe auslegen
- Mit Zweithäufigster Wimpelfarbe, Wimpel der häufigsten Farbe trennen
- Mit dritthäufigster Wimpelfarbe Wimpel der häufigsten Farbe trennen
- [Wiederhole solange, bis alle Wimpel der häufigsten Farbe voneinerander getrennt sind]
- Restliche Wimpel so einsortieren, dass keine zwei gleichen nebeneinander liegen --> Rekursion
