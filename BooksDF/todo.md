Stwórz trzy moduły:
- [x] Moduł „api-gen” generujący API z specyfikacji OpenApi przy pomocy pluginu OpenApiTools. 
- [x] Następne moduły powinny podpiąć api-gen poprzez pom.xml
(skorzystanie z Swagger Editor -5 pkt)

- [x] Moduł „bookshop”, który umożliwia 
- [x] wyświetlenie, 
- [x] filtrowanie oraz 
- [x] kupienie książki przez zalogowanego użytkownika.
- [ ] Uprawnienia do dodania/edycji/usunięcia książki powinien mieć administrator.
(brak uprawnień -5 pkt)

- [x] Książka powinna zawierać:
- [x] Autora, 
- [x] Gatunek, 
- [x] Cenę, 
- [x] Ilość stron, 
- [x] licznik odwiedzin, oraz 
- [x] informację czy jest dostępna (ile sztuk).

- [x] Autor powinien być osobną klasą, encją bazodanową.
- [x] Książka, po jej wyszukaniu powinna inkrementować ilość odwiedzin.

- [ ] Zaimplementuj metodę przy użyciu biblioteki feign, aby komunikować się z trzecim modułem. (oraz endpoint dla administratora /order-report który ją wywoła)

- [x] Moduł „book-order” , który przyjmuje listę obiektów {id książki, nazwa, ilość odwiedzin}. 
- [x] Każde 10 odwiedzin danej książki to jedna książka którą należy zamówić do magazynu. 
- [ ] W bazie danych trzymaj jedynie encję {id książki, ilość do zamówienia}.
- [ ] Dodaj endpoint „/print” który stworzy plik .pdf z zamówieniem.
(nie zwracanie pliku, a jedynie informacji -5 pkt)

- [ ] Zadbaj o to by w każdym module była walidacja oraz obsługa błędów wraz z aspektowym ich przechwytywaniem.
(Brak  -10 pkt)

- [ ] Przetestuj aplikacje z użyciem testów jednostkowych.
(Brak -5pkt)