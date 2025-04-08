import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        static class Person
        {
            int p,t;

            public void setT(int t) {
                this.t = t;
            }

            public Person(int p, int t) {
                this.p = p;
                this.t = t;
            }
        }

        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Queue<Person> q= new LinkedList<>();
            HashMap<Integer, Person> map = new HashMap<>();
            for(int i=0;i<N;i++)
            {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                q.add(new Person(p, t));
            }
            int m = Integer.parseInt(br.readLine());
            for(int i=0;i<m;i++)
            {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map.put(c, new Person(p, t));
            }
            int cnt = 0;


            for(int i=0;i<W;i++)
            {
                int t = q.peek().t;
                int p = q.peek().p;
                if(map.containsKey(i))
                {
                    q.add(map.get(i));
                }
                if(t-cnt ==0) {
                    q.poll();
                    cnt =0;
                }
                else if(cnt == T)
                {
                    q.add(new Person(p,t-cnt));
                    q.poll();
                    cnt = 0;
                }
                bw.write(Integer.toString(q.peek().p)+"\n");

                cnt++;
            }
            bw.flush();
        }

    }