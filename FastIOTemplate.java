import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class FastIOTemplate {
    static FastIO fastIO = new FastIO();

    static char numero[] = new char[1001];
    static int tamNumero;
    static int digitos[] = new int[10];
    static int i;

    static void problem() {
        String numero = fastIO.next();
        tamNumero = numero.length();

        if (tamNumero%10 != 0) {
            fastIO.println("no subnormal");
            return;
        }

        for (i = 0; i < 10; i++) digitos[i] = 0;

        for (i = 0; i < tamNumero; i++) {
            digitos[numero.charAt(i)-48]++;
            if (digitos[numero.charAt(i)-48] > tamNumero/10) break;
        }

        if (i != tamNumero) {
            fastIO.println("no subnormal");
            return;
        }

        for (i = 0; i < 10; i++) {
            if (digitos[i] != tamNumero/10) break;
        }

        if (i == 10) fastIO.println("subnormal");
        else fastIO.println("no subnormal");
    }

    public static void main(String[] args) {
        while (fastIO.hasNext()) problem();
        fastIO.close();
    }
    
    
    static class FastIO {
        BufferedReader br;
        StringTokenizer st;
        BufferedWriter bw;

        public FastIO() { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        } 

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            } 
            return st.nextToken(); 
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() { 
            String line = "";
            try { line = br.readLine(); } 
            catch (IOException e) { e.printStackTrace(); }
            return line;
        }

        boolean hasNext() {
            try { return br.ready(); }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        void print(String s) {
            try { bw.write(s); }
            catch (IOException e) { e.printStackTrace(); }
        }

        void println(String s) {
            print(s);
            print("\n");
        }

        void flush() {
            try { bw.flush(); }
            catch (IOException e) { e.printStackTrace(); }
        }

        void close() {
            try {
                br.close();
                bw.flush();
                bw.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}