import java.util.*;
class Solution {
    public static class node implements Comparable<node>{
        int index;
        int time;
        String title;
        String content;
        public node(int index,int time, String title, String content){
            this.index=index;
            this.time=time;
            this.title=title;
            this.content=content;
        }
        @Override
        public int compareTo(node b){
            if(this.time!=b.time)return b.time-this.time;
            return this.index-b.index;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String cm = convert(m);
        List<node> list = new ArrayList<>();
        for(int i=0;i<musicinfos.length;i++){
            String s[]=musicinfos[i].split(",");
            String starts[] = s[0].split(":");
            String ends[] = s[1].split(":");
            int time = 60*(Integer.parseInt(ends[0])-Integer.parseInt(starts[0]))+(Integer.parseInt(ends[1])-Integer.parseInt(starts[1]));
            String title = s[2];
            String content = convert(s[3]);
            list.add(new node(i+1,time,title,content));
            
            
        }
        Collections.sort(list);
        
        for(int i=0;i<list.size();i++){
            node now = list.get(i);
            int t= now.time;
            String ti = now.title;
            String co = now.content;
            
            if(co.length()>=t){
                String splits = co.substring(0,t);
                if(splits.contains(cm))return ti;
            }else{
                String newco="";
                int len=co.length();
                // 1. 악보 전체를 반복하는 횟수만큼 붙이기
                for (int j = 0; j < t / len; j++) {
                    newco += co;
                }

                // 2. 남은 길이만큼 원본 악보의 앞에서부터 잘라서 붙이기
                newco += co.substring(0, t % len); 
                // 3. 비교
                if (newco.contains(cm)) {
                    return ti;
                }
            }
        }
        return "(None)";
    }
    public static String convert(String e){
        String converted="";
        for(int i=0;i<e.length();i++){
            if(e.charAt(i)=='#'){
                char before = e.charAt(i-1);
                if(before=='C')converted=converted.substring(0,converted.length()-1)+"H";
                else if(before=='D')converted=converted.substring(0,converted.length()-1)+"I";
                else if(before=='F')converted=converted.substring(0,converted.length()-1)+"J";
                else if(before=='G')converted=converted.substring(0,converted.length()-1)+"K";
                else if(before=='A')converted=converted.substring(0,converted.length()-1)+"L";
                
            }else converted+=String.valueOf(e.charAt(i));
        }
        return converted;
    }
}