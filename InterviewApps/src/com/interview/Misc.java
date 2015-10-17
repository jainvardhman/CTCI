package com.interview;

import java.util.*;

/**
 * Created by Vardhman on 8/24/2015.
 */
public class Misc {
    public void getMax(int[] B, int N){
        int [][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int i = 1; i <N ; i++){
                dp[i][0] = Math.max(dp[i-1][0],Math.abs(dp[i-1][1] + B[i-1] - 1));
                dp[i][1] = Math.max(dp[i-1][1],Math.abs(dp[i-1][0] + B[i] - 1));
        }

        System.out.println("Max value is :" + Math.max(dp[N-1][0],dp[N-1][1]));
    }
    /*public int getMax_rec(int[] B,int N,int type){
        if(N >= 0) {
            if (type == 1)
                    return Math.abs(1 - B[N-1]) + Math.abs(1 - B[i + 1]) + getMax(B, N, i + 2);
            else
                return Math.abs(1 - B[i]) + Math.abs(B[i + 2] - 1) + getMax(B, N, i + 2);
        }

        else{
            return 0;
        }
    }*/

    public void findAndPrintPath(int[][] pathBox,int startR,int startC,int[][] pathExists){
        findPath(pathBox,startR,startC,pathExists);
        for(int i = 0; i < pathExists.length; i++){
            for(int j=0 ; j< pathExists[0].length; j ++){
                System.out.print(pathExists[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void findPath(int[][] pathBox,int startR,int startC,int[][] pathExists){
        /*if(startR == pathBox.length - 1 && startC == pathBox[0].length -1) {
            System.out.println("Reached");
            return;
        }
        else {
            if (canGoRight(pathBox, startR, startC)) {
                System.out.println(startR + ";" + startC);
                findPath(pathBox, startR, startC + 1);
            }
            if (canGoDown(pathBox, startR, startC)) {
                System.out.println(startR + ";" + startC);
                findPath(pathBox, startR + 1, startC);
            }
        }*/

        if(startC == 0 && startR == 0) {
            pathExists[startR][startC] = 1;
            return;
        }
        else {
            if (startR == pathBox.length - 1 && startC == pathBox[0].length - 1) {
                pathExists[startR][startC] = 1;
            }
            if (canGoUp(pathBox, startR, startC) && pathExists[startR - 1][startC] != 1) {
                pathExists[startR - 1][startC] = 1;
                findPath(pathBox, startR - 1, startC, pathExists);
            }
            if (canGoLeft(pathBox, startR, startC) && pathExists[startR][startC - 1] != 1) {
                pathExists[startR][startC - 1] = 1;
                findPath(pathBox, startR, startC - 1, pathExists);
            }
        }
    }


    public boolean canGoRight(int[][] pathBox,int currentR, int currentC){
        if(currentC < pathBox[0].length -1 && pathBox[currentR][currentC+1] != 0)
            return true;
        else
            return  false;
    }

    public boolean canGoDown(int[][] pathBox,int currentR, int currentC){
        if(currentR < pathBox.length -1 && pathBox[currentR+1][currentC] != 0)
            return true;
        else
            return  false;
    }

    public boolean canGoLeft(int[][] pathBox,int currentR, int currentC){
        //System.out.println("Left " + currentR + " " + currentC);
        if(currentC > 0 && pathBox[currentR][currentC-1] != 0)
            return true;
        else
            return  false;
    }

    public boolean canGoUp(int[][] pathBox,int currentR, int currentC){
        //System.out.println("Up " + currentR + " " + currentC);
        if(currentR > 0  && pathBox[currentR-1][currentC] != 0)
            return true;
        else
            return  false;
    }


    public void magicIndex(int[] arr){
        System.out.println("The magic index is : " + processHalfArray(arr,0,arr.length-1));
    }

    public int processHalfArray(int [] arr,int start,int end){
        if(end <  start)
            return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == mid)
            return mid;
        //if(arr[mid]>mid) {
        int left = processHalfArray(arr, start, Math.min(mid - 1, arr[mid]));
        if(left >= 0)
            return  left;

        int right =  processHalfArray(arr, Math.max(mid + 1, arr[mid]), end);
        if(right >= 0)
            return right;
        //}
        //else {
        //}
        return -1;
    }

    public void mult(int x,int y){
        int times = Math.min(x, y);
        int num = Math.max(x, y);
        Hashtable<Integer,Integer> timesVal = new Hashtable<Integer,Integer>();
        System.out.println(num + " times " + times + " = " + recursive_mult(num,times,timesVal));
    }

    public int recursive_mult(int num, int times,Hashtable<Integer,Integer> timesVal){
        if(times > 0) {
            if (timesVal.containsKey(times)) {
                System.out.println("Taking value of "+ times + " from hashtable");
                return timesVal.get(times);
            }
            else {
                int ans = 0;
                if (times % 2 == 0)
                    ans = recursive_mult(num, times / 2, timesVal) + recursive_mult(num, times / 2, timesVal);
                else
                    ans = num + recursive_mult(num, (times - 1) / 2, timesVal) + recursive_mult(num, (times - 1) / 2, timesVal);
                timesVal.put(times, ans);
                System.out.println("putting " + num + " times " + times + " = " + ans);
                return ans;
            }
        }
        else
            return 0;
    }

    public void towers_of_hanoi(int N){
        Stack start = new Stack();
        Stack helper = new Stack();
        Stack target = new Stack();

        for(int i = N ; i > 0 ; i --) {
            start.push(i);
        }

        move_tower(N,start,target,helper);
        while(target.top.data != -1){
            System.out.println("Popping from target " + target.top.data);
            target.pop();
        }

    }

    public void move_tower(int disk,Stack start, Stack target, Stack helper){
        if(disk == 1){
            move_disk(start,target);
        }

        else{
            move_tower(disk-1,start,helper,target);
            move_disk(start, target);
            move_tower(disk - 1, helper, target, start);
        }
    }

    public void move_disk(Stack start,Stack target){
        if(start.top.data != -1){
            target.push(start.top.data);
            start.pop();
        }
    }

    public void paren(int N){
        Hashtable<Integer,ArrayList<String>> combs = new Hashtable<Integer,ArrayList<String>>();
        paren_rec(N,combs);

        for(String comb : combs.get(N)){
            System.out.println(comb);
        }
    }

    public void paren_rec(int N,Hashtable<Integer,ArrayList<String>> combs){
        ArrayList<String> comb = new ArrayList<String>();
        if(N == 1) {
            comb.add("()");
            combs.put(1,comb);
            return;
        }
        else {
            paren_rec(N-1,combs);
            for (String combItr : combs.get(N - 1)) {
                if(!comb.contains(getCombinationString(combItr, 1)))
                    comb.add(getCombinationString(combItr, 1));
                if(!comb.contains(getCombinationString(combItr, 2)))
                    comb.add(getCombinationString(combItr, 2));
                if(!comb.contains(getCombinationString(combItr, 3)))
                    comb.add(getCombinationString(combItr, 3));
            }
            combs.put(N,comb);
        }
    }

    public String getCombinationString(String comb,int type){
        if(type == 1)
            return "(" + comb + ")";
        else if (type == 2)
            return "()" + comb;
        else
            return comb + "()";
    }

    public void represent_cents(int cents){
        Hashtable<Integer,Integer> cent_repr = new Hashtable<Integer,Integer>();
        System.out.println("Number of ways = " + represent_cents_rec(cents,cent_repr));
    }

    public int represent_cents_rec(int cents,Hashtable<Integer,Integer> cent_repr){
        int repr_ways = 0;
        if(cents <=0)
            return 0;
        if(cent_repr.containsKey(cents))
            return cent_repr.get(cents);
        else {
            /*if(cents == 1)
                repr_ways = 1;
            else if (cents > 1 && cents <5)
                repr_ways = 1;
            else if (cents == 5)
                repr_ways = 1 + represent_cents_rec(cents - 1,cent_repr);
            else if (cents > 5 && cents < 10){
                repr_ways = 1 + repr_ways(cents - 5,cent_repr);    */
            repr_ways = represent_cents_rec(cents - 1,cent_repr) + represent_cents_rec(cents - 5,cent_repr)
                    + represent_cents_rec(cents - 10,cent_repr) + represent_cents_rec(cents - 25,cent_repr);
            cent_repr.put(cents,repr_ways);
            return repr_ways;
        }

        /*if(cents == 1)
            repr_ways = 1;
        else if (cents > 1 && cents <5)
            repr_ways = 1;
        else if (cents == 5)
            repr_ways = 1 + represent_cents_rec(cents - 1,cent_repr);
        else if (cents > 5 && cents < 10){
            repr_ways = 1 + repr_ways(cents - 5,cent_repr);*/


        }


    public void living_people(Hashtable<Integer,ArrayList<Integer>> people,int startYear,int endYear){
        Hashtable<Integer,ArrayList<Integer>> year_mapping = new Hashtable<Integer,ArrayList<Integer>>();
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> it = people.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = it.next();
            int birth = entry.getValue().get(0);
            int death = entry.getValue().get(1);
            //System.out.println("Birth " + birth + " Death " + death);
            if (year_mapping.containsKey(birth)) {
                ArrayList<Integer> birth_alist = year_mapping.get(birth);
                birth_alist.set(0, birth_alist.get(0) + 1);
                year_mapping.put(birth, birth_alist);
                //System.out.println("Year " + birth + " " + birth_alist.get(0) + " " + birth_alist.get(1));
            } else {
                ArrayList<Integer> birth_alist = new ArrayList<Integer>();
                birth_alist.add(1);
                birth_alist.add(0);
                //System.out.println("Year " + birth + " " + birth_alist.get(0) + " " + birth_alist.get(1));
                year_mapping.put(birth, birth_alist);
            }

            if (year_mapping.containsKey(death)) {
                ArrayList<Integer> death_alist = year_mapping.get(death);
                death_alist.set(1, death_alist.get(1) + 1);
                //System.out.println("Year " + death + " " + death_alist.get(0) + " " + death_alist.get(1));
                year_mapping.put(death, death_alist);
            } else {
                ArrayList<Integer> death_alist = new ArrayList<Integer>();
                death_alist.add(0);
                death_alist.add(1);
                //System.out.println("Year " + death + " " + death_alist.get(0) + " " + death_alist.get(1));
                year_mapping.put(death, death_alist);
            }
        }

            //it = year_mapping.entrySet().iterator();
            Hashtable<Integer,Integer> people_alive = new Hashtable<Integer,Integer>();

            for(int i = startYear ; i <=endYear; i++){
                int alive = 0;
                if(i == startYear)
                    alive = year_mapping.get(i).get(0);
                else
                    alive = people_alive.get(i-1) - year_mapping.get(i-1).get(1) + year_mapping.get(i).get(0);
                people_alive.put(i,alive);
                System.out.println("Alive in " + i + " = " + alive);
            }

    }


    public void diving_board(int K){
        Hashtable<Integer,ArrayList<Integer>> combs = new Hashtable<Integer,ArrayList<Integer>>();
        for(int i=1;i <=K ; i++){
            ArrayList<Integer> lengths = new ArrayList<Integer>();
            if(i==1){
                lengths.add(1);
                lengths.add(2);
                combs.put(i,lengths);
            }
            else{
                ArrayList<Integer> prev = combs.get(i-1);
                ArrayList<Integer> current = new ArrayList<Integer>();
                for(Integer l:prev){
                    int lengthShort = 1 + l;
                    int lengthLong = 2 + l;
                    if(!current.contains(lengthShort))
                        current.add(lengthShort);
                    if(!current.contains(lengthLong))
                        current.add(lengthLong);
                }
                combs.put(i,current);
            }
        }

        ArrayList<Integer> kPlanks = combs.get(K);
        for(int i = 0; i < kPlanks.size(); i++){
            System.out.println("Possible plank size = " + kPlanks.get(i));
        }
    }


    public int power(int num,int exponent){
        if(exponent > 1) {
            if (exponent % 2 == 0) {
                return power(num * num, exponent / 2);
            } else {
                return num * power(num * num, (exponent - 1 )/ 2);
            }
        }
        else
            return num;
    }

    public void coin_change(int amount,ArrayList<Integer> denom){
        Collections.sort(denom);
        System.out.println(denom);
        int[][] coinArray = new int[denom.size()][amount];
        for(int i =0; i< denom.size(); i++){
            for(int j = 0; j < amount; j++){
                if(i == 0){
                   coinArray[i][j] = (int) Math.ceil(j+1/denom.get(i));
                }
                else {
                    if(j+1 < denom.get(i))
                        coinArray[i][j] = coinArray[i-1][j];
                    else{
                        int prev = j - denom.get(i);
                        if(prev < 0) {
                            prev = 0;
                            coinArray[i][j] = Math.min(coinArray[i-1][j],1+ prev);
                        }
                        else
                            coinArray[i][j] = Math.min(coinArray[i-1][j],1+ coinArray[i][prev]);
                    }
                }
            }
        }

        for(int i = 0; i< denom.size(); i++){
            for(int j=0 ; j< amount; j++){
                System.out.print(coinArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*public String look_and_say(int n){
        String strOut = "11";
        if(n == 1)
            return "1";
        else if(n== 2)
            return "11";
        else {
            int pivot = 0;
            String current = "";
            for(int i = 3 ; i <= n ; i++){

            }
        }
    }*/

    /*public void store_water(int[] pillars){
        int leftBound = pillars[0];

        int totalWater = 0;
        for(int i = 1 ; i < pillars.length ; i++){
            if(leftBound > pillars[i]){
                maxLeft
            }
            else
                leftBound = Math.max(leftBound,pillars[i]);
        }

    }*/

    /*public int tiling(int heightCol, int width){
        if(heightCol == 2){
            if(width >=2){
                return 2 + tiling(heightCol-1,width - 2) + tiling(heightCol-2, width - 1);
            }
            else{
              return 1;
            }
        }
        else {
            if(width > 2)
                return 1 + tiling(0,width-2);
        }
    }*/

    }
