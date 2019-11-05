/*
Proszę napisać "grę w życie". Parametry programu:

java lab04 size_x size_y steps preset

gdzie wszystkie parametry programu są typu całkowitego i mają następujące znaczenie:

size_x, size_y - rozmiar planszy
steps - liczba kroków symulacji do wykonania
preset - w zależności od wartości ustawia jedną z plansz predefiniowanych:
 0 - losowy rozkład (przydatna będzie funkcja Math.random())
 1 - na środku planszy umieszczona jest "łódź" (niezmiennik)
 
 .....
 .XX..
 .X.X.
 ..X..
 .....
 
 2 - na środku planszy umieszczony jest "blinker" (oscylator)
 
 .....
 ..X..
 ..X..
 ..X..
 .....
 
 3 - na środku planszy umieszczony jest "szybowiec" (jest to tzw "spaceship" - odleci on poza plansze)
 
 .....
 .XXX.
 .X...
 ..X..
 .....
 
Ouptput z programu powinien wyglądać jak następuje:

------ 1 --------
.....X...........
.....X...........
...X.............
...X.............
...X......X...X..
......X....X.....
------ 2 --------
....X....X....X..

itd. przez "steps" kroków. Uwaga - 2 punkty rezerwuję sobie za ładną "obiektywność" rozwiązania.
 
 
Tym co nie pamiętają przypominam, że w grze w życie każda komórka ma 8 sąsiadów a reguły są jak następuje:
 
1) Martwa komórka, która ma dokładnie 3 żywych sąsiadów, staje się żywa w następnej jednostce czasu (rodzi się)
2) Żywa komórka z 2 albo 3 żywymi sąsiadami pozostaje nadal żywa; przy innej liczbie sąsiadów umiera (z "samotności" albo "zatłoczenia").

Miłej zabawy.
*/


public class lab04 {

    public static void main(String[] args) throws InterruptedException {
        int size_x = Integer.parseInt(args[0]);
        int size_y = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        LifeArray array = new LifeArray(size_x, size_y, steps, preset);

        array.RunGame();
        
    }
}