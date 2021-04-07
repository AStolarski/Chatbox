# Chatbox

### Prosta aplikacja do zdalnej konwersacji

##### Zasada działania

W celu połączenia się dwóch użytkowników jedna z osób musi uruchomić aplikacje w trybie hosta,a druga w trybie klienta.
Następnie osoba z trybu klienta musi wpisać adres IP hosta oraz przepisać numery portów, które wyświetlone są w aplikacji hosta, w pola o tych samych nazwach.
Po naciśnięciu przycisku "Connect", u hosta powinien zniknąć komunikat "Oczekiwanie na połączenie" co oznacza, że obydwie osoby są połączone i można wymieniać się informacjami.

##### Tryb hosta

Żeby uruchomić tryb hosta należy uruchomić aplikację z argumentem "-s".
Przykład komendy w wierszu poleceń:
"java -jar Socket_GUI.jar -s"

##### Tryb klienta

Żeby uruchomić tryb klienta należy dwukrotnie kliknąć na plik Socket_GUI.jar lub uruchomić go z wiersza poleceń bez żadnych argumentów

