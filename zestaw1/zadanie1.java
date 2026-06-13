/*

Zadanie 1. Kolekcje, Iteracja i Haszowanie (25 pkt.)
Proszę napisać od podstaw klasę RejestrWynikow, nie korzystając 
wewnątrz z wbudowanych kolekcji Java Collections Framework 
(należy oprzeć się na tablicach i ręcznym zarządzeniu pamięcią na
 wypadek przepełnienia). Klasa reprezentuje listę ocen studentów.
RejestrWynikow musi implementować interfejs Iterable<Ocena>.
Klasa musi posiadać metody: wstawiającą element 
(void dodajOcene(Ocena o)), zwracającą aktualną ilość elementów 
(int rozmiar()) oraz metodę pozwalającą na sprawdzenie czy 
rejestr jest pusty.
Proszę poprawnie przesłonić metodę equals oraz kompatybilną z 
nią metodę hashCode. Uznajemy, że dwa rejestry są sobie absolutnie 
równe, jeśli posiadają taki sam rozmiar, a na odpowiadających sobie 
indeksach znajdują się identyczne oceny (porównane przez ich własną 
metodę equals).
*/