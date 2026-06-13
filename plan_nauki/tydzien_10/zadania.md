# Tydzien 10 - Zadania

## Z10.1 - Refaktoryzacja Figura (z egzaminu 2021 i 2025 - IDENTYCZNE!)
Masz klase Figura ze switchem (patrz README). Zrefaktoryzuj uzywajac wzorca State.
- Usun switch z obwod()
- Stworz interfejs KsztaltFigury i klasy Kolo, Trojkat, Kwadrat
- Figura trzyma referencje do KsztaltFigury
- Dodaj nowy ksztalt Szesciokat bez modyfikacji klasy Figura

## Z10.2 - Gracz ze statusami (z egzaminu 2021 Grp A)
Napisz klase Gracz z metodami ruch(), skok(), cios().
Statusy: Aktywny, Ranny, Spiacy.
- Aktywny: pelne zachowanie
- Ranny: wolniejszy ruch, brak skoku, slaby cios; po ciosie wraca do Aktywny
- Spiacy: zadnych akcji (wypisz "Gracz spi"); po 2 wywolaniach ruch() budzi sie

Uzyj wzorca State. Implementuj setStatus() i delegacje.

## Z10.3 - Automat z napojami
Interfejs `StanAutomatu` z metodami:
- `void wybierzNapoj(Automat a, String napoj)`
- `void wplacMonete(Automat a, double kwota)`
- `void anuluj(Automat a)`

Stany: `Bezczynny`, `NapojWybrany`, `GotowDoWydania`.
Zaimplementuj przejscia: Bezczynny --wybierz--> NapojWybrany --wyplac--> GotowDoWydania.

## Sprawdzenie
1. Co to jest wzorzec projektowy? Podaj 3 kategorie i po 1 przykladzie.
2. Jak wzorzec State realizuje zasade OCP (mozna dodac nowy stan bez modyfikacji glownej klasy)?
3. Jak stan moze zmienic inny stan "od wewnatrz" (np. po ciosie gracz staje sie ranny)?
4. Napisz z pamieci szkielet: interfejs stanu + dwa konkretne stany + klasa z delegacja.
