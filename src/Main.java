import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        // uzimamo niz dece "Maria George Peter", zbog toga smo koristili bufferedreader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // splitujemo "Maria George Peter" i dobijamo pojedinacna imena koja nam cine niz
        String[] names = reader.readLine().split(" ");
        // n - toss
        int num = Integer.parseInt(reader.readLine());

        // simulacija kruga/reda dece
        ArrayDeque<String> children = new ArrayDeque<>();
        // dodavanje dece
        for (int i = 0; i < names.length; i++) {
            children.offer(names[i]);
        }

        // simulacija ovih n toss-eva
        while (children.size() > 1) {
            // rotacija, za svaki toss izbacujemo po jedno dete
            for (int i = 0; i < num; i++) {
                String rotate = children.poll();
                children.offer(rotate);
            }
            // ispisujemo uklonjeno dete
            System.out.println("Removed " + children.pollLast());
        }

        // na kraju, ispisujemo poslednje dete
        System.out.println("Last is " + children.poll());
    }
}